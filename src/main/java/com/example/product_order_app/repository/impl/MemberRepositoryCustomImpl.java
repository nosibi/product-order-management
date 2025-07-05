package com.example.product_order_app.repository.impl;

import com.example.product_order_app.data.entity.Member;
import com.example.product_order_app.data.entity.QMember;
import com.example.product_order_app.repository.MemberRepositoryCustom;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Member> getMemberListByName(String name) {
        JPAQuery<Member> query = new JPAQuery<>(entityManager);
        QMember qMember = QMember.member;
        return query.from(qMember).where(qMember.name.eq(name)).orderBy(qMember.createdAt.asc()).fetch();
    }
}
