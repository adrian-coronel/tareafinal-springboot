package com.labfinal.labfinal.controller;

import com.labfinal.labfinal.Exception.ElementNoExistsInDB;
import com.labfinal.labfinal.entity.dto.MeasurementDto;
import com.labfinal.labfinal.entity.dto.ProductDto;
import com.labfinal.labfinal.entity.payload.MeasurementRequest;
import com.labfinal.labfinal.entity.payload.MessageResponse;
import com.labfinal.labfinal.entity.payload.ProductRequest;
import com.labfinal.labfinal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/api/v1")
public class ProductController {

   private final ProductService productService;

   @GetMapping("/products")
   public ResponseEntity<?> showAll(){
      List<ProductDto> productDtoList = productService.findAll();
      return new ResponseEntity<>(
          MessageResponse.builder()
              .body(productDtoList)
              .build()
          , HttpStatus.OK
      );
   }

   @GetMapping("/products/{id}")
   public ResponseEntity<?> show(@PathVariable Integer id){
      try {
         ProductDto productDto = productService.find(id);
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .body(productDto)
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

   @PutMapping("/products/{id}")
   public ResponseEntity<?> update(
       @PathVariable Integer id, @RequestBody ProductRequest productRequest){
      try {
         ProductDto productDto = productService.update(id, productRequest);
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .body(productDto)
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

   @DeleteMapping("/products/{id}")
   public ResponseEntity<?> delete(@PathVariable Integer id){
      try {
         ProductDto productDto = productService.delete(id);
         return new ResponseEntity<>(
             MessageResponse.builder()
                 .body(productDto)
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
