# spa_pj_3-2_schedule

---

# ERD (Entity Relationship Diagram)

| user                          |
|-------------------------------|
| id (pk)                       |
| username (VARCHAR)            |
| email (VARCHAR, UNIQUE)       |
| password (VARCHAR)            |
| created_at (DATETIME)         |
| update_at (DATETIME)          |

            |
            |
            |

| schedule              |
|-----------------------|
| id (PK)               |
| user_id (TK)          |
| title (VARCHAR)       |
| content (TEXT)        |
| created_at (DATETIME) |
| update_at (DATETIME)  |


---

# API 명세서

## User 관련 API

| 기능                    | Method | URL               | Request                                                                                      | Respon                                                                              | note   |
|------------------------|--------|-------------------|----------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|--------|
| 유저 생성 <br/>(회원가입) | POST   | /api/users/signup | { <br/>"username" : "아무개", <br/>"email" : "abc@def.com", <br/>"password" : "123456" <br/>} | { <br/>"id" : 1, <br/>"username" : "아무개", <br/>"email" : "abc@def.com" <br/>}     |         |
| 유저 전체 조회           | GET    | /api/users        | -                                                                                            | [ { <br/>"id" : 1, <br/>"username" : "아무개", <br/>"email" : "abc@def.com" <br/>} ] |         |
| 유저 단건 조회           | GET    | /api/users/{id}   | -                                                                                            | { <br/>"id" : 1, <br/>"username" : "아무개", <br/>"email" : "abc@def.com" <br/>}     |         |
| 유저 수정               | PUT    | /api/users/{id}    | { <br/>"username" : "아무개", <br/>"email" : "abc@def.com", <br/>"password" : "123456" <br/>} | { <br/>"id" : 1, <br/>"username" : "아무개", <br/>"email" : "abc@def.com" <br/>}     |        |
| 유저 삭제               | DELETE | /api/users/{id}    | - | { "message" : " 삭제 완료 " } | |


## Schedule 관련 API
| 기능            | Method  | URL                  | Request                                                                              | Respon                                                                                           | note   |
|----------------|---------|----------------------|--------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|--------|
| 스케쥴 생성      | POST    | /api/schedules | { <br/>"userid" : 1, <br/>"title" : "제목 테스트", <br/>"content" : "내용 테스트" <br/>} | { <br/>"id" : 1, <br/>"userid" : 1, <br/>"title" : "제목 테스트" <br/>"content" : "내용 테스트" <br/>}     |         |
| 스케쥴 전체 조회  | GET     | /api/schedules       | -                                                                                    | [ { <br/>"id" : 1, <br/>"userid" : 1, <br/>"title" : "제목 테스트" <br/>"content" : "내용 테스트" <br/>} ] |         |
| 스케쥴 단건 조회  | GET     | /api/schedules/{id}  | -                                                                                    | { <br/>"id" : 1, <br/>"userid" : 1, <br/>"title" : "제목 테스트" <br/>"content" : "내용 테스트" <br/>}     |         |
| 스케쥴 수정      | PUT     | /api/schedules/{id}  | { <br/>"userid" : 1, <br/>"title" : "제목 수정" <br/>"content" : "내용 수정"<br/> }     | { <br/>"id" : 1, <br/>"userid" : 1, <br/>"title" : "제목 수정" <br/>"content" : "내용 수정" <br/>}       |        |
| 스케쥴 삭제      | DELETE  | /api/schedules/{id}  | -                                                                                    | { "message" : " 삭제 완료 " }                                                                        |         |


## Login 관련 API
| 


## JPA Auditing
| 생성일 | @CreateDate       | 
| 수정일 | @LastModifiedDate | 

