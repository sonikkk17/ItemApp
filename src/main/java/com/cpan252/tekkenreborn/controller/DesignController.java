package com.cpan252.tekkenreborn.controller;

import com.cpan252.tekkenreborn.model.Item;
import com.cpan252.tekkenreborn.model.Item.Brand;
import com.cpan252.tekkenreborn.repository.ItemRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.EnumSet;

@Controller
@Slf4j
@RequestMapping("/design")
public class DesignController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public String design() {
        return "design";
    }

    @ModelAttribute
    public void brands(Model model) {
        var brands = EnumSet.allOf(Brand.class);
        model.addAttribute("brands", brands);
        log.info("brands converted to string:  {}", brands);
    }


    @ModelAttribute
    // This model attribute has a lifetime of a request
    public Item item() {
        return Item
                .builder()
                .build();
    }

    @PostMapping
    public String processItemAddition(@Valid Item item, BindingResult result) {
        if (result.hasErrors()) {
            return "design";
        }
        log.info("Processing item: {}", item);
        itemRepository.save(item);
        return "redirect:/itemlist";
    }


}
