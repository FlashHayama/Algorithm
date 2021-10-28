from binarySearchTree import SearchBinaryTree,Node

class NodeAVL(Node):
    def __init__(self, data=None, left=None, right=None, balance = 0, height = 0):
        super().__init__(data=data, left=left, right=right)
        self.height = height

class AVL(SearchBinaryTree):
    def __init__(self,root = None):
        super().__init__(root)

    def calcul_height(self, tree) -> None:
        if tree is None: return
        tree.height = 1 + max(self.get_tree_height(tree.left),self.get_tree_height(tree.right))

    def get_tree_height(self, tree) -> int:
        if tree is None: return 0
        return tree.height

    def calcul_balancing(self,tree) -> int:
        if tree is None: return 0

        return self.get_tree_height(tree.right) - self.get_tree_height(tree.left)

    def append(self,*datas) -> NodeAVL:
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
    
    def balance(self,tree) -> NodeAVL:
        if tree is None: return tree
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

    def left_rotate(self,tree) -> NodeAVL:
        y = tree.right
        T2 = y.left

        y.left = tree
        tree.right = T2

        self.calcul_height(tree)
        self.calcul_height(y)

        return y

    def double_left_rotate(self,tree) -> NodeAVL:
        tree.right = self.right_rotate(tree.right)
        return self.left_rotate(tree)

    def right_rotate(self,tree) -> NodeAVL:
        y = tree.left
        T3 = y.right

        y.right = tree
        tree.left = T3

        self.calcul_height(tree)
        self.calcul_height(y)

        return y

    def double_right_rotate(self,tree) -> NodeAVL:
        tree.left = self.left_rotate(tree.left)
        return self.right_rotate(tree)

    def remove_one(self,data,tree) -> NodeAVL:
            if tree is None:
                print("Data " + str(data) + " is not in tree")
            elif data < tree.data:
                tree.left = self.remove_one(data,tree.left)
            elif data > tree.data:
                tree.right = self.remove_one(data,tree.right)
            else:
                tree = self.remove_root(tree)

            self.calcul_height(tree)
            tree = self.balance(tree)

            return tree

    def remove(self,*datas) -> None:
        for data in datas:
            if isinstance(data, int):
                self.root = self.remove_one(data,self.root)
            else:
                print(str(data) + " is not a integer")

    def get_min(self,tree) -> NodeAVL:
        if tree.left is None:
            min = tree
        else:
            min = self.get_min(tree.left)
        return min

    def remove_root(self,tree) -> NodeAVL:
        if tree.left is None and tree.right is None:
            tree = None
        elif tree.left is None:
            temp = tree.right
            tree = temp
        elif tree.right is None:
            temp = tree.left
            tree = temp
        else:
            min = self.get_min(tree.right)
            tree.data = min.data
            tree.right = self.remove_one(min.data,tree.right)
            self.calcul_height(tree)
            
        return tree

    def search_data(self, data) -> NodeAVL:
        return super().search_data(data)

    def print_tree(self, tree) -> None:
        if tree is None:
            return
        else:
            self.print_tree(tree.left)
            print(str(tree.data) + ":h" + str(tree.height) , end=" ")
            self.print_tree(tree.right)
