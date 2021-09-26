package ru.itlab.tenderhackbe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.models.*;
import ru.itlab.tenderhackbe.repositories.ContractsRepository;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Slf4j
@Service
public class ContractsServiceImpl {
    @Autowired
    private ContractsRepository contractsRepository;
    private @Autowired
    ObjectMapper objectMapper;



    public Map<String,List<ResultDTO>> getMostPopularItemsMap(Map<String, List<CTETableDTO>> cteIDByKPGZCodeMap){
        Map<String,List<ResultDTO>> resultDTOMap = new HashMap<>();
        log.info("started finding");
        for (String i :cteIDByKPGZCodeMap.keySet()) {
            List<ResultDTO> resultDTOList = new ArrayList<>();
            for(CTETableDTO cteTableDTO: cteIDByKPGZCodeMap.get(i)){
                List<ContractsDto> contractsDtoList = contractsRepository.findByCteId(cteTableDTO.getCte_id()).stream().map(ContractsDto::from).collect(Collectors.toList());
                long sum=0;
                for (ContractsDto j:contractsDtoList){
                    sum+=j.getQuantity();
                }
                resultDTOList.add(ResultDTO.builder().CTEName(cteTableDTO.getCte_name()).id(cteTableDTO.getCte_id()).summ(sum).build());
            }
        }
//        cteIDByKPGZCodeMap.forEach((gpkzCode, idCTEInCTETable) -> {
//            List<ResultDTO> resultDTOList = new ArrayList<>();
//
//            idCTEInCTETable.stream().forEach(CTETableDto -> {
//                List<ContractsDto> contractsDtoList = contractsRepository.findByCteId(CTETableDto.getCte_id()).stream().map(contracts -> ContractsDto.from(contracts)).collect(Collectors.toList());
//                LongSummaryStatistics longSummaryStatistics = contractsDtoList
//                        .stream()
//                        .filter(contracts ->Objects.nonNull(contracts) && Objects.nonNull(contracts.getQuantity()))
//                        .map(ContractsDto::getQuantity)
//                        .flatMapToLong(LongStream::of).summaryStatistics();
//                resultDTOList.add(ResultDTO.builder().CTEName(CTETableDto.getCte_name()).summ(longSummaryStatistics.getSum()).id(CTETableDto.getCte_id()).build());
//
//            });
//            List<ResultDTO> finalResultDTOList=resultDTOList.subList(0,3);
//
//            finalResultDTOList.sort(Comparator.comparingLong(ResultDTO::getSumm));
//            log.info(finalResultDTOList.toString());
//            resultDTOMap.put(gpkzCode,finalResultDTOList);
//
//        });

        return resultDTOMap;
    }
}
