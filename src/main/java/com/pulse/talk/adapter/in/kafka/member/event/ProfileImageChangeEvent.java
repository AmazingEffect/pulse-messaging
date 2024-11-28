package com.pulse.talk.adapter.in.kafka.member.event;

import com.pulse.talk.adapter.in.kafka.member.event.outbox.OutboxEvent;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProfileImageChangeEvent implements OutboxEvent {

    private Long payload;


    /**
     * @return Long
     * @apiNote 이벤트의 페이로드를 반환한다.
     */
    @Override
    public Long getPayload() {
        return payload;
    }


    /**
     * @return String
     * @apiNote 이벤트의 타입을 반환한다.
     */
    @Override
    public String getEventType() {
        return ExternalEventType.MEMBER_PROFILE_IMAGE_CHANGE_OUTBOX.getType();
    }

}
