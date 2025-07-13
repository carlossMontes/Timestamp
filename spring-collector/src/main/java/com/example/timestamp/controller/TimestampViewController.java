package com.example.timestamp.controller;

import com.example.timestamp.service.TimestampService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimestampViewController {

    @Autowired
    private TimestampService service;

    @GetMapping("/")
    public String viewTimestamps(Model model) {
        model.addAttribute("timestamps", service.getAllTimestamps());
        return "timestamps";
    }
}