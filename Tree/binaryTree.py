class Node:
    def __init__(self,data = None,left = None,right = None):
        self.data = data
        self.left = left
        self.right = right

class BinaryTree:
    def __init__(self):
        pass

class SearchBinaryTree(BinaryTree):
    def __init__(self,root = Node()):
        self.root = root
    
    def append(self,data):
        def append(data,tree):
            if tree.data is None:
                print("Data insert")
                tree.data = data
                tree.left = Node()
                tree.right = Node()
            elif tree.data == data:
                print("Data is already in tree")
            elif tree.data < data:
                print("Go right")
                append(data,tree.right)
            elif tree.data > data:
                print("Go left")
                append(data,tree.left)
        append(data,self.root)
        print("Data appended")

    def print_tree(self,tree):
        if tree.data is None:
            print("Tree is None")
        else:
            self.print_tree(tree.left)
            print(tree.data)
            self.print_tree(tree.right)
            print(tree.data)

    def __str__(self):
        pass

tree = SearchBinaryTree()

tree.append(56)
tree.append(40)
tree.append(100)
tree.append(40)
tree.print_tree(tree.root)