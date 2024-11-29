package com.pulse.talk.domain;

import com.pulse.talk.adapter.out.mongo.document.sub.FileAttachmentDocument;
import com.pulse.talk.adapter.out.mongo.document.sub.ReadReceiptDocument;
import com.pulse.talk.domain.id.ChatMessageId;
import com.pulse.talk.domain.id.ChatRoomId;
import com.pulse.talk.domain.id.MemberId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ChatMessage {

    private ChatMessageId id;  // 메시지 ID (클래스로 정의)

    private ChatRoomId chatRoomId;  // 채팅방 ID

    private MemberId senderId;  // 발신자 ID

    private String content;  // 메시지 내용

    private LocalDateTime sentAt;  // 전송 시간

    private List<FileAttachmentDocument> attachments;  // 첨부파일 리스트

    private List<ReadReceiptDocument> readReceipts;  // 읽음 상태 리스트

}