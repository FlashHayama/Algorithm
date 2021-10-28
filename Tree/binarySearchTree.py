class Node:
    def __init__(self,data = None,left = None,right = None):
        self.data = data
        self.left = left
        self.right = right

class BinarySearchTree:
    def __init__(self,root = None):
        self.root = root

    def get_tree_height(self, root):
        if root is None: return 0
        return 1 + max(self.get_tree_height(root.left), self.get_tree_height(root.right))
    
    def append(self,*datas) -> Node:
        def append(data,tree):
            if tree is None:
                return Node(data=data)
            elif tree.data == data:
                print("Data is already in tree")
            elif tree.data < data:
                tree.right = append(data,tree.right)
            elif tree.data > data:
                tree.left = append(data,tree.left)
            return tree
        for data in datas:
            if isinstance(data, int):
                self.root = append(data,self.root)
            else:
                print("Data " + str(data) + " is not a integer")

    def get_min(self,tree) -> Node:
        if tree.left is None:
            min = tree
            return min
        else:
            return self.get_min(tree.left)

    def remove_root(self,tree):
        if tree.left is None and tree.right is None:
            tree = None
        elif tree.left is None:
            tree = tree.right
        elif tree.right is None:
            tree = tree.left
        else:
            min = self.get_min(tree.right)
            tree.data = min.data
            tree.right = self.remove_one(min.data, tree.right)
        
        return tree

    def remove_one(self,data,tree) -> Node:
        if tree is None:
            print("Data " + str(data) + " is not in tree")
        if data < tree.data:
            tree.left = self.remove_one(data,tree.left)
        elif data > tree.data:
            tree.right = self.remove_one(data,tree.right)
        else:
            tree = self.remove_root(tree)
        return tree

    def remove(self,*datas) -> None:
        for data in datas:
            if isinstance(data, int):
                self.root = self.remove_one(data,self.root)
            else:
                print("Data " + str(data) + " is not a integer")

    def search_data(self,data) -> bool:
        def search_data(data,tree):
            if tree is None:
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

    def print_tree(self,tree) -> str:
        if tree is None: 
            return ""
        else:
            return self.print_tree(tree.left) + str(tree.data) + " " + self.print_tree(tree.right)
            

    def __str__(self) -> str:
        string = "Data :\t\t" + self.print_tree(self.root) + "\n"
        string += "Height :\t" + str(self.get_tree_height(self.root)) + "\n"
        string += "Child height :\t" + str(self.get_tree_height(self.root.left)) + " " + str(self.get_tree_height(self.root.right)) + "\n"
        return string