package com.pulse.talk.adapter.out.persistence.repository;

import com.pulse.talk.adapter.out.persistence.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    // 이메일로 회원 조회
    MemberEntity findByEmail(String email);
}