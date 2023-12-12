package com.labfinal.labfinal.entity.dto;

import com.labfinal.labfinal.entity.model.Measurement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementDto {

   private Integer id;
   private String name;
   private String description;
   private Integer status;
   private Date createdAt;
   private Date updatedAt;

   public MeasurementDto(Measurement measurement){
      this.id = measurement.getId();
      this.name = measurement.getName();
      this.description = measurement.getDescription();
      this.status = measurement.getStatus();
      this.createdAt = measurement.getCreatedAt();
      this.updatedAt = measurement.getUpdatedAt();
   }

}
