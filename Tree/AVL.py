from binarySearchTree import SearchBinaryTree,Node

class NodeAVL(Node):
    def __init__(self, data=None, left=None, right=None, balance = 0, height = 0):
        super().__init__(data=data, left=left, right=right)
        self.height = height

class AVL(SearchBinaryTree):
    def __init__(self,root = None):
        super().__init__(root)

    def calcul_height(self, tree):
        if tree is None: return 0
        tree.height = 1 + max(self.get_tree_height(tree.left),self.get_tree_height(tree.right))

    def get_tree_height(self, tree):
        if tree is None: return 0
        return tree.height

    def calcul_balancing(self,tree):
        if tree is None: return 0

        return self.get_tree_height(tree.right) - self.get_tree_height(tree.left)

    def append(self,*datas):
        def append(data,tree):
            if tree is None:
                return NodeAVL(data=data,height=1)
            elif tree.data == data:
                print("Data is already in tree")
            elif tree.data < data:
                tree.right = append(data,tree.right)
            elif tree.data > data:
                tree.left = append(data,tree.left)
            
            self.calcul_height(tree)
            tree = self.balance(tree)

            return tree
        for data in datas:
            if isinstance(data,int):
                self.root = append(data,self.root)
            else:
                print(str(data) + " is not a integer")
    
    def balance(self,tree):
        if tree is None and tree is None: return tree
        bal = self.calcul_balancing(tree)
        balRight = self.calcul_balancing(tree.right)
        balLeft = self.calcul_balancing(tree.left)
        if bal == 2 :
            if balRight >= 0:
                return self.left_rotate(tree)
            elif balRight < 0:
                return self.double_left_rotate(tree)
        elif bal == -2:
            if balLeft <= 0:
                return self.right_rotate(tree)
            elif balLeft > 0:
                return self.double_right_rotate(tree)
        else:
            return tree

    def left_rotate(self,tree):
        y = tree.right
        T2 = y.left

        y.left = tree
        tree.right = T2

        self.calcul_height(tree)
        self.calcul_height(y)

        return y

    def double_left_rotate(self,tree):
        tree.right = self.right_rotate(tree.right)
        return self.left_rotate(tree)

    def right_rotate(self,tree):
        y = tree.left
        T3 = y.right

        y.right = tree
        tree.left = T3

        self.calcul_height(tree)
        self.calcul_height(y)

        return y

    def double_right_rotate(self,tree):
        tree.left = self.left_rotate(tree.left)
        return self.right_rotate(tree)

    def remove(self,*datas):
        def remove(data,tree):
            if tree is None:
                print("Data " + str(data) + " is not in tree")
            elif data < tree.data:
                tree.left = remove(data,tree.left)
            elif data > tree.data:
                tree.right = remove(data,tree.right)
            else:
                tree = self.remove_root(tree)

            self.calcul_height(tree)
            tree = self.balance(tree)

            return tree
        for data in datas:
            if isinstance(data, int):
                self.root = remove(data,self.root)
            else:
                print(str(data) + " is not a integer")

    def remove_min(self,tree):
        if tree.left is None:
            min = tree.data
            tree = self.remove_root(tree)
        else:
            min = self.remove_min(tree.left)
            self.calcul_height(tree)
        return min

    def remove_root(self,tree):
        if tree.left is None and tree.right is None:
            return None
        elif tree.left is None:
            temp = tree.right
            tree = None
            return temp
        elif tree.right is None:
            temp = tree.left
            tree = None
            return temp
        else:
            tree.data = self.remove_min(tree.right)
            self.calcul_height(tree)

    def search_data(self, data):
        return super().search_data(data)

    def print_tree(self, tree):
        if tree is None:
            return
        else:
            self.print_tree(tree.left)
            print(str(tree.data) + ":h" + str(tree.height) , end=" ")
            self.print_tree(tree.right)
