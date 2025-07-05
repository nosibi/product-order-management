package com.example.product_order_app.controller;

import com.example.product_order_app.data.dto.ProductDTO;
import com.example.product_order_app.data.responseDTO.ProductResponseDTO;
import com.example.product_order_app.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Operation(summary = "상품 정보를 등록하는 API", description = "RequestBody로 상품 정보를 입력 받아 저장")
    @PostMapping("/enroll")
    public ResponseEntity<String> saveProduct(@Validated @RequestBody ProductDTO productDTO){
        productService.saveProduct(productDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Product's Info is saved");
    }

    @Operation(summary = "상품 가격을 수정하는 API", description = "RequestParam으로 상품 가격을 입력 받아 수정")
    @PutMapping("updateprice")
    public ResponseEntity<String> updateProductPrice(@Validated @RequestParam Long id, Integer price){
        productService.updateProductPrice(id,price);
        return ResponseEntity.status(HttpStatus.OK).body("Product's price is updated");
    }

    @Operation(summary = "상품 재고를 수정하는 API", description = "RequestParam으로 상품 재고를 입력 받아 수정")
    @PutMapping("updatestock")
    public ResponseEntity<String> updateProductStock(@Validated @RequestParam Long id, Integer stock){
        productService.updateProductStock(id,stock);
        return ResponseEntity.status(HttpStatus.OK).body("Product's stock is updated");
    }

    @Operation(summary = "상품 정보를 조회하는 API", description = "RequestParam으로 상품 Id를 입력 받아 수정")
    @GetMapping("/select")
    public ResponseEntity<ProductResponseDTO> findProduct(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProduct(id));
    }

    @Operation(summary = "상품 정보를 삭제하는 API", description = "RequestParam으로 상품 Id를 입력 받아 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestParam Long id){
        productService.deleteProduct(id);
        return ResponseEntity.status(HttpStatus.OK).body("Product's Info is deleted");
    }
}
