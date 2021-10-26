class Node:
    def __init__(self,data = None,left = None,right = None):
        self.data = data
        self.left = left
        self.right = right

class SearchBinaryTree:
    def __init__(self,root = None):
        self.root = root

    def get_tree_height(self, root):
        if root.data is None:
            return 0
        else:
            return 1 + max(self.get_tree_height(root.left), self.get_tree_height(root.right))
    
    def append(self,*datas):
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
        for data in datas:
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
            tree.data = self.remove_min(tree.right)

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
        if tree is None:
            return
        else:
            self.print_tree(tree.left)
            print(tree.data,end=" ")
            self.print_tree(tree.right)

    def __str__(self):
        pass