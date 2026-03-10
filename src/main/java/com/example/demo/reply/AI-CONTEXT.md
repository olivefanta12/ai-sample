<!-- Parent: ../../../../AI-CONTEXT.md -->

# Reply Domain

## 목적

게시글에 대한 댓글 작성 및 삭제 기능을 담당하는 도메인이다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `Reply.java` | 댓글 엔티티 (User, Board 연관관계 포함) |
| `ReplyController.java` | 댓글 API 요청 처리 |
| `ReplyService.java` | 댓글 저장 및 삭제 로직 |
| `ReplyRepository.java` | 댓글 데이터 접근 계층 |
| `ReplyRequest.java` | 댓글 작성 요청 DTO |
| `ReplyResponse.java` | 댓글 응답 DTO |

## AI 작업 지침

- **연관관계**: `Board` 및 `User`와의 관계는 `FetchType.LAZY`를 사용한다.
- **삭제 정책**: 댓글 삭제 시 작성자 본인 확인 로직이 포함되어야 한다.
