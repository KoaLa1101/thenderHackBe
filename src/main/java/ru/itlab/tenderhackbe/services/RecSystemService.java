package ru.itlab.tenderhackbe.services;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class RecSystemService {

    public String mostPopularItem(String category) throws IOException {
        FileInputStream file = new FileInputStream(new File("СТЕ.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        Map<Long, Long> data = new HashMap<>();
        Sheet sheet = workbook.getSheetAt(0);
        for(Row row : sheet){
            if(row.getCell(3).getStringCellValue().equals(category)){
                data.put(Long.parseLong(row.getCell(0).getStringCellValue()), Long.parseLong(row.getCell(3).getStringCellValue()));
            }
        }
        data.entrySet().stream()
                .sorted(Map.Entry.<Long, Long>comparingByValue().reversed());
        return data.get(0).toString();
    }


}
