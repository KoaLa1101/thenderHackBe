package ru.itlab.tenderhackbe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.services.CteServiceImpl;
import ru.itlab.tenderhackbe.services.SellerServiceImpl;

import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    SellerServiceImpl sellerService;

    @Autowired
    CteServiceImpl cteService;

    @GetMapping("/gg/{inn}")
    @CrossOrigin(origins = "http://localhost:63342")
    public List<CTETableDTO> getTesting(@PathVariable String inn) {
        //sellerService.sendNotification();   Вызвать отсылку потчы
        return cteService.getCteId(inn);
    }
}
