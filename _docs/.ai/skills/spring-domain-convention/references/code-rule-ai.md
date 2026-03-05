# 코드 컨벤션 요약

## 패키지 구조

도메인 기준 플랫 구조: `_core/`, `board/`, `user/` ...

각 도메인 폴더에 Entity, Controller, Service, Repository, Request, Response 포함

## 어노테이션 순서

| 레이어     | 순서                                                                        |
| ---------- | --------------------------------------------------------------------------- |
| Entity     | `@NoArgsConstructor` → `@Data` → `@Entity` → `@Table(name = "{도메인}_tb")` |
| Service    | `@Transactional(readOnly = true)` → `@RequiredArgsConstructor` → `@Service` |
| Controller | `@RequiredArgsConstructor` → `@Controller`                                  |

## Entity 규칙

- PK 타입: `Integer`, 전략: `GenerationType.IDENTITY`
- `@Builder`는 생성자에 선언 (클래스 레벨 금지), 컬렉션 필드 제외
- 모든 연관관계: `FetchType.LAZY`
- 생성일: `@CreationTimestamp` + `LocalDateTime createdAt`

## Service 규칙

- 클래스 레벨 `@Transactional(readOnly = true)`, 쓰기 메서드만 `@Transactional`
- DTO는 Service에서 생성 → Controller로 Entity 직접 전달 금지

## Controller 규칙

- SSR: `@Controller` → Mustache 템플릿 경로 반환
- REST: `@RestController` → `Resp.ok(body)` / `Resp.fail(status, msg)` 반환

## DTO 규칙

- `{Domain}Request.java` — 내부 static class를 기능명으로 (`Save`, `Update`)
- `{Domain}Response.java` — 내부 static class를 용도명으로 (`Detail`, `Items`)
- 외부 클래스: 어노테이션 없음 / 내부 클래스: `@Data`
- Entity → DTO 변환: 생성자 또는 정적 팩토리 메서드

## 공통 응답

`_core/utils/Resp.java` — REST API는 반드시 `Resp<T>` 래퍼 사용

## 네이밍

| 대상        | 규칙               | 예시             |
| ----------- | ------------------ | ---------------- |
| 클래스/파일 | PascalCase         | `BoardService`   |
| 메서드/변수 | camelCase          | `findAll`        |
| 테이블      | snake_case + `_tb` | `board_tb`       |
| 패키지      | lowercase          | `board`, `_core` |

## 설정

- OSIV: `false`
- Fetch: 전부 `LAZY`
- Batch: `default_batch_fetch_size=10`
- 인증: `HttpSession`
