package com.example.product_order_app.data.responseDTO;

import com.example.product_order_app.data.Grade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDTO {
    private Long id;
    private String name;
    private Grade grade;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
