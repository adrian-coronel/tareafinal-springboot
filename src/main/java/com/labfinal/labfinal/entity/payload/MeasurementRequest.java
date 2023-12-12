package com.labfinal.labfinal.entity.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementRequest {

   private String name;
   private String description;
   private Integer status;

}
