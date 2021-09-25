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

    //Todo вернуть топ 3 популярных товара (id CTE) (+ названия cte) +(наименование поставщика) про поставщика хз, что если у одного товара разные поставщики,
    //каждому коду топ 3 популярных товара по сути отсортировать лист лонгов
    public Map<String,List<ResultDTO>> getMostPopularItemsMap(Map<String, List<CTETableDTO>> cteIDByKPGZCodeMap){
        //строка - код, лист - cteID
        Map<String,List<ResultDTO>> resultDTOMap = new HashMap<>();  //здесь финальбные данные для фронта в dto-шке id, которое ты мне передаёшь, и общая сумма (максимальная)

        cteIDByKPGZCodeMap.forEach((gpkzCode, idCTEInCTETable) -> {
            List<ResultDTO> resultDTOList = new ArrayList<>();// отфильтрованные товары (ID)? Отсюда взять топ 3 т е три первые можно это сделать на фронте, можно здесь

            idCTEInCTETable.stream().forEach(CTETableDto -> { //для каждого id ищется его order(поле в json формате в таблице категории)
                List<Contracts> contractsDtoList = contractsRepository.findByCteId(CTETableDto.getCteId()); //вытащили все такие ContractsDto  Todo изменить от выборки полного кнтракта на срез
                LongSummaryStatistics longSummaryStatistics = contractsDtoList
                        .stream()
                        .map(contracts -> Math.round(contracts.getCte().getQuantity()))
                        .flatMapToLong(LongStream::of).summaryStatistics();  //Посчитали статистику (в ней есть сумма)
                resultDTOList.add(ResultDTO.builder().CTEName(CTETableDto.getCteName()).summ(longSummaryStatistics.getSum()).id(CTETableDto.getCteId()).build());

            });
            resultDTOList.sort(Comparator.comparingLong(ResultDTO::getSumm));
            resultDTOMap.put(gpkzCode,resultDTOList);

        });

        return resultDTOMap;
    }
}
