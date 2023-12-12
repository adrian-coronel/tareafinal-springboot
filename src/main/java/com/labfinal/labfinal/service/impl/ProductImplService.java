package com.labfinal.labfinal.service.impl;

import com.labfinal.labfinal.Exception.ElementNoExistsInDB;
import com.labfinal.labfinal.entity.dto.ProductDto;
import com.labfinal.labfinal.entity.model.Measurement;
import com.labfinal.labfinal.entity.model.Product;
import com.labfinal.labfinal.entity.payload.ProductRequest;
import com.labfinal.labfinal.entity.repository.MeasurementRepository;
import com.labfinal.labfinal.entity.repository.ProductRepository;
import com.labfinal.labfinal.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductImplService implements ProductService {

   private final ProductRepository productRepository;
   private final MeasurementRepository measurementRepository;

   @Override
   public List<ProductDto> findAll() {
      return productRepository.findAll().stream()
          .map(ProductDto::new)
          .toList();
   }

   @Override
   public ProductDto find(Integer id) throws ElementNoExistsInDB {
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new ElementNoExistsInDB("Product con id "+id+" no existe"));
      return new ProductDto(product);
   }

   @Override
   public ProductDto save(ProductRequest productRequest) throws ElementNoExistsInDB {
      Measurement measurement =  measurementRepository.findById(productRequest.getMeasurementId())
          .orElseThrow(() -> new ElementNoExistsInDB("Measurement con id "+productRequest.getMeasurementId()+" no existe"));

      Product product = productRepository.save(
         Product.builder()
             .name(productRequest.getName())
             .description(productRequest.getDescription())
             .category(productRequest.getCategory())
             .measurement(measurement)
             .currency(productRequest.getCurrency())
             .details(productRequest.getDetails())
             .status(productRequest.getStatus())
             .build()
      );
      return new ProductDto(product);
   }

   @Override
   public ProductDto update(Integer id, ProductRequest productRequest) throws ElementNoExistsInDB {
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new ElementNoExistsInDB("Product con id "+id+" no existe"));
      Measurement measurement =  measurementRepository.findById(productRequest.getMeasurementId())
          .orElseThrow(() -> new ElementNoExistsInDB("Measurement con id "+productRequest.getMeasurementId()+" no existe"));

      product.setName(productRequest.getName());
      product.setDescription(productRequest.getDescription());
      product.setCategory(productRequest.getCategory());
      product.setMeasurement(measurement);
      product.setBrand(productRequest.getBrand());
      product.setDetails(productRequest.getDetails());
      product.setStatus(product.getStatus());

      product = productRepository.save(product);

      return new ProductDto(product);
   }

   @Override
   public ProductDto delete(Integer id) throws ElementNoExistsInDB {
      Product product = productRepository.findById(id)
          .orElseThrow(() -> new ElementNoExistsInDB("Product con id "+id+" no existe"));
      productRepository.delete(product);
      return new ProductDto(product);
   }
}
