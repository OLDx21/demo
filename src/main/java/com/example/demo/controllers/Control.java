package com.example.demo.controllers;

import com.example.demo.model.CryptoClass;
import com.example.demo.service.CryptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class Control {
    @Autowired
    CryptoService repository;

    /**
     * Task 3
     */

    @GetMapping("/")
    @ResponseBody
    public Page<CryptoClass> greeting(@PageableDefault Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Task 6
     */
    @GetMapping(value = "/statmonth")
    @ResponseBody
    public List<CryptoClass> onStatisticsOnMonth(@RequestParam(name = "month") int month,@RequestParam(name = "years") int years) {
        return repository.getStatistics(month,years);
    }

}