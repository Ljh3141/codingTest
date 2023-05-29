from collections import deque
def solution(s,e):
    answer = 0
    ch = [0]*10001
    dQ = deque()
    dQ.append(s)
    ch[s]=1
    L = 0
    while(dQ):
        length = len(dQ)
        for _ in range(length):
            x=dQ.popleft()
            if x==e:
                return L
            for nx in[x-1, x+1, x+5]:
                if nx > 0 and nx < 10001 and ch[nx] == 0:
                    ch[n] = 1
                    dQ.append(nx)
        L+=1
    return answer
