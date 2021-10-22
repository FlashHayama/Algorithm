from binarySearchTree import SearchBinaryTree,Node

class NodeAVL(Node):
    def __init__(self, data=None, left=None, right=None, balance = 0, height = 0):
        super().__init__(data=data, left=left, right=right)
        self.height = height

class AVL(SearchBinaryTree):
    def __init__(self,root = NodeAVL()):
        super().__init__(root)

    def calcul_height(self, tree):
        if tree.data is None:
            tree.height = 0
        elif tree.right.data is None and tree.left.data is None:
            tree.height = 1
        elif tree.left.data is None:
            tree.height = 1 + tree.right.height
        elif tree.right.data is None:
            tree.height = 1 + tree.left.height
        else:
            tree.height = 1 + max(tree.left.height,tree.right.height)

    def get_tree_height(self, tree):
        return tree.height

    def calcul_balancing(self,tree):
        bal = 0
        if tree.right is not None and tree.left is not None:
            bal = tree.right.height - tree.left.height
        elif tree.right is None and tree.left is not None:
            bal = 0 - tree.left.height
        elif tree.left is None and tree.right is not None:
            bal = tree.right.height
        return bal

    def append(self,*datas):
        def append(data,tree):
            if tree.data is None:
                tree.data = data
                tree.height = 1
                tree.left = NodeAVL()
                tree.right = NodeAVL()
            elif tree.data == data:
                print("Data is already in tree")
            elif tree.data < data:
                append(data,tree.right)
                self.balance(tree)
            elif tree.data > data:
                append(data,tree.left)
                self.balance(tree)
        for data in datas:
            if isinstance(data,int):
                append(data,self.root)
            else:
                print(str(data) + " is not a integer")
    
    def balance(self,tree):
        if tree.right is None and tree.left is None: return
        bal = self.calcul_balancing(tree)
        balRight = self.calcul_balancing(tree.right)
        balLeft = self.calcul_balancing(tree.left)
        if bal == 2 :
            if balRight >= 0:
                self.left_rotate(tree)
            elif balRight < 0:
                self.double_left_rotate(tree)
        elif bal == -2:
            if balLeft <= 0:
                self.right_rotate(tree)
            elif balLeft > 0:
                self.double_right_rotate(tree)
        else:
            self.calcul_height(tree)

    def left_rotate(self,tree):
        tempRight = tree.right
        tValue = tree.data
        tree.data = tree.right.data
        tree.right.data = tValue
        tree.right = tree.right.right
        tempRight.right = tempRight.left
        tempRight.left = tree.left
        tree.left = tempRight

    def double_left_rotate(self,tree):
        self.right_rotate(tree.right)
        self.left_rotate(tree)

    def right_rotate(self,tree):
        tempLeft = tree.left
        tValue = tree.data
        tree.data = tree.left.data
        tree.left.data = tValue
        tree.left = tree.left.left
        tempLeft.left = tempLeft.right
        tempLeft.right = tree.right
        tree.right = tempLeft

    def double_right_rotate(self,tree):
        self.left_rotate(tree.left)
        self.right_rotate(tree)

    def remove(self,*datas):
        def remove(data,tree):
            if tree.data is None:
                print("Data " + str(data) + " is not in tree")
                return
            if data < tree.data:
                remove(data,tree.left)
                self.balance(tree)
            elif data > tree.data:
                remove(data,tree.right)
                self.balance(tree)
            else:
                self.remove_root(tree)
                self.balance(tree)
        for data in datas:
            if isinstance(data, int):
                remove(data,self.root)
            else:
                print(str(data) + " is not a integer")

    def remove_min(self,tree):
        if tree.left.data is None:
            min = tree.data
            self.remove_root(tree)
        else:
            min = self.remove_min(tree.left)
            self.balance(tree)
        return min

    def remove_root(self,tree):
        if tree.left.data is None and tree.right.data is None:
            tree.data = None
            tree.left = None
            tree.right = None
        elif tree.left.data is None:
            tree.data = tree.right.data
            tree.height = tree.right.height
            tree.left = tree.right.left
            tree.right = tree.right.right
        elif tree.right.data is None:
            tree.data = tree.left.data
            tree.height = tree.left.height
            tree.right = tree.left.right
            tree.left = tree.left.left
        else:
            tree.data = self.remove_min(tree.right)
            self.balance(tree)

    def search_data(self, data):
        return super().search_data(data)

    def print_tree(self, tree):
        super().print_tree(tree)
