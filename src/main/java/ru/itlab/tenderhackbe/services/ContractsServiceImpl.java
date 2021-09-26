package ru.itlab.tenderhackbe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.models.*;
import ru.itlab.tenderhackbe.repositories.ContractsRepository;

import java.util.*;
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

        cteIDByKPGZCodeMap.forEach((gpkzCode, idCTEInCTETable) -> {
            List<ResultDTO> resultDTOList = new ArrayList<>();

            idCTEInCTETable.stream().forEach(CTETableDto -> {
                List<Contracts> contractsDtoList = contractsRepository.findByCteId(CTETableDto.getCte_id());
                LongSummaryStatistics longSummaryStatistics = contractsDtoList
                        .stream()
                        .filter(contracts ->Objects.nonNull(contracts) && Objects.nonNull(contracts.getCte()))
                        .map(contracts -> Math.round(contracts.getCte().getQuantity()))
                        .flatMapToLong(LongStream::of).summaryStatistics();
                resultDTOList.add(ResultDTO.builder().CTEName(CTETableDto.getCte_name()).summ(longSummaryStatistics.getSum()).id(CTETableDto.getCte_id()).build());

            });
            List<ResultDTO> finalResultDTOList=resultDTOList.subList(0,3);

            finalResultDTOList.sort(Comparator.comparingLong(ResultDTO::getSumm));
            log.info(finalResultDTOList.toString());
            resultDTOMap.put(gpkzCode,finalResultDTOList);

        });

        return resultDTOMap;
    }
}
