# 기능 목록

- 사용자 입력값 추출
  - 자동차 이름
  - 시도 횟수
- 사용자 입력값 검증(Validation)
  - 시도할 회수가 숫자인지 검증
  - 자동차 이름이 5자 이하인지 검증
  - 자동차 이름 입력 시 쉼표 이외의 특수문자가 없는지 검증
  - 잘못된 값일 경우 IllegalArgumentException 발생
    - [Error]로 시작하는 에러 메시지 출력
    - 오류 발생시 해당 입력을 다시 입력받음
- 랜덤값 생성(0~9 사이)
- 결과 판단
  - 우승자 판단
- 결과 출력
  - 차수별 실행 결과 출력
  - 우승자 결과 출력
- 경주
  - 생성된 랜덤값을 통해서 전진, 정지 판단