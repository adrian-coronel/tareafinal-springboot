package com.labfinal.labfinal.entity.dto;

import com.labfinal.labfinal.entity.model.Measurement;
import com.labfinal.labfinal.entity.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

   private Integer id;
   private String name;
   private String description;
   private String category;
   private Measurement measurement;
   private String brand;
   private String currency;
   private String details;
   private Integer status;
   private Date createdAt;
   private Date updatedAt;

   public ProductDto(Product product){
      this.id = product.getId();
      this.name = product.getName();
      this.description = product.getDescription();
      this.category = product.getCategory();
      this.measurement = product.getMeasurement();
      this.brand = product.getBrand();
      this.currency = product.getCurrency();
      this.details = product.getDetails();
      this.status = product.getStatus();
      this.createdAt = product.getCreatedAt();
      this.updatedAt = product.getUpdatedAt();
   }

}
