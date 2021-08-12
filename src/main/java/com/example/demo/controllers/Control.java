package com.example.demo.controllers;

import com.example.demo.model.CryptoClass;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@Controller
public class Control {

    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "name");
        return "homr";
    }

    @GetMapping(value = "/statistics.month")
    @ResponseBody
    public List<CryptoClass> onStatisticsOnMonth() {
        List<CryptoClass> cryptos = new ArrayList<>();

        return cryptos;
    }

}