package com.example.product_order_app.dao;

import com.example.product_order_app.data.Grade;
import com.example.product_order_app.data.entity.Member;

import java.util.List;

public interface MemberDAO {
    //회원 정보 등록
    void saveMember(Member member);

    //회원 이름 수정
    void updateMemberName(Long id,String name);

    //회원 등급 수정
    void updateMemberGrade(Long id, Grade grade);

    //회원 조회(id)
    Member findMember(Long id);

    //회원 조회(이름)
    List<Member> findMemberByName(String name);

    //회원 삭제
    void deleteMember(Long id);
}
