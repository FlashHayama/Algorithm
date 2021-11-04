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

    def heapify(tab, i):
        pass

    def delete(tab,*datas):
        pass

    def append(tab,*datas):
        pass

    def create_heap_with_insert(tab):
        pass

    def create_heap(tab):
        pass

    def sort(withInsert = False):
        pass

    def __str__(tab):
        pass

#89,45,70,23,40,69,54,20,19,37,32,21,10,4,7,2,3,1
tab = [89,45,70,23,19,69,54,20,21]

print(Heap.get_max(tab))
print(Heap.get_min(tab))