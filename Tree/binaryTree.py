from binarySearchTree import *
from AVL import *


#btree = SearchBinaryTree()
btree = AVL()
#56,40,99,2,80,34,23,100,70,68,69,65,76,75,78,1,3,10
btree.append(56,40,99,2,80,34,23,100,70,68,69,65,76,75,78,1,3,10)

btree.print_tree(btree.root)
print("\n")
#btree.search_data(2),btree.search_data(80),btree.search_data(24)

print(btree.get_tree_height(btree.root))
print(btree.calcul_balancing(btree.root))
print(btree.get_tree_height(btree.root.left),btree.get_tree_height(btree.root.right))

btree.remove(56,10,69,75,78,80,100,76)

btree.print_tree(btree.root)
print("\n")
print(btree.get_tree_height(btree.root))
print(btree.calcul_balancing(btree.root))
print(btree.get_tree_height(btree.root.left),btree.get_tree_height(btree.root.right))