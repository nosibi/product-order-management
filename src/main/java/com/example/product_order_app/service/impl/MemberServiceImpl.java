package com.example.product_order_app.service.impl;

import com.example.product_order_app.dao.MemberDAO;
import com.example.product_order_app.data.Grade;
import com.example.product_order_app.data.dto.MemberDTO;
import com.example.product_order_app.data.entity.Member;
import com.example.product_order_app.data.responseDTO.MemberResponseDTO;
import com.example.product_order_app.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public void saveMember(MemberDTO member) {
        Member savedMember = new Member();
        savedMember.setName(member.getName());
        savedMember.setGrade(member.getGrade());
        memberDAO.saveMember(savedMember);
    }

    @Override
    public void updateMemberName(Long id, String name) {
        memberDAO.updateMemberName(id,name);
    }

    @Override
    public void updateMemberGrade(Long id, Grade grade) {
        memberDAO.updateMemberGrade(id,grade);
    }

    @Override
    public MemberResponseDTO findMember(Long id) {
        MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
        Member member = memberDAO.findMember(id);

        memberResponseDTO.setId(member.getId());
        memberResponseDTO.setName(member.getName());
        memberResponseDTO.setGrade(member.getGrade());
        memberResponseDTO.setCreatedAt(member.getCreatedAt());
        memberResponseDTO.setUpdatedAt(member.getUpdatedAt());

        return memberResponseDTO;
    }

    @Override
    public List<MemberResponseDTO> findMemberList(String name) {
        List<MemberResponseDTO> responseDTOList = new ArrayList<>();
        List<Member> memberList = memberDAO.findMemberByName(name);

        for(int i = 0; i < memberList.size(); i++){
            MemberResponseDTO memberResponseDTO = new MemberResponseDTO();
            memberResponseDTO.setId(memberList.get(i).getId());
            memberResponseDTO.setName(memberList.get(i).getName());
            memberResponseDTO.setGrade(memberList.get(i).getGrade());
            memberResponseDTO.setCreatedAt(memberList.get(i).getCreatedAt());
            memberResponseDTO.setUpdatedAt(memberList.get(i).getUpdatedAt());
            responseDTOList.add(memberResponseDTO);
        }

        return responseDTOList;
    }

    @Override
    public void deleteMember(Long id) {
        memberDAO.deleteMember(id);
    }
}
