package com.pulse.talk.adapter.out.mongo.document.sub;

import lombok.*;

/**
 * 파일 첨부 정보를 가지는 클래스
 * 채팅 메시지에 종속적인 데이터입니다. 서브 도큐먼트로 사용됩니다.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class FileAttachmentDocument {

    private String fileId;  // 파일 ID

    private String fileName;  // 파일 이름

    private String fileUrl;  // 파일 저장 위치 (URL)

    private String fileType;  // 파일 유형

    private long fileSize;  // 파일 크기 (바이트 단위)

}
