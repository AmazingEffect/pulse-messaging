package com.pulse.talk.adapter.in.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ChatMessageListener {

    @KafkaListener(topics = "chat-room-messages", groupId = "chat-group")
    public void listenChatMessage(String message, Acknowledgment acknowledgment) {
        // 메시지 수신 후 처리 로직
        log.info("Received message: {}", message);

        // 메시지 처리 완료 후, 수동으로 offset ack
        acknowledgment.acknowledge();
    }

}
