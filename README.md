# 🚀 Spring Advanced 과제

## 과제 시작 가이드

1. [원본 저장소](https://github.com/f-api/spring-advanced)를 `fork` 합니다.
2. 내 계정으로 복사된 repository를 `clone` 합니다.

```bash
git clone {fork로 복사한 repository url}
```

3. 프로젝트를 IDE(IntelliJ 등)에서 열어 개발을 시작합니다.

## 진행 규칙

- **Given-When-Then 패턴**으로 테스트 코드 작성
- **Git Commit 규칙**
    - 단계별로 커밋 메시지를 남깁니다.
      ```bash
      feat(early-return): Early Return
      ```

---

## 📂 과제 레벨별 요구사항

### Lv 0. 프로젝트 세팅 (에러 분석) ✅ 필수

- 애플리케이션 실행 실패 원인 분석
- 발생 원인과 해결 방법 기록
- 실행 가능하도록 수정

### Lv 1. ArgumentResolver ✅ 필수

- `AuthUserArgumentResolver` 정상 동작 구현

### Lv 2. 코드 개선 ✅ 필수

- **Early Return**
    - `AuthService.signup()` 개선
- **불필요한 if-else 제거**
    - `WeatherClient.getTodayWeather()` 개선
- **Validation 처리**
    - `UserService.changePassword()` → DTO validation으로 이동

### Lv 3. N+1 문제 해결 ✅ 필수

- 기존 `JPQL fetch join` → `@EntityGraph` 사용으로 변환

### Lv 4. 테스트 코드 연습 ✅ 필수

- `PasswordEncoderTest` 수정
- `ManagerServiceTest` → 예외 및 메서드명 수정
- `CommentServiceTest` → 올바른 예외 검증 수정
- `ManagerService` 로직 수정 (user가 null인 경우 예외 발생)

### Lv 5. API 로깅 💡 선택

- **Interceptor + AOP 방식 구현**
- Admin 전용 API 로깅 (`deleteComment`, `changeUserRole`)

### Lv 6. 내가 정의한 문제 💡 선택

- 코드 리팩토링 or 구조 개선 직접 선정
- 문제 인식 → 해결 → 회고까지 문서화

---

## 나의 기록

- [Lv 0. 프로젝트 세팅 - 에러 분석](https://www.notion.so/Lv0-25c55d5f00a080ce933fc730ee09c2a7?source=copy_link)
- [Lv 1. ArgumentResolver](https://www.notion.so/Lv1-ArgumentResolver-25d55d5f00a0806d9ef9fcb2edbd25ee?source=copy_link)
- [Lv 2. 코드 개선](https://www.notion.so/Lv2-25d55d5f00a08032981cc19a83e52d35?source=copy_link)
- [Lv 3. N+1 문제](https://www.notion.so/Lv3-N-1-25d55d5f00a080e7b828cdb5327a86d7?source=copy_link)
- [Lv 4. 테스트 코드 연습](https://www.notion.so/Lv4-25e55d5f00a08072ad67c4c2d8886802?source=copy_link)
- [Lv 5. API 로깅](https://www.notion.so/Lv5-API-25e55d5f00a0804ab787e154a5ae9936?source=copy_link)
- [Lv 6. 내가 정의한 문제](https://www.notion.so/Lv6-25e55d5f00a08004ae7fc065de46b098?source=copy_link)

