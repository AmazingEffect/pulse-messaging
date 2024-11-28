package com.pulse.talk.adapter.in.kafka.member.event.outbox;

public interface OutboxEvent {

    Long getPayload();

    String getEventType();

}
