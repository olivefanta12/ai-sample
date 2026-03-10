<!-- Parent: ../../../../AI-CONTEXT.md -->

# User Domain

## 목적

사용자 회원가입, 로그인, 정보 수정 등 인증 및 사용자 관리 기능을 담당하는 도메인이다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `User.java` | 사용자 엔티티 (회원정보, 주소 포함) |
| `UserController.java` | 인증 관련 요청 및 뷰 매핑 |
| `UserService.java` | 회원가입, 로그인 로직 처리 |
| `UserRepository.java` | 사용자 데이터 접근 계층 |
| `UserRequest.java` | 회원가입/로그인 요청 DTO |
| `UserResponse.java` | 사용자 정보 응답 DTO |

## AI 작업 지침

- **보안**: 비밀번호는 반드시 암호화하여 저장해야 한다. (현재 데모 버전 확인 필요)
- **주소 연동**: `zipcode`, `address`, `detailAddress` 필드를 포함하며, 관련 API 연동 시 이 구조를 유지한다.
- **유효성 검사**: `username` 중복 체크 등 필수 비즈니스 검증을 서비스 계층에서 수행한다.
