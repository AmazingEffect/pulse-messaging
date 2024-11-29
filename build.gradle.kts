plugins {
    java
    id("org.springframework.boot") version "3.4.0" // Spring Boot 플러그인
    id("io.spring.dependency-management") version "1.1.6" // 의존성 관리 플러그인
    id("com.google.protobuf") version "0.9.4" // Protobuf 플러그인
}

// Protobuf 및 gRPC 관련 버전 변수 선언
val protobufVersion by extra("4.28.2") // Protobuf 최신 버전
val grpcVersion by extra("1.68.2")     // gRPC 최신 버전

// 프로젝트 정보 설정
group = "com.pulse"
version = "0.0.1-SNAPSHOT"

// Java 설정: Java 21 사용 (Spring Boot 3.4.0 이상에서 권장)
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

// 애너테이션 프로세서 설정
configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

// 의존성 관리를 위한 저장소 설정
repositories {
    mavenCentral() // Maven Central Repository 사용
}

// 프로젝트에서 사용하는 의존성 추가
dependencies {
    // Spring Boot Core 및 Data JPA
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // PostgreSQL 드라이버
    runtimeOnly("org.postgresql:postgresql")

    // MongoDB 드라이버
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

    // Kafka 의존성
    implementation("org.springframework.kafka:spring-kafka")

    // Lombok (코드 간소화를 위한 도구)
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // gRPC 및 Protobuf 라이브러리
    implementation("com.google.protobuf:protobuf-java-util:$protobufVersion") // JSON 직렬화/역직렬화 지원
    implementation("com.google.protobuf:protobuf-java:$protobufVersion")     // Protobuf 메시지 지원
    implementation("net.devh:grpc-spring-boot-starter:3.1.0.RELEASE")         // Spring Boot와 gRPC 통합
    implementation("io.grpc:grpc-netty-shaded:$grpcVersion")                  // Netty 기반 gRPC 서버/클라이언트
    implementation("io.grpc:grpc-protobuf:$grpcVersion")                      // Protobuf와 gRPC 통합
    implementation("io.grpc:grpc-stub:$grpcVersion")                          // gRPC 클라이언트 Stub 생성
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")                   // 주석 처리 API (optional)

    // msa 로깅 Jaeger 설정
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("io.micrometer:micrometer-tracing-bridge-otel")
    implementation("io.opentelemetry:opentelemetry-exporter-otlp")

    // 테스트 의존성
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher") // 테스트 런처
}

// Protobuf 관련 설정
protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:$protobufVersion" // Protobuf 컴파일러 설정
    }
    plugins {
        // gRPC 플러그인 등록
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:$grpcVersion" // gRPC 코드 생성 플러그인
        }
    }
    generateProtoTasks {
        // 모든 Protobuf 파일에 대해 gRPC 플러그인을 적용
        all().forEach { task ->
            task.plugins {
                create("grpc")
            }
        }
    }
}

// 테스트 설정
tasks.withType<Test> {
    useJUnitPlatform() // JUnit 5 플랫폼 사용
}

// Protobuf로 생성된 파일을 삭제하기 위한 커스텀 작업
tasks.register<Delete>("cleanGeneratedFiles") {
    delete("build/generated") // Protobuf 생성 파일 디렉토리를 삭제합니다.
    // 이 작업은 Protobuf 빌드 시 생성된 파일을 초기화하거나, 깨끗한 상태에서 빌드할 때 유용합니다.
}

// 프로젝트 빌드 속도 향상 및 기타 옵션 설정
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8" // UTF-8 인코딩 설정
    options.isIncremental = true // 증분 빌드 활성화
}