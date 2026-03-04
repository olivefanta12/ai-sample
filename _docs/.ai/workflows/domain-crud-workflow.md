# Domain CRUD Workflow (AI)

1. 대상 domain package를 `src/main/java/com/example/demo` 에서 찾는다.
2. 6개 역할 파일(Entity/Controller/Service/Repository/Request/Response) 존재를 확인한다.
3. 입력 contract에 맞게 Request 내부 DTO(static class)를 추가/수정한다.
4. 출력 contract에 맞게 Response 내부 DTO(static class)를 추가/수정한다.
5. Service에 business logic을 구현하고 transaction 범위를 맞춘다.
6. Controller는 요청 매핑과 Service 호출만 담당하도록 얇게 유지한다.
7. Service에 필요한 경우에만 Repository query method를 추가한다.
8. `_docs/.ai/skills/spring-domain-convention/references/code-rule-ai.md` 체크리스트로 최종 점검한다.
