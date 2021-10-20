class Node:
    def __init__(self,data = None,left = None,right = None):
        self.data = data
        self.left = left
        self.right = right

class NodeAVL(Node):
    def __init__(self, data=None, left=None, right=None, balance = 0, height = 0):
        super().__init__(data=data, left=left, right=right)
        self.balance = balance
        self.height = height

class BinaryTree:
    def __init__(self):
        pass

class SearchBinaryTree(BinaryTree):
    def __init__(self,root = Node()):
        self.root = root

    def get_tree_height(self, root):
        if root.data is None:
            return 0
        else:
            return 1 + max(self.get_tree_height(root.left), self.get_tree_height(root.right))
    
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

class AVL(SearchBinaryTree):
    def __init__(self,root = NodeAVL()):
        super().__init__(root)

    def calcul_height(self, tree):
        if tree.right.data is None and tree.left.data is None:
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
        if tree.right is not None and tree.left is not None:
            tree.balance = tree.right.height - tree.left.height
        elif tree.right is None and tree.left is not None:
            tree.balance = 0 - tree.left.height
        elif tree.left is None and tree.right is not None:
            tree.balance = tree.right.height
        return tree.balance

    def append(self,data):
        def append(data,tree):
            if tree.data is None:
                print("Data " + str(data) + " insert\n")
                tree.data = data
                tree.left = NodeAVL()
                tree.right = NodeAVL()
                self.balance(tree)
            elif tree.data == data:
                print("Data is already in tree")
            elif tree.data < data:
                append(data,tree.right)
                self.balance(tree)
            elif tree.data > data:
                append(data,tree.left)
                self.balance(tree)
        append(data,self.root)
    
    def balance(self,tree):
        bal = self.calcul_balancing(tree)
        balRight = self.calcul_balancing(tree.right)
        balLeft = self.calcul_balancing(tree.left)
        if bal == 2 and balRight >= 0:
            self.left_rotate(tree)
        elif bal == 2 and balRight < 0:
            self.double_left_rotate(tree)
        elif bal == -2 and balLeft <= 0:
            self.right_rotate(tree)
        elif bal == -2 and balLeft > 0:
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

    def remove(self,data):
        def remove(data,tree):
            if tree.data is None:
                print("Data " + str(data) + " is not in tree")
                return
            if data < tree.data:
                remove(data,tree.left)
                self.test_balance(tree)
            elif data > tree.data:
                remove(data,tree.right)
                self.test_balance(tree)
            else:
                self.remove_root(tree)
        remove(data,self.root)

    def search_data(self, data):
        return super().search_data(data)

    def print_tree(self, tree):
        super().print_tree(tree)


#btree = SearchBinaryTree()
btree = AVL()

btree.append(56),btree.append(40),btree.append(99),btree.append(2)
btree.append(80),btree.append(34),btree.append(23),btree.append(100)
btree.append(70),btree.append(68),btree.append(69),btree.append(65)
btree.append(76),btree.append(75),btree.append(78),btree.append(1)
btree.append(3),btree.append(10)
btree.print_tree(btree.root)
btree.search_data(2),btree.search_data(80),btree.search_data(24)

print(btree.get_tree_height(btree.root))
print(btree.calcul_balancing(btree.root))
print(btree.root.left.height,btree.root.right.height)

#btree.remove(80)
#btree.print_tree(btree.root)
#btree.search_data(80)