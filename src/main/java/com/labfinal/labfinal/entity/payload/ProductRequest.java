package com.labfinal.labfinal.entity.payload;

import com.labfinal.labfinal.entity.model.Measurement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

   private String name;
   private String description;
   private String category;
   private Integer measurementId;
   private String brand;
   private String currency;
   private String details;
   private Integer status;

}
