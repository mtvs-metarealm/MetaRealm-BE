# XR 을 위한... Spring Security & JWT 사용법..😉

# 09/16 1차 수정 내용
<span style="color:red;">수정 1 -> 회원 가입 시 Email 입력하지 않아도 되도록 수정했습니다.</span></br>
<span style="color:red;">수정 2 -> 로그인 시 Key 가 message 인 JSON 형태로 응답되도록 수정했습니다.</span></br>
<span style="color:red;">수정 3 -> Token 값을 Header 로, Body 로 둘 다 응답하게 수정했습니다.</span></br>
<span style="color:red;">수정 4 -> Token Test 에서 Token 이 유효할 시 응답을 Key 가 message 인 JSON 형태로 응답되도록 수정했습니다.</span>

# 09/16 2차 수정 내용
<span style="color:red;">수정 1 -> 회원 가입 실패에 따른 응답이 다양하게 수정되었습니다.</span></br>
<span style="color:red;">수정 2 -> 보안 및 인증 과정에서 일어날 수 있는 에러는 일정한 형태로 제공됩니다</span></br>
<span style="color:red;">수정 3 -> 로그인 실패 시 응답의 Key 가 변경되었습니다.</span></br>
<span style="color:red;">수정 4 -> 로그인 성공 시 userName 이 반환됩니다.</span></br>

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
  "timestamp": "2024-09-16T16:18:50.055",
  "errorCategory": "CONFLICT",
  "httpStatus": 409,
  "customizedStatusCode": 101,
  "detailErrorDescription": "User ID already exists"
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
  "userName": "KCH",
  "token": "BEARER eyJkYXRlIjoxNzI2NDcxMTQ1MTMxLCJ0eXBlIjoiand0IiwiYWxnIjoiSFMyNTYifQ.eyJSb2xlIjoiVVNFUiIsInN1YiI6Im9oZ2lyYWZmZXJzIHRva2VuIDogMSIsInVzZXJOYW1lIjoiS0NIIiwiZXhwIjoxNzI2NTU3NTQ1fQ.huhsKQwxeBlItIZOUSvU9VqJ_n52Bbw9-Fo6GG9ENSM"
}
```

#### 실패 시 응답 (아이디가 존재하지 않는 경우)
```json
{
  "message": "User does not exist."
}
```

#### 실패 시 응답2 (비밀번호가 일치하지 않는 경우)
```json
{
  "message": "Incorrect username or password."
}
```

로그인 요청을 보내시면 response 로 매 요청에 꼭 붙여 주셔야 하는 암호 같은 게 같이 나갑니다.

암호는 response 의 header 에 Authorization 라는 이름(Key) 로 나가고, BEARER 라는 접두어? 뒤에 값이 길게 붙습니다.

* 09/16 수정사항 : 로그인 시 Body 에 토큰 값도 추가되도록 수정하였습니다.

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
  "timestamp": 1726471348475,
  "status": 500,
  "error": "Internal Server Error",
  "path": "/test"
}
```

* 토큰 값 위조 및 만료 등 상황에 대해서 응답은 최대한 수정해 보려고 했는데, 로직이 생각보다 많이 복잡해서 못 했습니다ㅠㅠ
* 나중에 기회가 되면 꼭 수정해 보도록 하겠습니다.
* 로그인 이후 24시간이 지나면 자동으로 로그아웃 처리 됩니다. 이 경우에 500 에러가 발생합니다.
* 로그아웃 이후 정상적으로 다시 로그인하면 문제 없습니다.