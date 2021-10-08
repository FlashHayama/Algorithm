class Node:
    def __init__(self,data,left = None,right = None):
        self.data = data
        self.left = left
        self.right = right

class BinaryTree:
    def __init__(self):
        pass

class SearchBinaryTree(BinaryTree):
    def __init__(self,root = None):
        self.root = root
    
    def append(self,data):
        def append(data,tree):
            if tree is None:
                tree = Node(data)
            elif tree.data < data:
                append(data,tree.right)
            elif tree.data > data:
                append(data,tree.left)
            else:
                print("Data is already in tree")
        append(data,self.root)
        print("Data appended")

    def print_tree(self,tree):
        if tree is None:
            return
        else:
            self.print_tree()

    def __str__(self):
        pass

tree = SearchBinaryTree()

tree.append(56)
tree.append(40)
tree.append(100)
tree.append(40)