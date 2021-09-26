package ru.itlab.tenderhackbe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.repositories.CteRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CteServiceImpl {

    @Autowired
    private CteRepository cteRepository;

    public Map<String, List<Long>> getCteId(List<String> codes){
        Map<String, List<Long>> result = new HashMap<>();
        for (String code:codes){
            result.put(code, cteRepository.getAllByKpgzCode(code));
        }
        return result;
    }
}
