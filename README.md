# 🏛ZeroBase-FinTech
간단한 핀테크 기능을 구현하는 프로젝트 입니다.
- - -
## 🛠프로젝트 기능 및 설계
+ 🙆‍♂️**회원가입 기능**
  + ID **(e-mail)**, PASSWORD, 이름, 생년월일, 전화번호를 입력하여 회원가입 가능.
  + 가입시 USER권한 (일반권한) 부여
  + **ID 중복 ❌**
    
+ 🔑**로그인 기능**
  + 로그인 후 계좌 생성 가능
  + 계좌번호 자동 생성 **(중복 ❌)**
  + ID, PASSWORD를 입력하여 로그인
  + 로그인시 회원가입에 사용한 ID와 PASSWORD가 일치 해야함

+ 💰**계좌 관리 기능**
  + 계좌 삭제
  + 금액 입금
  + 금액 출금
  + 금액 조회
 
+ 📲**계좌 송금 기능**
  + 타인 명의의 계좌로 송금
  + 송금시 존재하지 않는 계좌번호로 송금 불가
  + 송금 내역 조회
  + 송금시 메모 추가 가능 (default -> 보내는이 이름)

+ 🧰**기술 스택**
  + JAVA
  + Spring Boot
  + Spring Security
  + JPA
  + MySQL
  + ...

+ **기타 설명**
  + 계좌조회 및 송금내역 조회시 paging처리
  + 금액순 / 날짜순 으로 조회 가능
  + ...
- - -

## 🗄ERD
![erd.PNG](https://github.com/GLORY-JI/ZeroBase-FinTech/blob/main/erd.PNG)

