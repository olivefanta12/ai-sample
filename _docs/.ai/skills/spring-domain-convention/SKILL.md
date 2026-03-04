---
name: spring-domain-convention
description: 이 프로젝트의 Spring Boot Java 도메인 계층 구현 가이드. board, user 같은 도메인 패키지를 추가/수정하거나 Entity/Controller/Service/Repository/Request/Response 파일을 생성할 때 프로젝트 코드 컨벤션을 지키기 위해 사용한다.
---

# Spring Domain Convention Skill

`references/code-rule-ai.md` 규칙을 따른다.

## Execute
1. 대상 도메인 패키지를 `src/main/java/com/example/demo/<domain>` 에서 찾는다.
2. 사용자가 예외를 요구하지 않는 한, 패키지에 아래 역할 파일 6개를 유지한다.
   - `<Domain>.java`
   - `<Domain>Controller.java`
   - `<Domain>Service.java`
   - `<Domain>Repository.java`
   - `<Domain>Request.java`
   - `<Domain>Response.java`
3. 역할 경계를 유지한다.
   - Entity: 영속 모델
   - Controller: 요청 매핑/라우팅
   - Service: 비즈니스 로직/트랜잭션
   - Repository: DB 접근
   - Request: 입력 DTO(static class)
   - Response: 출력 DTO(static class)
4. 트랜잭션 규칙을 적용한다.
   - Service 클래스에 `@Transactional(readOnly = true)`
   - 쓰기 메서드에만 메서드 단위 `@Transactional`
5. DTO/네이밍 규칙은 레퍼런스 문서를 따른다.
6. 마무리 전에 `references/code-rule-ai.md` 체크리스트로 자체 점검한다.

## Output Style
- 변경은 최소 단위로 수행한다.
- 기존 package naming, table naming 규칙을 유지한다.
- 기존 코드가 규칙과 충돌하면 사용자 요구를 우선 반영하고, 위반 규칙을 명시한다.
