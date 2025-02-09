package com.pulse.talk.config.grpc;

import com.pulse.talk.config.grpc.interceptor.ExceptionHandlingInterceptor;
import com.pulse.talk.config.grpc.interceptor.GrpcMetadataInterceptor;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.interceptor.GrpcGlobalServerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * gRPC 서버 설정 - 인터셉터를 설정하는 클래스
 */
@RequiredArgsConstructor
@Configuration
public class GrpcConfig {

//    private final CustomGrpcAuthenticationReader customGrpcAuthenticationReader;

    /**
     * gRPC 서버 메서드 호출 시, 요청 헤더에서 traceparent 헤더를 추출하여 SpanContext를 생성합니다.
     */
    @Bean
    @GrpcGlobalServerInterceptor
    GrpcMetadataInterceptor grpcMetadataInterceptor() {
        return new GrpcMetadataInterceptor();
    }


    /**
     * gRPC 예외 처리 인터셉터 설정
     */
    @Bean
    @GrpcGlobalServerInterceptor
    ExceptionHandlingInterceptor exceptionHandlingInterceptor() {
        return new ExceptionHandlingInterceptor();
    }


    /**
     * gRPC 서버 인터셉터 클래스. 이 클래스는 gRPC 요청에서 JWT 토큰을 추출하고 인증을 수행합니다.
     */
//    @Bean
//    @GrpcGlobalServerInterceptor
//    JwtGrpcInterceptor jwtGrpcInterceptor() {
//        return new JwtGrpcInterceptor(customGrpcAuthenticationReader);
//    }

}