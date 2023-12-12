package com.labfinal.labfinal.service.impl;

import com.labfinal.labfinal.Exception.ElementNoExistsInDB;
import com.labfinal.labfinal.entity.dto.MeasurementDto;
import com.labfinal.labfinal.entity.model.Measurement;
import com.labfinal.labfinal.entity.payload.MeasurementRequest;
import com.labfinal.labfinal.entity.repository.MeasurementRepository;
import com.labfinal.labfinal.service.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementImplService implements MeasurementService {

   private final MeasurementRepository measurementRepository;

   @Override
   public List<MeasurementDto> findAll() {
      return measurementRepository.findAll().stream()
          .map(MeasurementDto::new)
          .toList();
   }

   @Override
   public MeasurementDto find(Integer id) throws ElementNoExistsInDB {
       Measurement measurement =  measurementRepository.findById(id)
          .orElseThrow(() -> new ElementNoExistsInDB("Measurement con id "+id+" no existe"));
       return new MeasurementDto(measurement);
   }

   @Override
   public MeasurementDto save(MeasurementRequest productRequest) {
      Measurement measurement = measurementRepository.save(
          Measurement.builder()
              .name(productRequest.getName())
              .description(productRequest.getDescription())
              .status(productRequest.getStatus())
              .build()
      );
      return new MeasurementDto(measurement);
   }

   @Override
   public MeasurementDto update(Integer id, MeasurementRequest productRequest) throws ElementNoExistsInDB {
      Measurement measurement =  measurementRepository.findById(id)
          .orElseThrow(() -> new ElementNoExistsInDB("Measurement con id "+id+" no existe"));
      measurement.setName(productRequest.getName());
      measurement.setDescription(productRequest.getDescription());
      measurement.setStatus(productRequest.getStatus());

      measurement = measurementRepository.save(measurement);

      return new MeasurementDto(measurement);
   }

   @Override
   public MeasurementDto delete(Integer id) throws ElementNoExistsInDB {
      Measurement measurement =  measurementRepository.findById(id)
          .orElseThrow(() -> new ElementNoExistsInDB("Measurement con id "+id+" no existe"));
      measurementRepository.delete(measurement);
      return new MeasurementDto(measurement);
   }
}
