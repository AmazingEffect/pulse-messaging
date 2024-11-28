package com.pulse.talk.adapter.out.mongo.document.root;

import com.pulse.talk.adapter.out.mongo.document.sub.FileAttachmentDocument;
import com.pulse.talk.adapter.out.mongo.document.sub.ReadReceiptDocument;
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
@Document(collection = "chat_message")
public class ChatMessageDocument {

    @Id
    private String id;  // 메시지 ID

    private String chatRoomId;  // 채팅방 ID

    private String senderId;  // 발신자 ID

    private String content;  // 메시지 내용

    private LocalDateTime sentAt;  // 전송 시간

    private List<FileAttachmentDocument> attachments;  // 첨부파일 리스트

    private List<ReadReceiptDocument> readReceipts;  // 읽음 상태 리스트

}
