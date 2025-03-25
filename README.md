# -schedule
스케쥴 프로그램

# 스케줄 프로그램 API


```markdown
# 스케줄 관리 API

이 문서는 스케줄 관리 프로그램의 API를 설명합니다.

## 스케줄 생성
**POST /schedules**  
새로운 스케줄을 생성합니다.

### 요청 본문:
   json
{
    "name": "Joh",
    "password": "123",
    "todo": "Complete Spring Boot project"
}
```

### 응답:
- **200**: 정상 생성

---

## 스케줄 조회
**GET /schedules/{id}**  
주어진 ID의 스케줄을 조회합니다.

### 요청 파라미터:
- `id`: 스케줄 ID

### 응답:
```json
{
    "name": "Joh",
    "password": "123",
    "todo": "Complete Spring Boot project",
    "createday": "2025-03-24T12:00:00",
    "reportingday": "2025-03-24T12:00:00"
}
```

- **200**: 정상 조회

---

## 전체 스케줄 조회
**GET /schedules**  
전체 스케줄을 조회합니다.

### 응답:
```json
[
    {
        "id": 1,
        "name": "Joh",
        "password": "123",
        "todo": "Complete Spring Boot project",
        "createday": "2025-03-24T12:00:00",
        "reportingday": "2025-03-24T12:00:00"
    },
    {
        "id": 2,
        "name": "Joh",
        "password": "123",
        "todo": "Complete Spring Boot tutorial",
        "createday": "2025-03-24T12:00:01",
        "reportingday": "2025-03-24T12:00:01"
    }
]
```

- **200**: 정상 조회

---

## 스케줄 수정
**PATCH /schedules/{id}**  
주어진 ID의 스케줄을 수정합니다.

### 요청 본문:
```json
{
    "name": "Joh",
    "password": "123",
    "todo": "Update",
}
```

### 응답:
- **200**: 정상 수정

---

## 스케줄 삭제
**DELETE /schedules/{id}**  
주어진 ID의 스케줄을 삭제합니다.

### 요청 파라미터:
- `password`: 스케줄의 비밀번호

### 응답:
- **200**: 정상 삭제
