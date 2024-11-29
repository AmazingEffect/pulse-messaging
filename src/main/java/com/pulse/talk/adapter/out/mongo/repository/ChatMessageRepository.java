package com.pulse.talk.adapter.out.mongo.repository;

import com.pulse.talk.adapter.out.mongo.document.root.ChatMessageDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessageDocument, String> {
    // 특정 채팅방의 메시지를 시간 순으로 조회
    List<ChatMessageDocument> findByChatRoomIdOrderBySentAt(String chatRoomId);
}
