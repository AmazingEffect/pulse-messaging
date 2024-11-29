package com.pulse.talk.domain;

import com.pulse.talk.domain.id.ChatRoomId;
import com.pulse.talk.common.enumerate.ChatRoomStatus;
import com.pulse.talk.domain.vo.Participant;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 채팅방 도메인 객체
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ChatRoom {

    private ChatRoomId id;  // 채팅방 ID (클래스로 정의)

    private List<Participant> participants;  // 참여자 리스트

    private ChatRoomStatus status;  // 채팅방 상태 (예: ACTIVE, DELETED)

    private LocalDateTime createdAt;  // 생성 시간

}
