package com.labfinal.labfinal.entity.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "measurements")
public class Measurement {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String name;
   private String description;
   private Integer status;
   @Column(name = "created_at")
   private Date createdAt;
   @Column(name = "updated_at")
   private Date updatedAt;

   @PrePersist
   protected void onCreate() {
      this.createdAt = new Date();
   }

   @PreUpdate
   protected void onUpdate() {
      updatedAt = new Date();
   }

}
