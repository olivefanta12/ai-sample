# 코드 컨벤션

## 1) 패키지(폴더) 구조 규칙
- 도메인 기준으로 패키지를 나눈다. 예: `board`, `user`
- 각 도메인 패키지 내부 기본 구성은 아래 6개 파일로 통일한다.
  - `도메인.java` (Entity)
  - `도메인Controller.java`
  - `도메인Service.java`
  - `도메인Repository.java`
  - `도메인Request.java`
  - `도메인Response.java`

예시:
- `src/main/java/com/example/demo/board/Board.java`
- `src/main/java/com/example/demo/board/BoardController.java`
- `src/main/java/com/example/demo/board/BoardService.java`
- `src/main/java/com/example/demo/board/BoardRepository.java`
- `src/main/java/com/example/demo/board/BoardRequest.java`
- `src/main/java/com/example/demo/board/BoardResponse.java`

- `src/main/java/com/example/demo/user/User.java`
- `src/main/java/com/example/demo/user/UserController.java`
- `src/main/java/com/example/demo/user/UserService.java`
- `src/main/java/com/example/demo/user/UserRepository.java`
- `src/main/java/com/example/demo/user/UserRequest.java`
- `src/main/java/com/example/demo/user/UserResponse.java`

## 2) Entity 규칙
- `@NoArgsConstructor`, `@Data`, `@Entity`, `@Table` 기본 사용
- 생성은 `@Builder` 기반으로 처리
- 컬렉션은 생성자에 넣지 않는다.
- 연관관계는 기본 `LAZY` 로딩을 사용한다.
- 시간 컬럼은 `@CreationTimestamp` 사용
- 제약사항은 컬럼 어노테이션으로 명시한다. (예: `unique`, `nullable`, `length`)

## 3) Controller 규칙
- `@Controller` + `@RequiredArgsConstructor` 사용
- 의존성은 `final` 필드로 주입
- 세션 사용 시 `HttpSession`을 주입
- Controller는 요청/응답 흐름과 뷰/라우팅에 집중하고 비즈니스 로직은 Service로 위임

## 4) Service 규칙
- `@Service` + `@RequiredArgsConstructor` 사용
- 클래스 기본 트랜잭션은 `@Transactional(readOnly = true)`
- 쓰기 트랜잭션은 필요한 메서드에 개별 `@Transactional` 적용
- Controller에 Entity를 직접 전달하지 않고 Response DTO로 변환해 전달

## 5) Repository 규칙
- `JpaRepository<엔티티, PK타입>` 상속
- 도메인별 Repository는 도메인 패키지 내부에 위치
- 조회 메서드는 의미 있는 네이밍으로 선언 (예: `findByUsername`)

## 6) Request DTO 규칙
- `도메인Request` 내부에 static class로 기능 단위 DTO를 둔다.
- 네이밍은 기능명 기준: `Save`, `Login`, `Join` 등
- 각 내부 DTO는 `@Data` 사용

예시:
- `BoardRequest.Save`
- `UserRequest.Login`
- `UserRequest.Join`

## 7) Response DTO 규칙
- `도메인Response` 내부에 static class로 응답 스펙을 둔다.
- 네이밍 기본값: `Min`, `Max`, `Detail`
- Entity -> Response DTO 변환 생성자 또는 팩토리 메서드를 제공한다.

예시:
- `UserResponse.Min(User user)`

## 8) 공통 네이밍 규칙
- 클래스명은 역할 접미사를 명확히 사용: `Controller`, `Service`, `Repository`, `Request`, `Response`
- 엔티티 클래스명은 단수형 도메인명 사용: `User`, `Board`
- 테이블명은 `{domain}_tb` 패턴 사용: `user_tb`, `board_tb`

## 9) 문서 유지 규칙
- 새 도메인 추가 시 1) 구조 규칙과 동일한 6개 파일 세트를 만든다.
- 도메인별 예외 규칙이 생기면 해당 도메인 패키지 상단 주석 + 이 문서에 함께 반영한다.
