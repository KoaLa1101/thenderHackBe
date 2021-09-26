package ru.itlab.tenderhackbe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.models.ResultDTO;
import ru.itlab.tenderhackbe.repositories.CteRepository;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CteServiceImpl {
    final String COMMA_DELIMITER = ",";

    @Autowired
    private CteRepository cteRepository;
    @Autowired
    private ContractsServiceImpl contractsService;

    public Map<String, List<ResultDTO>> getCteId(String inn) {
        List<String> codes = getCodes(inn);
        Map<String, List<CTETableDTO>> result = new HashMap<>();
        List<CTETableDTO> cteTableDTOList = new ArrayList<>();
        for (String code : codes) {
            cteTableDTOList = cteRepository.getAllIdByKpgz(code).stream().map(CTETableDTO::from).collect(Collectors.toList());
            result.put(code, cteTableDTOList);
        }
        log.info("result {}",result);
        log.info("log from getCteId");
        return contractsService.getMostPopularItemsMap(result);
    }

    private List<String> getCodes(String inn) {
        List<String> codes = new ArrayList<>();
        List<List<String>> allUsers = readCsv();

        for (List<String> list : allUsers) {
            for (String str : list) {
                if(str.equals(inn))
                    codes = list;
            }
        }
        return get3Cats(codes);
    }


    private List<List<String>> readCsv() {

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("df1_map.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            //ignore -- its so bad, but i haven't time
        }
        return records;
    }

    private List<String> get3Cats(List<String> list){
        List<String> topCat = new ArrayList<>();
        topCat.add(list.get(2).substring(3, list.get(2).length()-1));
        topCat.add(list.get(3).substring(2, list.get(3).length()-1));
        topCat.add(list.get(4).substring(2, list.get(4).length()-1));
        return topCat;
    }

}
