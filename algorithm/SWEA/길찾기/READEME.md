SWEA 1219 길찾기  
그림과 같이 도식화한 지도에서 A도시에서 출발하여 B도시로 가는 길이 존재하는지 조사하려고 한다.  
길 중간 중간에는 최대 2개의 갈림길이 존재하고, 모든 길은 일방 통행으로 되돌아오는 것이 불가능하다.  
다음과 같이 길이 주어질 때, A도시에서 B도시로 가는 길이 존재하는지 알아내는 프로그램을 작성하여라.  
- A와 B는 숫자 0과 99으로 고정된다.  
- 모든 길은 순서쌍으로 나타내어진다. 위 예시에서 2번에서 출발 할 수 있는 길의 표현은 (2, 5), (2, 9)로 나타낼 수 있다.  
- 가는 길의 개수와 상관없이 한가지 길이라도 존재한다면 길이 존재하는 것이다.  
- 단 화살표 방향을 거슬러 돌아갈 수는 없다.  

입력형식  
각 테스트 케이스의 첫 줄에는 테스트 케이스의 번호와 길의 총 개수가 주어지고 그 다음 줄에는 순서쌍이 주어진다.  
순서쌍의 경우, 별도로 나누어 표현되는 것이 아니라 숫자의 나열이며, 나열된 순서대로 순서쌍을 이룬다.  
출력형식  
#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스에 대한 답을 출력한다.  

입력예제  
[input.txt](input.txt)  
출력예제  
[output.txt](output.txt)  

키워드 : DFS를 이용하여 풀이가 가능하다.  
0부터 출발해 모든 노드를 방문해 나가면서 99노드에 도착할 경우 1을 출력하고 99에 도착하지 못할 경우 0을 출력한다.  
