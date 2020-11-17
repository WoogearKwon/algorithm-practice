# AlgorithmPractice
알고리즘 문제 풀이 저장소

## 사용한 IDE
- IntelliJ IDEA 2020.1.1 (EDU)

## 소스코드 작성법 및 실행방법
- 문제 풀이는 각각의 클래스를 생성해서 작성한다.
- 각각의 문제는 Problem 클래스를 상속받는다. 
- Main.java의 problems HashMap에 클래스를 넣는다.
- 풀이는 각 Problem 클래스의 solution() 메서드에 작성한다. 
- 실행하고자 하는 문제의 key로 문제에 접근하고 run()을 호출해 실행한다.

## 문제 풀이 기록
### 프로그래머스 기출
- [20.10.18] [크레인 인형뽑기 게임](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/kakao/KakaoCranePick.java) - 프로그래머스(2019 카카오 개발자 겨울 인턴십)
- [20.10.18] [두 개 뽑아서 더하기](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/code_challenge/PickAndPlus.java) - 프로그래머스(월간 코드 챌린지 시즌1)
- [20.10.20] [키패드 누르기](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/kakao/KeypadClick.java) - 프로그래머스(카카오 인턴)

### 정렬
- [20.10.21] [K번째수 구하기](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/sort/NumberInK.java) - 2차배열을 잘라서 정렬하고 임의의 차례에 있는 수 구하기
- [20.10.26] [가장 큰 수](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/sort/BiggestNumber.java) - 배열의 숫자를 문자열로 변환하여 붙여서 가장 큰 수의 조합 찾기
- [20.10.27] [H-Index](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/sort/HIndex.java) - 배열을 정렬해서 특정 조건의 숫자 구하기

### 해시
- [20.10.28] [완주하지 못한 선수](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/hash/Marathon.java) - 조건에 부합하는 사람 이름 찾기
- [20.10.31] [전화번호 목록](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/hash/PhoneNumbers.java) - 전화번호 중에 접두어가 겹치는 경우가 있는지 확인하기
- [20.11.01] [위장](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/hash/Camouflage.java) - 2차원 배열에 담긴 옷을 서로 다른 종류대로 조합할 수 있는 경우의 수 구하기
- [20.11.07] [베스트앨범](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/hash/BestAlbum.java) - 각 장르별로 가장 많이된 음악의 index를 최대 2개씩 구하기

### 스택/큐
- [20.11.09] [주식 가격](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/stack_queue/StockPrice.java) - 초마다 기록된 주식가격이 각 초마다 가격이 떨어지지 않은 시간 구하기
- [20.11.11] [기능 개발](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/stack_queue/DevelopingFunction.java) - 개발중인 기능의 작업진도와 속도를 고려해 일정별 배포 가능한 기능의 개수가 담긴 배열을 만들기
- [20.11.13] [다리를 건너는 트럭](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/stack_queue/PassingTrucks.java) - 매 1초마다 1만큼 움직이는 트럭들이 다리가 견디는 무게를 넘지 않고 1차선 다리 위를 순서대로 모두 건너는 시간 구하기
- [20.11.14] [프린터](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/stack_queue/Printer.java) - 우선순위가 높은 문서를 먼저 출력하는 프린터에서 내 문서가 출력되는 순서 구하기

### 힙(Heap)
- [20.11.18] [더 맵게](https://github.com/WoogearKwon/AlgorithmPractice/blob/master/src/problems/heap/MoreSpicy.java) - 모든 음식이 스코빌 지수 K이상이 되도록 가장 덜 매운 음식 두 개를 조합하기