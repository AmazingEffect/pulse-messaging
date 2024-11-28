package com.pulse.talk.adapter.out.mongo.document.root;

import com.pulse.talk.adapter.out.mongo.document.sub.ParticipantDocument;
import com.pulse.talk.common.enumerate.ChatRoomStatus;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "chat_room")
public class ChatRoomDocument {

    @Id
    private String id;  // 채팅방 ID

    private List<ParticipantDocument> participants;  // 참여자 리스트 (회원1, 회원2)

    private ChatRoomStatus status;  // 채팅방 상태 (예: ACTIVE, DELETED)

    private LocalDateTime createdAt;  // 채팅방 생성 시간

}
