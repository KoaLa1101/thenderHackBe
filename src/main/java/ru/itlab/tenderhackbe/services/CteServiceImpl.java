package ru.itlab.tenderhackbe.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.repositories.CteRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CteServiceImpl {
    final String COMMA_DELIMITER = ",";

    @Autowired
    private CteRepository cteRepository;

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
        try (BufferedReader br = new BufferedReader(new FileReader("result_map_names_price.csv"))) {
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
        topCat.add(list.get(1).substring(2));
        topCat.add(list.get(2).substring(1));
        topCat.add(list.get(3).substring(1));
        topCat.add(list.get(4).substring(1));
        topCat.add(list.get(5).substring(1, list.get(5).length()-2));
        return topCat;
    }

}
