package com.example.product_order_app.repository;

import com.example.product_order_app.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long>, MemberRepositoryCustom{
}
