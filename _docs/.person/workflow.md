# 아이디(username) 중복체크 기능 Workflow

## 개요
회원가입 시 username 입력 후 중복 여부를 Ajax로 확인하는 REST API를 제공한다.

## 전체 흐름
```text
[사용자] username 입력
  -> [중복확인 버튼 클릭]
  -> [JS] GET /api/users/username-check?username=xxx
  -> [Controller] userService.usernameCheck(username)
  -> [Service] userRepository.existsByUsername(username)
  -> [응답] Resp.ok({ username, available, message })
  -> [JS] 메시지 렌더링(사용 가능/이미 사용중)
```

## 작업 목록

### 1. User API 엔드포인트
- 파일: `user/UserApiController.java` (또는 기존 `UserController`에 REST 메서드 추가)
- 어노테이션: `@RequiredArgsConstructor` -> `@RestController`
- 엔드포인트: `GET /api/users/username-check?username=xxx`
- 반환: `Resp.ok(dto)` / 검증 실패 시 `Resp.fail(...)`

### 2. Service 메서드
- 위치: `UserService`
- 메서드: `UserResponse.UsernameCheck usernameCheck(String username)`
- 처리:
  - trim
  - 빈값/형식 검증
  - 중복 조회
  - DTO 생성 반환

### 3. Repository 메서드
- 위치: `UserRepository`
- 권장 메서드: `boolean existsByUsername(String username)`

### 4. 프론트 (Mustache + JS) 상세

#### 4-1. 화면 마크업
- `username` 입력창, `중복확인` 버튼, 결과 메시지 영역을 만든다.
- 폼 submit 전에 중복확인 완료 여부를 검증한다.

```html
<form id="join-form" action="/join" method="post">
  <div>
    <label for="username">Username</label>
    <input id="username" name="username" type="text" maxlength="20" required />
    <button id="btn-check-username" type="button">중복확인</button>
  </div>

  <p id="username-check-msg" style="margin-top: 8px;"></p>

  <div>
    <label for="password">Password</label>
    <input id="password" name="password" type="password" required />
  </div>

  <button type="submit">회원가입</button>
</form>
```

#### 4-2. JS 함수 구성
- `checkUsername()`:
  - 입력값 trim
  - fetch 호출
  - 응답값으로 상태 변수 갱신
- `renderUsernameCheckResult(message, type)`:
  - 메시지 텍스트/색상 표시
- `resetUsernameCheckState()`:
  - 입력 변경 시 기존 확인 상태 무효화
- `validateBeforeSubmit(event)`:
  - 중복확인 미완료/중복 상태면 제출 차단

```html
<script>
  let usernameChecked = false;
  let usernameAvailable = false;
  let lastCheckedUsername = "";

  function renderUsernameCheckResult(message, type) {
    const msgEl = document.getElementById("username-check-msg");
    msgEl.textContent = message;

    if (type === "성공") {
      msgEl.style.color = "green";
      return;
    }
    if (type === "실패") {
      msgEl.style.color = "red";
      return;
    }
    msgEl.style.color = "#666";
  }

  function resetUsernameCheckState() {
    usernameChecked = false;
    usernameAvailable = false;
    lastCheckedUsername = "";
    renderUsernameCheckResult("", "초기");
  }

  async function checkUsername() {
    const usernameInput = document.getElementById("username");
    const username = usernameInput.value.trim();

    if (!username) {
      resetUsernameCheckState();
      renderUsernameCheckResult("username을 입력해주세요.", "실패");
      return;
    }

    try {
      const response = await fetch(`/api/users/username-check?username=${encodeURIComponent(username)}`);
      const data = await response.json();

      const available = data?.body?.available === true;
      const message = data?.body?.message || (available ? "사용 가능한 username입니다." : "이미 사용중인 username입니다.");

      usernameChecked = true;
      usernameAvailable = available;
      lastCheckedUsername = username;

      renderUsernameCheckResult(message, available ? "성공" : "실패");
    } catch (e) {
      resetUsernameCheckState();
      renderUsernameCheckResult("중복확인 중 오류가 발생했습니다.", "실패");
    }
  }

  function validateBeforeSubmit(event) {
    const username = document.getElementById("username").value.trim();

    if (!usernameChecked || !usernameAvailable || lastCheckedUsername !== username) {
      event.preventDefault();
      renderUsernameCheckResult("username 중복확인을 완료해주세요.", "실패");
      return false;
    }
    return true;
  }

  document.getElementById("btn-check-username").addEventListener("click", checkUsername);
  document.getElementById("username").addEventListener("input", resetUsernameCheckState);
  document.getElementById("join-form").addEventListener("submit", validateBeforeSubmit);
</script>
```

#### 4-3. 응답 예시
```json
{
  "status": 200,
  "msg": "성공",
  "body": {
    "username": "cos",
    "available": false,
    "message": "이미 사용중인 username입니다."
  }
}
```

## 테스트 체크포인트
- 빈값일 때 API 호출 전에 에러 메시지 노출
- 중복 username: 빨간 메시지 + submit 차단
- 사용 가능 username: 초록 메시지 + submit 허용
- 확인 후 username을 다시 변경하면 상태 초기화되는지 확인
