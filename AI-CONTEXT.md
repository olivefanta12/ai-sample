# Demo Application

## 목적

Spring Boot 3.4.3, Java 21 기반의 게시판(Board), 댓글(Reply), 사용자(User) 기능을 포함한 데모 웹 애플리케이션이다. Mustache 템플릿 엔진과 JPA(H2)를 사용한다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `build.gradle` | 프로젝트 의존성 관리 (Spring Boot, JPA, Mustache, Lombok 등) |
| `src/main/java/com/example/demo/DemoApplication.java` | 애플리케이션 실행 메인 클래스 |
| `src/main/resources/application.properties` | 서버, DB, Mustache 등 주요 설정 파일 |
| `AI-GUIDE.md` | AI 에이전트를 위한 가용 Skill 및 규칙 안내서 |

## 하위 디렉토리

- `src/main/java/com/example/demo/board/` - 게시판 관련 도메인 로직 (Entity, Controller, Service, Repository)
- `src/main/java/com/example/demo/reply/` - 댓글 관련 도메인 로직
- `src/main/java/com/example/demo/user/` - 사용자 관련 도메인 로직
- `src/main/java/com/example/demo/_core/` - 공통 유틸리티 및 전역 설정
- `src/main/resources/db/` - DB 초기화 SQL (`data.sql`)
- `src/main/resources/templates/` - Mustache 뷰 템플릿

## AI 작업 지침

- **컨벤션**: `.ai/rules/common-rule.md`를 준수한다.
- **아키텍처**: 기본적으로 Controller - Service - Repository - Entity 계층 구조를 따른다.
- **DTO**: Request와 Response 전용 클래스를 사용하여 Entity가 직접 외부에 노출되지 않도록 한다.
- **UI**: Mustache 템플릿을 사용하며, `src/main/resources/templates` 하위에서 관리한다.

## 테스트

- `./gradlew test` 명령어로 JUnit 5 기반 테스트를 실행한다.

## 의존성

- **내부**: JPA, Spring Web, Mustache
- **외부**: H2 Database (In-memory), Lombok
