package com.example.product_order_app.controller;

import com.example.product_order_app.data.Grade;
import com.example.product_order_app.data.dto.MemberDTO;
import com.example.product_order_app.data.responseDTO.MemberResponseDTO;
import com.example.product_order_app.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Operation(summary = "회원 정보를 등록하는 API", description = "RequestBody로 회원 정보를 입력 받아 저장")
    @PostMapping("/enroll")
    public ResponseEntity<String> saveMember(@Validated @RequestBody MemberDTO memberDTO){
        memberService.saveMember(memberDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Member's info is saved");
    }

    @Operation(summary = "회원 이름을 수정하는 API", description = "RequestParam으로 회원 이름을 입력 받아 수정")
    @PutMapping("/updatename")
    public ResponseEntity<String> updateMemberName(@Validated @RequestParam Long id, String name){
        memberService.updateMemberName(id,name);
        return ResponseEntity.status(HttpStatus.OK).body("Member's name is changed");
    }

    @Operation(summary = "회원 등급을 수정하는 API", description = "RequestParam으로 회원 등급을 입력 받아 수정.(GOLD,SILVER,BRONZE)")
    @PutMapping("/updategrade")
    public ResponseEntity<String> updateMemberGrade(@Validated @RequestParam Long id, Grade grade){
        memberService.updateMemberGrade(id,grade);
        return ResponseEntity.status(HttpStatus.OK).body("Member's grade is changed");
    }

    @Operation(summary = "회원 정보를 조회하는 API", description = "RequestParam으로 회원 Id를 입력 받아 조회")
    @GetMapping("/select")
    public ResponseEntity<MemberResponseDTO> findMember(@RequestParam Long id){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMember(id));
    }

    @Operation(summary = "회원 리스트를 조회하는 API", description = "RequestParam으로 회원 이름을 받아 리스트 조회")
    @GetMapping("/selectlist")
    public ResponseEntity<List<MemberResponseDTO>> findMemberList(@RequestParam String name){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findMemberList(name));
    }

    @Operation(summary = "회원 정보를 삭제하는 API", description = "RequestParam으로 회원 Id를 입력 받아 삭제")
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(@RequestParam Long id){
        memberService.deleteMember(id);
        return ResponseEntity.status(HttpStatus.OK).body(id + " Member is deleted");
    }

}
