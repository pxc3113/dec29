package com.ytc.dec29.controller;

import org.springframework.web.bind.annotation.*;

@RestController("/frame")
public class FrameController {
    @RequestMapping("/top")
    public String top() {
        return "frame/top";
    }
    @RequestMapping("/left")
    public String left() {
        return "frame/left";
    }
}
