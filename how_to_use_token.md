# XR 을 위한... Spring Security & JWT 사용법..😉

# 09/16 1차 수정 내용
<span style="color:red;">수정 1 -> 회원 가입 시 Email 입력하지 않아도 되도록 수정했습니다.</span></br>
<span style="color:red;">수정 2 -> 로그인 시 Key 가 message 인 JSON 형태로 응답되도록 수정했습니다.</span></br>
<span style="color:red;">수정 3 -> Token 값을 Header 로, Body 로 둘 다 응답하게 수정했습니다.</span></br>
<span style="color:red;">수정 4 -> Token Test 에서 Token 이 유효할 시 응답을 Key 가 message 인 JSON 형태로 응답되도록 수정했습니다.</span>

## 1. 회원가입

### 1. /signup 으로 회원가입
```http request
### 회원가입
POST http://localhost:7777/signup
Content-Type: application/json

{
  "userId" : "kch4731@gmail.com",
  "userPass" : "kch4731@gmail.com",
  "userName" : "KCH",
  "role" : "USER"
}
```

#### 성공 시 응답
```json
{
    "message": "Successes to register user"
}
```

#### 실패 시 응답
```json
{
    "message": "Failed to Register"
}
```

## 2. 로그인
```http request
### 로그인
POST http://localhost:7777/login
Content-Type: application/json

{
  "id" : "kch4731@gmail.com",
  "pass" : "kch4731@gmail.com"
}
```

#### 성공 시 응답
```json
{
    "message": "Successes to login",
    "token": "BEARER eyJkYXRlIjoxNzI2NDE1NzU2ODY4LCJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJSb2xlIjoiVVNFUiIsInN1YiI6Im9oZ2lyYWZmZXJzIHRva2VuIDogMSIsInVzZXJOYW1lIjoiS0NIIiwiZXhwIjoxNzI2NTAyMTU2fQ.wSwRU3PWMQxQ-LG0J1jSN_yKMzZMar0aJIjqKRJYVgw"
}
```

#### 실패 시 응답
```json
{
    "message": "This account is dormant"
}
```

로그인 요청을 보내시면 response 로 매 요청에 꼭 붙여 주셔야 하는 암호 같은 게 같이 나갑니다.

암호는 response 의 header 에 Authorization 라는 이름(Key) 로 나가고, BEARER 라는 접두어? 뒤에 값이 길게 붙습니다.

로그인 이후, 매 Request 를 할 때마다 Header 에 Authorization 이라는 Key 와 함께 Value 에 BEARER ~~~~~ 를 담아 주시면 됩니다.

## 3. 로그인 이후 접근
```http request
### 테스트
GET http://localhost:7777/test
Content-Type: application/json
Authorization: BEARER eyJkYXRlIjoxNzI2MTE3MTk5Njg4LCJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJSb2xlIjoiVVNFUiIsInN1YiI6Im9oZ2lyYWZmZXJzIHRva2VuIDogMSIsInVzZXJFbWFpbCI6ImtjaDQ3MzFAZ21haWwuY29tIiwidXNlck5hbWUiOiJLQ0giLCJleHAiOjE3MjYyMDM1OTl9.ZX4Gt8cLYCxtYtAQ-r_UgzfkuVzI-gjs4ljlSvfgsl4
```

#### 성공 시 응답
```json
{
    "message": "It's Valid Token"
}
```

#### 실패 시 응답
```json
{
    "reason": "토큰이 유효하지 않습니다.",
    "message": "OTHER TOKEN ERROR",
    "status": 401
}
```