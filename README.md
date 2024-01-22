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

---

<br>

# 시연 영상(Youtube)
[![Video Label](http://img.youtube.com/vi/fapFPGZMdeI/0.jpg)](https://www.youtube.com/watch?v=fapFPGZMdeI)

---
<br>

# 캡스톤디자인 최종발표 자료
https://docs.google.com/presentation/d/1GXi-4NIpPugG0QNEib30JOojum7RPpk9/edit?usp=sharing&ouid=114851464679137805270&rtpof=true&sd=true

![슬라이드1](https://github.com/hayannn/JJ_Club_backend/assets/102213509/42222a99-286f-4961-87bb-7669b35feb45)
![슬라이드2](https://github.com/hayannn/JJ_Club_backend/assets/102213509/ada4bf63-a15a-4f4b-80ff-8b0860e1c38b)
![슬라이드3](https://github.com/hayannn/JJ_Club_backend/assets/102213509/273db19d-682c-45f8-b47c-644c33ccc492)
![슬라이드4](https://github.com/hayannn/JJ_Club_backend/assets/102213509/e34d40ee-fd10-4d13-9173-8ee23419f8be)
![슬라이드5](https://github.com/hayannn/JJ_Club_backend/assets/102213509/b148cf4d-2cea-4cc9-a1a5-7876b88dbde5)
![슬라이드6](https://github.com/hayannn/JJ_Club_backend/assets/102213509/dc1d67fc-abf6-4232-b309-9d5eb698e446)
![슬라이드7](https://github.com/hayannn/JJ_Club_backend/assets/102213509/de181c4d-856a-4205-9967-7cedd5ebd003)
![슬라이드8](https://github.com/hayannn/JJ_Club_backend/assets/102213509/95cd1663-52df-4564-8e17-60d93f5452fe)
![슬라이드9](https://github.com/hayannn/JJ_Club_backend/assets/102213509/9ecff92b-1790-41f4-ac26-5ac104d33979)
![슬라이드10](https://github.com/hayannn/JJ_Club_backend/assets/102213509/e1b817cd-dbaf-4e3f-96c2-27529e7a7720)
![슬라이드11](https://github.com/hayannn/JJ_Club_backend/assets/102213509/d80b6646-38e6-46fa-b15e-7e8edbf85137)
![슬라이드12](https://github.com/hayannn/JJ_Club_backend/assets/102213509/a9403b44-5bee-4eda-81f5-0c99bb2b307b)
![슬라이드13](https://github.com/hayannn/JJ_Club_backend/assets/102213509/d793e9f0-f63b-42b3-95d7-320c01dc64d0)
![슬라이드14](https://github.com/hayannn/JJ_Club_backend/assets/102213509/b0d80c81-7e2d-45d9-9ade-b1d41df0df6b)
![슬라이드15](https://github.com/hayannn/JJ_Club_backend/assets/102213509/ea6dacb0-1d22-4d8d-ac54-e0639aaa5a33)
![슬라이드16](https://github.com/hayannn/JJ_Club_backend/assets/102213509/424b295e-4f16-4b25-a334-ff037bcb1757)
![슬라이드17](https://github.com/hayannn/JJ_Club_backend/assets/102213509/797e5b05-1ebc-4b23-9750-3518fe3f8e2f)
![슬라이드18](https://github.com/hayannn/JJ_Club_backend/assets/102213509/7e10a00c-f6a5-4663-8584-b65b0c5f82d9)
![슬라이드19](https://github.com/hayannn/JJ_Club_backend/assets/102213509/63edd65a-b7fe-4e1e-9703-492b4267e58c)
![슬라이드20](https://github.com/hayannn/JJ_Club_backend/assets/102213509/7a0c673d-579a-43fc-bb3d-afcd74068463)
![슬라이드21](https://github.com/hayannn/JJ_Club_backend/assets/102213509/aabf99f9-fb90-4014-8797-9b336a51a07e)
![슬라이드22](https://github.com/hayannn/JJ_Club_backend/assets/102213509/55d46bd1-1815-4a65-bb69-e636a2cd866c)
![슬라이드23](https://github.com/hayannn/JJ_Club_backend/assets/102213509/b16c080b-8a83-41a8-9e7e-e82b74133045)
![슬라이드24](https://github.com/hayannn/JJ_Club_backend/assets/102213509/f468174b-9d52-4600-b46d-dfc2b2db49b6)
![슬라이드25](https://github.com/hayannn/JJ_Club_backend/assets/102213509/988e362f-262c-4d59-9bae-66f521740f4a)
![슬라이드26](https://github.com/hayannn/JJ_Club_backend/assets/102213509/89461f55-ecaf-4981-bc9c-628b0dc2f286)
![슬라이드27](https://github.com/hayannn/JJ_Club_backend/assets/102213509/154b5363-dca9-4dc5-bea3-0a8febfdb94d)
![슬라이드28](https://github.com/hayannn/JJ_Club_backend/assets/102213509/2817efc2-fefb-4fec-a37e-65fde962daf9)
![슬라이드29](https://github.com/hayannn/JJ_Club_backend/assets/102213509/9163c25c-9a91-447b-b2ac-fa303dde5771)
![슬라이드30](https://github.com/hayannn/JJ_Club_backend/assets/102213509/e09ffe1e-e4d0-4151-981d-7dabce178b4e)
![슬라이드31](https://github.com/hayannn/JJ_Club_backend/assets/102213509/cbb56aa3-8011-4c6e-a8b1-f74c18dadc65)
![슬라이드32](https://github.com/hayannn/JJ_Club_backend/assets/102213509/25b3fe7c-5c7f-408c-af70-8469a9968473)
![슬라이드33](https://github.com/hayannn/JJ_Club_backend/assets/102213509/7b474e26-a9f1-4736-9d71-f02d848c68a7)
![슬라이드34](https://github.com/hayannn/JJ_Club_backend/assets/102213509/2e90ea55-d70b-4d55-8293-44e21b5d86e3)
![슬라이드35](https://github.com/hayannn/JJ_Club_backend/assets/102213509/3119e867-ad1b-4d63-be9f-05631bb8146e)
![슬라이드36](https://github.com/hayannn/JJ_Club_backend/assets/102213509/05b1b9fe-295e-4fed-939f-1253f549dd5b)
![슬라이드37](https://github.com/hayannn/JJ_Club_backend/assets/102213509/98c62091-7c0a-45cd-9c05-0d8353f950d2)
![슬라이드38](https://github.com/hayannn/JJ_Club_backend/assets/102213509/c5e73311-251a-47c6-b068-c1ebe94f3644)
![슬라이드39](https://github.com/hayannn/JJ_Club_backend/assets/102213509/47d4623e-9353-45d1-830c-b8de67826755)
![슬라이드40](https://github.com/hayannn/JJ_Club_backend/assets/102213509/0c7555cc-fc78-40c1-8c9c-7e3d37083b21)
![슬라이드41](https://github.com/hayannn/JJ_Club_backend/assets/102213509/5d80c348-7671-46ce-8c21-7e37375d6adb)
