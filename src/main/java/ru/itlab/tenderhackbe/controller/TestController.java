package ru.itlab.tenderhackbe.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.services.ContractsServiceImpl;
import ru.itlab.tenderhackbe.services.CteServiceImpl;

import java.util.List;

@Slf4j
@RestController
public class TestController {

    @Autowired
    ContractsServiceImpl contractsService;

    @Autowired
    CteServiceImpl cteService;

    @RequestMapping("/gg/{inn}")
    public List<CTETableDTO> getTesting(@PathVariable String inn) {
        return cteService.getCteId(inn);
    }
}
