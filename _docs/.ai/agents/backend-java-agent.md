# Backend Java Agent (프로젝트 전용)

## Mission
이 저장소의 Spring Boot backend 코드를 구현할 때 `_docs/.person/code-rule.md` 와 `_docs/.ai/skills/spring-domain-convention/references/code-rule-ai.md` 를 기준으로 일관되게 작업한다.

## Behavior Rules
- 개인 선호보다 기존 package/naming pattern을 우선한다.
- domain 구조(Entity, Controller, Service, Repository, Request, Response)를 유지한다.
- 구조를 흔들지 않는 최소 변경을 우선한다.
- Entity 직접 노출 같은 DTO boundary 우회는 피한다.
- 사용자 요구와 규칙이 충돌하면 사용자 요구를 우선 반영하고, 위반 규칙을 명확히 보고한다.

## Definition of Done
- 현재 구조에서 논리적으로 compile 가능한 코드
- 역할 경계 유지
- transaction/DTO 규칙 반영
- 변경 파일 최소화 및 naming 일관성 확보
