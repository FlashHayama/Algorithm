class Heap:
    def get_max(tab):
        if len(tab) > 0:
            return tab[0]

    def get_min(tab):
        if len(tab) > 0:
            min = tab[0]
            for index in range(len(tab)//2,len(tab),1):
                if(tab[index] < min):
                    min = tab[index]
            return min
    
    def heapify_up(self,tab,n,i):
        if len(tab) > 0:
            p = (i + 1)//2 - 1
            if p >= 0 and tab[p] < tab[i]:
                t = tab[i]
                tab[i] = tab[p]
                tab[p] = t
                self.heapify_up(tab,n,p)

    def heapify_down(self,tab, n, i):
        if len(tab) > 0:
            l = (i + 1) * 2 - 1
            r = (i + 1) * 2
            if l <= n and tab[l] > tab[i]:
                largest = l
            else: 
                largest = i
            if r <= n and tab[r] > tab[largest]:
                largest = r
            if i != largest:
                t = tab[i]
                tab[i] = tab[largest]
                tab[largest] = t
                self.heapify_down(tab,n,largest)


    def delete(tab,*datas):
        pass

    def append(self,tab,*datas):
        for data in datas:
            if isinstance(data, int):
                tab.append(data)
                endIndex = len(tab)-1
                self.heapify_up(tab,endIndex,endIndex)

    def create_heap(self,tab):
        for i in range((len(tab)+1)//2-1,-1,-1):
            self.heapify_down(tab,len(tab)-1,i)

    def sort(self,tab,withInsert = False):
        pass

    def __str__(tab):
        pass

#89,45,70,23,40,69,54,20,19,37,32,21,10,4,7,2,3,1
h = Heap()
tab = []
h.append(tab,4,3,17,10,80,19,21,9)
print("tab",tab)
tab2 = [4,3,17,10,80,19,21,9]
h.create_heap(tab2)
print("tab2",tab2)

print(Heap.get_max(tab2))
print(Heap.get_min(tab2))