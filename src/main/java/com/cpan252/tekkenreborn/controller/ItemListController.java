package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.model.Item.Brand;
import com.cpan252.tekkenreborn.model.User;
import com.cpan252.tekkenreborn.model.dto.ItemSearchByDateDto;
import com.cpan252.tekkenreborn.repository.ItemRepository;
import com.cpan252.tekkenreborn.repository.ItemRepositoryPaginated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/itemlist")
public class ItemListController {
    private static final int PAGE_SIZE = 5;
    private ItemRepository itemRepository;

    private ItemRepositoryPaginated itemRepositoryPaginated;

    public ItemListController(ItemRepository itemRepository, ItemRepositoryPaginated itemRepositoryPaginated) {
        this.itemRepository = itemRepository;
        this.itemRepositoryPaginated = itemRepositoryPaginated;
    }

    @GetMapping
    public String showItems(Model model) {
        return "itemlist";
    }

    @ModelAttribute
    public void items(Model model) {
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(0, PAGE_SIZE));
        model.addAttribute("items", itemPage);
        model.addAttribute("currentPage", itemPage.getNumber());
        model.addAttribute("totalPages", itemPage.getTotalPages());
    }
    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
    }

    @ModelAttribute
    public void itemsByDateDto(Model model) {
        model.addAttribute("itemsByDateDto", new ItemSearchByDateDto());
    }

    @PostMapping
    public String searchItemsByDate(@ModelAttribute ItemSearchByDateDto itemsByDateDto,
                                       Model model) {
        model.addAttribute("items", itemRepository.findByBrandFromAndCreatedAt(
                itemsByDateDto.getBrandFrom(),
                itemsByDateDto.getYearOfCreation()));
        return "itemlist";
    }

    @PostMapping("/delete/{itemId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteItem(@AuthenticationPrincipal User user, @PathVariable Long itemId) {
        log.info("User {} is deleting item {}", user.getAuthorities(), itemId);
        // Delete the item from the repository
        itemRepository.deleteById(itemId);
        // Redirect to the items list page (or any other desired page)
        return "redirect:/itemlist";
    }
    @GetMapping("/switchPage")
    public String switchPage(Model model,
                             @RequestParam("pageToSwitch") Optional<Integer> pageToSwitch) {
        var page = pageToSwitch.orElse(0);
        var totalPages = (int) model.getAttribute("totalPages");
        if (page < 0 || page >= totalPages) {
            return "redirect:/itemlist";
        }
        var itemPage = itemRepositoryPaginated.findAll(PageRequest.of(pageToSwitch.orElse(0),
                PAGE_SIZE));
        model.addAttribute("items", itemPage.getContent());
        model.addAttribute("currentPage", itemPage.getNumber());
        return "itemlist";
    }
}
