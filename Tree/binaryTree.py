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
                print("Data " + str(data) + " insert\n")
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

    def remove_min(self,tree):
        if tree.left.data is None:
            data = tree.data
            self.remove_root(tree)
            return data
        else:
            return self.remove_min(tree.left)

    def remove_root(self,tree):
        if tree.left.data is None and tree.right.data is None:
            tree.data = None
            tree.left = None
            tree.right = None
        elif tree.left.data is None:
            tree.data = tree.right.data
            tree.left = tree.right.left
            tree.right = tree.right.right
        elif tree.right.data is None:
            tree.data = tree.left.data
            tree.right = tree.left.right
            tree.left = tree.left.left
        else:
            tree.data = self.remove_min(tree)

    def remove(self,data):
        def remove(data,tree):
            if tree.data is None:
                print("Data " + str(data) + " is not in tree")
                return
            if data < tree.data:
                remove(data,tree.left)
            elif data > tree.data:
                remove(data,tree.right)
            else:
                self.remove_root(tree)
        remove(data,self.root)

    def search_data(self,data):
        def search_data(data,tree):
            if tree.data is None:
                print("Data " + str(data) + " is not in tree\n")
                return False
            if tree.data == data:
                print("Data " + str(data) + " is in tree\n")
                return True
            if data < tree.data:
                return search_data(data,tree.left)
            else:
                return search_data(data,tree.right)
        search_data(data,self.root)

    def print_tree(self,tree):
        if tree.data is None:
            return
        else:
            self.print_tree(tree.left)
            print(tree.data,end="\n")
            self.print_tree(tree.right)

    def __str__(self):
        pass

btree = SearchBinaryTree()

btree.append(56),btree.append(40),btree.append(100),btree.append(2)
btree.append(80),btree.append(34),btree.append(23),btree.append(200)
btree.append(70),btree.append(68),btree.append(69),btree.append(65)
btree.print_tree(btree.root)
btree.search_data(2),btree.search_data(80),btree.search_data(24)

btree.remove(80)
btree.print_tree(btree.root)
btree.search_data(80)