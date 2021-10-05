
head = [0,1,5,6,9,9,11,12]
succ = [4,0,2,4,5,6,0,1,2,4,6,1]

def search_bfs(summit):
    if (len(head) <= summit):
        print("Summit is not exist")
        return
    mark = [False] * len(head)
    mark[summit] = True
    z = []
    z.append(summit)
    sSummits = [summit]
    print(z)
    while len(z) > 0:
        x = z[0]
        z.remove(x)
        for y in succ[head[x]:head[x+1]] :
            if not mark[y]:
                mark[y] = True
                z.append(y)
                sSummits.append(y)
        print(z)
    print(sSummits)
    return sSummits

#search_bfs(3)

def search_dfs(summit):
    if len(head) <= summit:
        print("Summit is not exist")
        return
    mark = [False] * len(head)
    mark[summit] = True
    z = []
    z.append(summit)
    next = head[:]
    sSummits = [summit]
    print(z)
    while len(z) > 0:
        x = z[-1]
        if next[x] >= head[x+1]:
            z.pop()
        else:
            y = succ[next[x]]
            next[x] = next[x] + 1
            if not mark[y]:
                mark[y] = True
                z.append(y)
                sSummits.append(y)
        print(z)
    print(sSummits)
    return sSummits

search_dfs(3)