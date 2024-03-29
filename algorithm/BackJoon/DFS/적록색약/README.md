백준 10026번 적록색약  
적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다. 따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다. 
크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다. 그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 
색으로 이루어져 있다. 또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다. (색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)    
예를 들어, 그림이 아래와 같은 경우에  
RRRBB  
GGBBB  
BBBRR  
BBRRR  
RRRRR  
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)  
그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.  

입력형식  
첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)  
둘째 줄부터 N개 줄에는 그림이 주어진다.  
출력형식  
적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.  

입력예제  
5  
RRRBB  
GGBBB  
BBBRR  
BBRRR  
RRRRR  
출력예제  
4 3  

키워드 : dfs를 이용하여 풀이가 가능하다.  
상하좌우로 이동하면서 주변의 색을 탐색하므로 이동할 수 있도록 배열 dx와 dy를 선언하고 현재 위치에서 범위를 벗어나지 않는다면 상하좌우로 이동한다.  

일반인의 경우의 결과값은 이동한 배열이 방문하지 않은 위치이고 이동하기 전의 위치의 값과 같은 값이라면 dfs를 재귀호출한다. 하나의 재귀문을 모두 빠져나왔을 때 결과를 하나씩 증가시킨다.  

적록색약인의 경우는 R과 G를 같은 값으로 봐야 하므로 G인 경우를 R로 모두 바꿔야한다. 그러므로 처음 현재 위치의 값이 G일 경우에 R로 바꾸고 이동한 배열이 방문하지 않은 
위치이고 이동한 배열의 값이 G인 경우 마찬가지로 R로 바꿔준후 이동하기 전의 위치의 값과 같은 값일 때 dfs를 재귀호출한다. 하나의 재귀문을 모두 빠져나왔을 때 결과를 하나씩 증가시킨다.  


