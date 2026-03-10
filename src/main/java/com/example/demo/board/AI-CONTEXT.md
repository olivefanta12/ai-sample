<!-- Parent: ../../../../AI-CONTEXT.md -->

# Board Domain

## 목적

게시글 생성, 조회, 수정, 삭제(CRUD) 기능을 담당하는 도메인이다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `Board.java` | 게시글 엔티티 (Board, User 연관관계 포함) |
| `BoardController.java` | HTTP 요청 처리 및 뷰 매핑 |
| `BoardService.java` | 비즈니스 로직 및 트랜잭션 관리 |
| `BoardRepository.java` | JPA 기반 데이터 접근 계층 |
| `BoardRequest.java` | 게시글 관련 요청 DTO (SaveDTO, UpdateDTO 등) |
| `BoardResponse.java` | 게시글 관련 응답 DTO |

## AI 작업 지침

- **연관관계**: `User`와의 관계는 반드시 `FetchType.LAZY`를 사용한다.
- **DTO 사용**: `BoardResponse` 내의 내부 클래스를 활용하여 각 요청에 맞는 응답 구조를 정의한다.
- **예외 처리**: 서비스 계층에서 발생한 예외는 글로벌 예외 핸들러에서 처리하도록 설계한다.
