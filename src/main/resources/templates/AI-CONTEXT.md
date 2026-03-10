<!-- Parent: ../../AI-CONTEXT.md -->

# View Templates

## 목적

Mustache 템플릿 엔진을 사용하여 클라이언트에 렌더링될 HTML 뷰를 정의한다.

## 주요 파일

| 파일명 | 설명 |
| :--- | :--- |
| `home.mustache` | 메인 홈 화면 |
| `layout/header.mustache` | 공통 헤더 (네비게이션 바 등) |
| `layout/footer.mustache` | 공통 푸터 |

## 하위 디렉토리

- `user/` - 로그인, 회원가입 등 사용자 관련 뷰
- `board/` - 게시글 목록, 상세보기, 글쓰기 등 게시판 관련 뷰

## AI 작업 지침

- **레이아웃 분리**: 헤더와 푸터는 `{{> layout/header}}` 형식을 사용하여 중복을 최소화한다.
- **데이터 바인딩**: 컨트롤러에서 넘어온 `model` 데이터를 Mustache 문법(`{{variable}}`)으로 바인딩한다.
- **정적 리소스**: CSS나 JS는 `src/main/resources/static` 하위에서 관리하며 절대 경로(`/css/...`)를 사용한다.
