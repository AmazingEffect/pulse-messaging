package com.pulse.talk.domain.vo;

import com.pulse.talk.domain.id.MemberId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 채팅방 참여자 도메인 객체 (Value Object)
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Participant {

    private MemberId memberId;  // 참여자 회원 ID

    private int unreadMessageCount;  // 해당 참여자가 읽지 않은 메시지 수

    private LocalDateTime joinedAt;  // 참여 시간

}