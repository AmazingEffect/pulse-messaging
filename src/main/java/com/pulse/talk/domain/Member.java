package com.pulse.talk.domain;

import com.pulse.talk.domain.id.MemberId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원 도메인 객체
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Member {

    private MemberId id;  // 회원 ID (클래스로 정의)
    private String name;  // 이름
    private String nickname;  // 닉네임
    private String profilePictureUrl;  // 프로필 사진 URL
    private String statusMessage;  // 상태 메시지

}
