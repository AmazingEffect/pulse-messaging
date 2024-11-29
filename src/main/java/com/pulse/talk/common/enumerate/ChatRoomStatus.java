package com.pulse.talk.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ChatRoomStatus {

    ACTIVE("ACTIVE", "활성화됨"),
    DELETED("DELETED", "삭제됨");

    private final String code;
    private final String description;

}