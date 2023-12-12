package com.labfinal.labfinal.service;

import com.labfinal.labfinal.Exception.ElementNoExistsInDB;
import com.labfinal.labfinal.entity.dto.ProductDto;
import com.labfinal.labfinal.entity.payload.ProductRequest;

import java.util.List;

public interface ProductService {

   List<ProductDto> findAll();
   ProductDto find(Integer id) throws ElementNoExistsInDB;
   ProductDto save(ProductRequest productRequest) throws ElementNoExistsInDB;
   ProductDto update(Integer id, ProductRequest productRequest) throws ElementNoExistsInDB;
   ProductDto delete(Integer id) throws ElementNoExistsInDB;

}
