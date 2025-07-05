package com.example.product_order_app.data.dto;

import com.example.product_order_app.configuration.annotation.Name;
import com.example.product_order_app.data.Grade;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    //커스텀 validation으로 유효성 검사
    //회원 이름은 2자 이상 9자 이하
    @Name
    private String name;

    //GOLD,SILVER,BRONZE 등급 외에는 입력 불허
    @com.example.product_order_app.configuration.annotation.Grade
    private Grade grade;
}
