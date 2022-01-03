package com.ytc.dec29.controller;

import com.ytc.dec29.service.TicketService;
import com.ytc.dec29.dto.TicketDTO;
import com.ytc.dec29.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/toGetAll")
    public String toGetAll() {
        return "query";
    }

    @RequestMapping("/getAll")
    public String getAll(Model model, TicketDTO ticketDTO, Page page) {
        model.addAttribute("page",this.ticketService.getAll(page, ticketDTO));
        return "results";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }

    @RequestMapping("/add")
    public String add(TicketDTO ticketDTO) {
        System.out.println(ticketDTO.getCompany().toString());
        this.ticketService.add(ticketDTO);
        return "redirect:/ticket/toGetAll";
    }

    @RequestMapping(value = "update")
    public String update(@RequestParam TicketDTO ticketDTO) {
        this.ticketService.update(ticketDTO);
        return "redirect:/ticket/toGetAll";
    }
}
