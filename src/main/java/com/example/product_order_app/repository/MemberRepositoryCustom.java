package com.example.product_order_app.repository;

import com.example.product_order_app.data.entity.Member;

import java.util.List;

public interface MemberRepositoryCustom {
    List<Member> getMemberListByName(String name);
}
