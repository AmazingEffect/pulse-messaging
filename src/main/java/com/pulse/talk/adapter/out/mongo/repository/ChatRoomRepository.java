package com.pulse.talk.adapter.out.mongo.repository;

import com.pulse.talk.adapter.out.mongo.document.root.ChatRoomDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatRoomRepository extends MongoRepository<ChatRoomDocument, String> {
}
