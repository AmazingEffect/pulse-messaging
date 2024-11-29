package com.pulse.talk.adapter.out.mongo.document.sub;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 메시지 읽음 상태 정보를 가지는 클래스
 * 채팅 메시지에 종속적인 데이터입니다. 서브 도큐먼트로 사용됩니다.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ReadReceiptDocument {

    private String memberId;  // 메시지를 읽은 회원 ID

    private LocalDateTime readAt;  // 읽은 시간

}
