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

    public List<CTETableDTO> getCteId(String inn) {
        List<String> codes = getCodes(inn);
        List<CTETableDTO> result = new ArrayList<>();
        for (String i:codes){
            result.add(CTETableDTO.builder().cte_id(i).cte_name(cteRepository.getById(Long.parseLong(i)).getCteName()).build());
        }
        return result;
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
        return get5Cats(codes);
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

    private List<String> get5Cats(List<String> list){
        List<String> topCat = new ArrayList<>();
        topCat.add(list.get(1).substring(3, list.get(1).length()-1));
        topCat.add(list.get(2).substring(2, list.get(2).length()-1));
        topCat.add(list.get(3).substring(2, list.get(3).length()-1));
        topCat.add(list.get(4).substring(2, list.get(4).length()-1));
        topCat.add(list.get(5).substring(2, list.get(5).length()-1));
        return topCat;
    }

}
