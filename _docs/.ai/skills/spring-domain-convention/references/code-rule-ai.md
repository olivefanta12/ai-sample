# AI 레퍼런스: 프로젝트 Code Rule

## Scope
- Base package: `com.example.demo`
- Domain package unit: `src/main/java/com/example/demo/<domain>`

## Required File Set Per Domain
- `<Domain>.java` (Entity)
- `<Domain>Controller.java`
- `<Domain>Service.java`
- `<Domain>Repository.java`
- `<Domain>Request.java`
- `<Domain>Response.java`

## Entity Rules
- 기본적으로 `@NoArgsConstructor`, `@Data`, `@Entity`, `@Table` 사용
- 객체 생성은 `@Builder` 사용
- collection field는 constructor에 넣지 않음
- relation은 기본 LAZY loading
- 생성 시간은 `@CreationTimestamp` 사용
- DB constraint는 annotation으로 명시 (`unique`, `nullable`, `length`)
- table naming pattern은 `<domain>_tb`

## Controller Rules
- `@Controller`, `@RequiredArgsConstructor` 사용
- dependency는 `private final` field 주입
- session이 필요하면 `HttpSession` 주입
- business logic은 Service로 위임하고 Controller는 얇게 유지

## Service Rules
- `@Service`, `@RequiredArgsConstructor` 사용
- class-level `@Transactional(readOnly = true)` 적용
- write action은 method-level `@Transactional` 추가
- Entity를 Controller에 직접 반환하지 않고 Response DTO로 변환

## Repository Rules
- `JpaRepository<Entity, PK>` 상속
- Repository는 같은 domain package에 위치
- query method는 의미 있는 이름 사용 (예: `findByUsername`)

## Request DTO Rules
- `<Domain>Request` 내부에 기능별 static class 선언
- 이름은 action 기준 (`Save`, `Login`, `Join` 등)
- 내부 DTO에 `@Data` 적용

## Response DTO Rules
- `<Domain>Response` 내부에 응답별 static class 선언
- 기본 이름: `Min`, `Max`, `Detail`
- Entity -> Response DTO 변환 constructor/factory 제공

## Naming Rules
- role suffix: `Controller`, `Service`, `Repository`, `Request`, `Response`
- Entity class는 단수형 domain noun 사용 (예: `User`, `Board`)

## Pre-Completion Checklist
- domain에 필수 6개 역할 파일이 있는가
- Service transaction boundary가 규칙과 일치하는가
- Request/Response 내부 DTO naming이 규칙과 일치하는가
- Controller에 business logic이 없는가
- Entity/table/annotation 규칙이 지켜졌는가
