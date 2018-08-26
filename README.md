# PRE-TEST
사전과제 풀이

## 1. 환경
- Lang : Java
- DB : MySql
- Server-side : Spring MVC, Mybatis
- Front-End : JSP, Javascript, jQuery
- Server : Apache Tomcat
- OS : Windows
- Tools : STS, Workbench, SourceTree, Maven

## 2. 문제해결 전략
- 반복 예약을 한 경우의 데이터 처리와 반복 예약을 하기 위해 7일 주기의 날짜를 계산하는 것이 중요
- Util 클래스를 작성하여 선택 예약일자로 부터 반복 횟수에 해당되는 날짜들을 계산
- 반복 횟수를 지정하여 예약시 예약정보 테이블에 각각 한 row 씩 저장
- 반복되는 모든 예약일자들의 예약 가능여부를 체크

## 3. 빌드 및 실행방법
### 3.1 DB설정
- MySql 5.7 버전 설치
- ip : 127.0.0.1 / port : 3306
- username : root / password : 1234
- test1 스키마 및 reserve_info 테이블 생성
- 테이블 명세
  - r_no            INT     PK  AutoIncrement
  - r_user_name     VARCHAR
  - r_user_password VARCHAR
  - r_room_no       VARCHAR
  - r_reserve_date  DATE
  - r_start_time    VARCHAR
  - r_end_time      VARCHAR
  - r_use_yn        VARCHAR
  - r_regist_date   DATE

### 3.2 빌드/배포
- 프로젝트 다운로드 후 압축해제
- 프로젝트 소스들과 pom.xml 이 있는 경로로 이동하여 mvn package 명령어 실행
- target 폴더 밑에 생성된 프로젝트.war 파일을 톰캣 폴더의 webapps 경로 밑에 ROOT.war 로 복사
- 톰켓 기동

### 3.3 실행방법
- 톰캣 기동 후 http://localhost:8080/reserve/status url로 접속
- 일자 선택하여 예약 현황 조회 (예약자명, 회의실, 예약시간)
- 조회된 예약정보 클릭하면 세부 정보 화면으로 이동
- 자신이 예약했던 비밀번호 입력하여 일치하면 예약취소, 불일치하면 취소불가
- 신규 예약시 예약자명, 비밀번호, 회의실, 예약일자, 예약시간, 반복횟수 입력하여 예약 (예약가능 확인여부 조회 후 저장)
