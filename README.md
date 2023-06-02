# JJ_Club_backend_chat
JJ Club 백엔드 - 채팅 서버 중 금지어(이하얀)

## 기술 스택
- 채팅 서버는 다음의 의존성을 주입하여 개발했습니다.
```
org.springframework.boot:spring-boot-starter-web
org.springframework.boot:spring-boot-starter-websocket
```

> **🔐 채팅 서버**
> * `Java 11`
> * `Spring Boot 2.7.2`
> * `spring-boot-starter-web`
> * `spring-boot-starter-websocket`
>
> #
> 

## 채팅 서버 API
- 현재 테스트는 로컬 환경에서만 진행할 수 있는 상태입니다.
<br>

|       서비스        |     Method     |                 URL                   |
| ------------------- | -------------- | ------------------------------------- |
|          채팅       |     Websocket       | /api/v1/chat                   |

---
## 시연 영상

https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/ea8bba99-8c17-4229-a7c2-22fdeb1ec5fa

### 1. 웹소켓 연결
#### Postman 설정
- "New" 클릭
![image](https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/b28031da-baf5-4d4c-824c-a71baeaa90b3)
<br>

- "WebSocket" 클릭
![image](https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/ccba64f5-f3f0-46c7-97ad-5b3affa94e94)
<br>

- "ws://localhost:8080/api/v1/chat" 주소 작성 후 Connect 클릭(반드시 서버를 구동한 후에 실행해야 함)
![image](https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/96814977-a337-40bf-9392-bc5b8ca79557)
<br>

- 다음과 같이 연결이 잘 성립되었는지 확인
![image](https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/eb906190-dc85-4a34-8dbb-6f42983e2782)
<br>

- 다음과 같이 채팅으로 보낼 메시지 입력 및 send 클릭
```
아니 이런 1!8^새.꺄
같.은&년
아!닌.데
h양비디오 는 구했나?
hidden 언어는 뭐야?
```
![image](https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/fae73f86-5331-4c87-9aee-f56b03e4073e)
<br>

- 금지어 필터링 적용 확인
![image](https://github.com/hayannn/JJ_Club_backend_chat/assets/102213509/92f95fe3-64b9-4809-aed5-35c8f7252cf3)
<br>
