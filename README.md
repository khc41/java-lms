# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Step1. 요구 사항
* 질문 데이터를 완전히 삭제하는 것이 아니라 데이터의 상태를 삭제 상태(deleted - boolean type)로 변경한다. 
* 로그인 사용자와 질문한 사람이 같은 경우 삭제 가능하다. 
* 답변이 없는 경우 삭제가 가능하다. 
* 질문자와 답변글의 모든 답변자 같은 경우 삭제가 가능하다. 
* 질문을 삭제할 때 답변 또한 삭제해야 하며, 답변의 삭제 또한 삭제 상태(deleted)를 변경 한다. 
* 질문자와 답변자가 다른경우 답변을 삭제할수 없다. 
* 질문과 답변 삭제 이력에 대한 정보를 DeleteHistory를 활용해 남긴다.

## Step1. 기능 구현
- [X] Audit 분리
- [X] 일급 콜렉션 래핑 (List<Answer> -> Answers)
- [X] 서비스 레이어 로직 이동
  - [X] Answer에 delete 책임 이동
  - [X] 삭제 시 DeleteHistory 반환
  - [X] Answers에서 일괄 적용
  - [X] Question에 delete 책임 이동
  - [X] 삭제 시 DeleteHistory 반환
  - [X] Answer, Question 주인이 아닐 시 삭제 불가 예외 추가
- [X] Question의 List<Answer> -> Answers로 대체

## Step1. 피드백 구현
- [X] Readme 에 체크리스트 적용
- [X] DeleteHistory에 정적 팩토리 메소드 패턴 구현
- [ ] 접근 제어자 추가 (private)