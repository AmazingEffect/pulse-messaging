package com.pulse.talk.adapter.out.mongo.document.sub;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 채팅방 참여자 정보를 저장하기 위한 MongoDB 서브 도큐먼트
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ParticipantDocument {

    private String memberId;  // 참여자 회원 ID

    private int unreadMessageCount;  // 읽지 않은 메시지 수

    private LocalDateTime joinedAt;  // 참여 시간

}