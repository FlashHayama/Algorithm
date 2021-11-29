class Node:
    def __init__(self,t) -> None:
        self.t = t
        self.size = 0
        self.leaf = True
        self.child = [None]*(2*t)
        self.data = [None]*(2*t-1)

    def add(self, data):
        if self.size < self.t:
            self.data[self.size] = data
            self.size += 1

class BTree:
    def __init__(self,t) -> None:
        self.t = t
        self.root = Node(t)

n = Node(3)
print(n.t)
print(len(n.data))
print(len(n.child))