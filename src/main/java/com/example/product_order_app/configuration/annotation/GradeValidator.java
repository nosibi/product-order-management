package com.example.product_order_app.configuration.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GradeValidator implements ConstraintValidator<Grade, com.example.product_order_app.data.Grade> {
    @Override
    public boolean isValid(com.example.product_order_app.data.Grade grade, ConstraintValidatorContext constraintValidatorContext) {
        if(grade != com.example.product_order_app.data.Grade.GOLD && grade != com.example.product_order_app.data.Grade.SILVER && grade != com.example.product_order_app.data.Grade.BRONZE){
            return false;
        }
        return true;
    }
}
