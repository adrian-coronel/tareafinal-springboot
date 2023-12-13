package com.labfinal.labfinal.controller;

import com.labfinal.labfinal.Exception.ElementNoExistsInDB;
import com.labfinal.labfinal.entity.dto.MeasurementDto;
import com.labfinal.labfinal.entity.payload.MeasurementRequest;
import com.labfinal.labfinal.entity.payload.MessageResponse;
import com.labfinal.labfinal.entity.repository.MeasurementRepository;
import com.labfinal.labfinal.service.MeasurementService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MeasurementController {

   private final MeasurementService measurementService;

   @GetMapping("/measurements")
   public ResponseEntity<?> showAll(){
      List<MeasurementDto> measurementDtoList = measurementService.findAll();
      return new ResponseEntity<>(
          MessageResponse.builder()
              .body(measurementDtoList)
              .build()
          , HttpStatus.OK
      );
   }

   @GetMapping("/measurements/{id}")
   public ResponseEntity<?> show(@PathVariable Integer id){
      try {
         MeasurementDto measurementDto = measurementService.find(id);
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .body(measurementDto)
                 .build()
             , HttpStatus.OK
         );
      } catch (ElementNoExistsInDB e) {
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .message(e.getMessage())
                 .build()
             , HttpStatus.OK
         );
      }
   }

   @PostMapping("/measurements")
   public ResponseEntity<?> save(@RequestBody MeasurementRequest measurementRequest){
      MeasurementDto measurementDto = measurementService.save(measurementRequest);
      return new ResponseEntity<>(
          MessageResponse.builder()
              .body(measurementDto)
              .build()
          , HttpStatus.OK
      );
   }

   @PutMapping("/measurements/{id}")
   public ResponseEntity<?> update(
       @PathVariable Integer id, @RequestBody MeasurementRequest measurementRequest){
      try {
         MeasurementDto measurementDto = measurementService.update(id, measurementRequest);
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .body(measurementDto)
                 .build()
             , HttpStatus.OK
         );
      } catch (ElementNoExistsInDB e) {
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .message(e.getMessage())
                 .build()
             , HttpStatus.OK
         );
      }
   }

   @DeleteMapping("/measurements/{id}")
   public ResponseEntity<?> delete(@PathVariable Integer id){
      try {
         MeasurementDto measurementDto = measurementService.delete(id);
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .body(measurementDto)
                 .build()
             , HttpStatus.OK
         );
      } catch (ElementNoExistsInDB e) {
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .message(e.getMessage())
                 .build()
             , HttpStatus.OK
         );
      }
   }
}
