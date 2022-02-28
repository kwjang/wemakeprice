package com.project.wemakeprice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = { "/", "/error"})
    public String index() {
        return "index";
    }
}
