package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.model.Item.Brand;
import com.cpan252.tekkenreborn.model.User;
import com.cpan252.tekkenreborn.repository.ItemRepository;
import com.cpan252.tekkenreborn.repository.ItemRepositoryPaginated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.EnumSet;


@Controller
@Slf4j
@RequestMapping("/designadmin")
public class DesignAdmin {
    private ItemRepository itemRepository;
    private ItemRepositoryPaginated itemRepositoryPaginated;

    public DesignAdmin(ItemRepository itemRepository, ItemRepositoryPaginated itemRepositoryPaginated) {
        this.itemRepository = itemRepository;
        this.itemRepositoryPaginated = itemRepositoryPaginated;
    }

    @GetMapping
    public String designAdmin(Model model) {
        return "designadmin";
    }

    @ModelAttribute
    public void items(Model model) {
        var items = itemRepository.findAll();
        model.addAttribute("items", items);
    }


    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("items converted to string:  {}", brands);
    }

    @PostMapping("/delete/{itemId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteItem(@AuthenticationPrincipal User user, @PathVariable Long itemId) {
        log.info("User {} is deleting item {}", user.getAuthorities(), itemId);
        // Delete the item from the repository
        itemRepository.deleteById(itemId);
        // Redirect to the items list page (or any other desired page)
        return "redirect:/designadmin";
    }
    @PostMapping("/deleteAllItems")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String processItemsDeletion(@AuthenticationPrincipal User user) {
        log.info("User {} is deleting all items", user.getAuthorities());
        // Delete all items from the repository
        itemRepository.deleteAll();
        // Redirect to the items list page (or any other desired page)
        return "redirect:/designadmin";
    }


}
