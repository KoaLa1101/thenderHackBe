package ru.itlab.tenderhackbe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.tenderhackbe.services.RecSystemService;

import java.io.IOException;

@RestController
public class TestController {
    @Autowired
    private RecSystemService recSystemService;

    @RequestMapping("/getPopularItem")
    public String popularItem() throws IOException {
        return recSystemService.mostPopularItem("01.08.01.14.03.01");
    }
}
