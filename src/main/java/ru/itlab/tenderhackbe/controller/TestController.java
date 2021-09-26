package ru.itlab.tenderhackbe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.services.ContractsServiceImpl;
import ru.itlab.tenderhackbe.services.CteServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class TestController {

    @Autowired
    ContractsServiceImpl contractsService;

    @Autowired
    CteServiceImpl cteService;

    @GetMapping("/getTest")
    public void getTest(){
        Map<String, List<CTETableDTO>> testMap = new HashMap<>();
        testMap.put("01.20.07.11.03.01.02",
                Arrays.asList(CTETableDTO.builder()
                        .cteName("Мешки для мусора 60 л, черные, в рулоне 20 шт., ПНД, 10 мкм, 60х72 см, стандарт, КОНЦЕПЦИЯ БЫТА")
                        .cteId(1207503L)
                        .build(),
                        CTETableDTO
                                .builder()
                                .cteName("Мешки для мусора, 120 л, черные, в рулоне 10 шт., ПНД, 15 мкм, 70х110 см, стандарт, КОНЦЕПЦИЯ БЫТА")
                                .cteId(1207504L)
                                .build()));
      log.info(  contractsService.getMostPopularItemsMap(testMap).toString());
    }

    @RequestMapping("/gg")
    public void getTesting(){
        log.info(cteService.getCteId("7709043455").toString());
    }
}
