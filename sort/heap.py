class Heap:
    def get_max(tab):
        if len(tab) > 0:
            return tab[0]

    def get_min(tab):
        if len(tab) > 0:
            min = tab[0]
            for data in range(len(tab)//2,len(tab)):
                if(data < min):
                    min = data
            return min

    def heapify(tab, i):
        pass

    def delete(data):
        pass

    def append(data):
        pass

    def create_heap_with_insert():
        pass

    def create_heap():
        pass

    def sort(withInsert = False):
        pass

    def __str__(tab):
        pass