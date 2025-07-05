package com.example.product_order_app.dao.impl;

import com.example.product_order_app.dao.MemberDAO;
import com.example.product_order_app.data.Grade;
import com.example.product_order_app.data.entity.Member;
import com.example.product_order_app.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MemberDAOImpl implements MemberDAO {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void saveMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public void updateMemberName(Long id,String name){
        Member foundMember = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 회원 없음"));
        foundMember.setName(name);
        memberRepository.save(foundMember);
    }

    @Override
    public void updateMemberGrade(Long id, Grade grade) {
        Member foundMember = memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 회원 없음"));
        foundMember.setGrade(grade);
        memberRepository.save(foundMember);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 회원 없음"));
    }

    @Override
    public List<Member> findMemberByName(String name) {
        if(memberRepository.getMemberListByName(name).isEmpty()){
            throw new IllegalArgumentException("해당 회원 없음");
        }else{
            return memberRepository.getMemberListByName(name);
        }
    }

    @Override
    public void deleteMember(Long id) {
        if(memberRepository.findById(id).isPresent()){
            memberRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("해당 회원 없음");
        }
    }
}
