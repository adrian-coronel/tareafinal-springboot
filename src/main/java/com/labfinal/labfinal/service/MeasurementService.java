package com.labfinal.labfinal.service;

import com.labfinal.labfinal.Exception.ElementNoExistsInDB;
import com.labfinal.labfinal.entity.dto.MeasurementDto;
import com.labfinal.labfinal.entity.payload.MeasurementRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeasurementService {

   List<MeasurementDto> findAll();
   MeasurementDto find(Integer id) throws ElementNoExistsInDB;
   MeasurementDto save(MeasurementRequest productRequest);
   MeasurementDto update(Integer id, MeasurementRequest productRequest) throws ElementNoExistsInDB;
   MeasurementDto delete(Integer id) throws ElementNoExistsInDB;

}
