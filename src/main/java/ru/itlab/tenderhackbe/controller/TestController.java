package ru.itlab.tenderhackbe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.tenderhackbe.services.ContractsServiceImpl;
import ru.itlab.tenderhackbe.services.CteServiceImpl;

@Slf4j
@RestController
public class TestController {

    @Autowired
    ContractsServiceImpl contractsService;

    @Autowired
    CteServiceImpl cteService;

    @GetMapping("/getTest")
    public void getTest() {
  /*      Map<String, List<CTETableDTO>> testMap = new HashMap<>();
        testMap.put("01.20.07.11.03.01.02",
                Arrays.asList(CTETableDTO.builder()
                        .cte_name("Мешки для мусора 60 л, черные, в рулоне 20 шт., ПНД, 10 мкм, 60х72 см, стандарт, КОНЦЕПЦИЯ БЫТА")
                        .cteId("1207503")
                        .build(),
                        CTETableDTO
                                .builder()
                                .cte_name("Мешки для мусора, 120 л, черные, в рулоне 10 шт., ПНД, 15 мкм, 70х110 см, стандарт, КОНЦЕПЦИЯ БЫТА")
                                .cteId("1207504")
                                .build()));
      log.info(  contractsService.getMostPopularItemsMap(testMap).toString());*/
    }

    @GetMapping("/getInfo")
    public void getTestInfo() {
        log.info(cteService.getCteId("7709043455").toString());

    }

    @RequestMapping("/gg")
    public String getTesting() {
        log.info(cteService.getCteId("7709043455").toString());
        return "[{'id':12,'name'='bulat'}]";
    }
}
