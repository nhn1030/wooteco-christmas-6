## 크리스마스 이벤트 구현

목록

1. 구현 요청 사항
2. 요약
3. 클래스 및 구조 설계
---
## 1. 구현 요청 사항
- [ ] 고객들이 식당에 방문할 날짜와 메뉴를 미리 선택하면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용을 보여주기를 기대합니다.
- [ ] 12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
  - [ ] 예외처리
    - 방문할 날짜는 1 이상 31 이하의 숫자로만 입력받아 주세요.
    - 1 이상 31 이하의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- [ ] 주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
  - [ ] 예외처리
    - 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지를 보여 주세요.
    - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성해 주세요.
- 주문 메뉴의 출력 순서는 자유롭게 출력해 주세요.

- [ ] 총혜택 금액에 따라 이벤트 배지의 이름을 다르게 보여 주세요.
  - 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격)
  - 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액

- [ ] 증정 메뉴
  - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 보여 주세요.

- [ ] 혜택 내역
  - 고객에게 적용된 이벤트 내역만 보여 주세요.
  - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 보여 주세요.
  - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게 출력해주세요.

- [ ] 이벤트 배지
  - 이벤트 배지가 부여되지 않는 경우, "없음"으로 보여 주세요.

---

## 2. 요약

### 할인
* 크리스마스 할인
  * 이벤트 기간: 2023.12.1 ~ 2023.12.25 
  * 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  * 총주문 금액에서 해당 금액만큼 할인
  * (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
* 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
* 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
* 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인

### 증정 이벤트 
* 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
* 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

### 이벤트 뱃지 부여
* 5천 원 이상: 별
* 1만 원 이상: 트리
* 2만 원 이상: 산타

---



## 3. 클래스 및 구조 설계

### 클래스

#### 1. EventPlanner 
- EventPlannerModel은 주문 정보(Order), 메뉴 정보(Menu), 할인 정보(Discount), 증정 이벤트 정보(Promotion), 이벤트 배지 정보(Badge) 등을 관리하고 다루며, 이들 클래스와의 상호 작용을 통해 애플리케이션의 핵심 로직을 수행한다.
- 할인, 프로모션 대상 여부 확인
- 특정 주문이 이벤트 조건을 충족시키는 지 확인
- 특정 날짜가 이벤트 조건을 충족시키는 지 확인


#### 2. Order
- Order 클래스는 개별 주문 정보를 나타내는 클래스로서, 사용자가 선택한 메뉴와 수량 등을 저장하고 관리한다.
- 주문된 메뉴와 해당 메뉴의 수량 저장 및 값 반환

#### 3. Menu
- 주문 가능한 메뉴에 대한 정보 저장

#### 4. Discount
- 할인 정보 저장 : 특정 메뉴에 대한 할인 정보 저장
- 적용 대상 메뉴 식별 : 특정 메뉴에 대해 어떤 할인이 이루어저야 하는지
- 할인 내역 출력 : 총 혜택 내역을 출력

#### 5. Badge
- 주문 시 혜택 받은 금액에 따라 부여되는 배지에 대한 정보를 나타냄
- 배지 정보 저장 (별, 트리, 산타)
- 받은 혜택 금액에 따라 어떤 배지를 부여할지 결정
- 배지 정보 출력 시 필요

#### Promotion
- 증정 이벤트 정보 저장 (샴페인)
- 증정 메뉴 역시 총 헤택 내역에 포함 됨

---

## 주문 및 이벤트 처리 로직
1. 사용자로부터 날짜 및 주문정보를 입력 받는다.
   1. 단 숫자만 입력받도록 할 것
   2. 주문정보는 이런식으로 입력 받게끔~ (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)

2. 입력된 날짜에 따라 할인 및 증정 이벤트를 계산한다.
   1. 중복적용 가능

3. 주문 정보를 받아 유효성을 확인하고 할인을 적용한다.

4. 총주문 금액, 할인금액, 증정 메뉴, 혜택 내역, 총 헤택 금액, 할인 후 예상 결제 금액, 이벤트 배지를 출력한다.

---

## 예외처리 구현

1. 주문 및 이벤트 처리 로직 1번 항목 (날짜)
   1. 입력 값의 범위를 1 ~ 31로 제한해야 한다.
   2. 범위 밖의 숫자를 입력할 경우 [ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요. 문구를 전송한다.
2. 주문 및 이벤트 처리 로직 1번 항목 (메뉴)
   1. 메뉴에 없는 것을 입력할 경우 : [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
   2. 주문 갯수는 1이상 부터 가능하다 그외의 경우 : [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
   3. 메뉴 형식이 예시와 다른 경우 : [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.
   4. 중복 된 메뉴를 입력할 경우 : [ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.

---

## 테스트

- [ ] 요구사항에 대한 각 기능 별 테스트 구현 
- [ ] 주문 및 이벤트 처리 로직에 대한 예외사항을 중심으로 테스트를 구현한다.