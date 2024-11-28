package com.pulse.talk.exception;

import lombok.Getter;

@Getter
public class TalkException extends RuntimeException {

    private final ErrorCode errorCode;

    public TalkException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public TalkException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.errorCode = errorCode;
    }

}
