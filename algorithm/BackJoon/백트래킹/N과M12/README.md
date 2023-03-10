백준 15666번 N과 M(12)    
N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.  
◎N개의 자연수 중에서 M개를 고른 수열  
◎같은 수를 여러 번 골라도 된다.  
◎고른 수열은 비내림차순이어야 한다.  
◎길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.  

입력형식  
첫째 줄에 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)  
둘째 줄에 N개의 수가 주어진다. 입력으로 주어지는 수는 10,000보다 작거나 같은 자연수이다.  
출력형식  
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.  
수열은 사전 순으로 증가하는 순서로 출력해야 한다.  

입력예제  
4 2  
9 7 9 1  
출력예제  
1 1  
1 7  
1 9  
7 7  
7 9  
9 9  

키워드 : 백트래킹으로 해결가능하다. 중복된 수열은 허용되지 않으므로 before의 변수에 이전노드의 값을 저장해두고 중복된 수열의 출력을 피한다.  
비내림차순의 수열만 출력해야 하므로 at이라는 변수를 통해 시작지점을 저장해두고 시작지점의 다음노드부터만 시작할 수 있도록 함으로써 비내림차순을 지킬 수 있다.  

------------------------------------------------------------------------------------------------------------

N과 M 백트래킹 문제 문제보고 해석하기  
⭐️같은 수를 여러 번 고르면 안된다 => isUsed와 같은 boolean배열을 통해 사용했는지 체크한다.  
⭐️비내림차순이어야 한다. => at이라는 변수를 파라미터로 주어 현재노드의 지점을 저장해 두면서 다음노드부터 시작할 수 있도록 한다.  
⭐️중복된 수열은 출력하면 안된다. => before이라는 전 노드의 값을 저장해두고 값이 같으면 출력되지 않도록 한다.