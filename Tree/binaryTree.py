from binarySearchTree import *
from AVL import *


#btree = BinarySearchTree()
btree = AVL()
#56,40,99,2,80,34,23,100,70,68,69,65,76,75,78,1,3,10
btree.append(56,40,99,2,80,34,23,100,70,68,69,65,76,75,78,1,3,10)

print(btree)
#btree.search_data(2),btree.search_data(80),btree.search_data(24)

btree.remove(76)
print("\n")
print(btree)