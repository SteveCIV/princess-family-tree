# princess-family-tree
Reads in princesses to assemble family tree and does level order traversal of tree


#### To create a tree
1) Loop  
  a) Read line from file and create a new node  
  b) Look up mothers name in hash table  
  c) Link child node to mother node with setFirstChild  
  d) Link to child node in the hash table

#### To level-order traverse the tree
1) Add common ancestor of all children to queue
2) Loop  
  a) Remove a node  
  b) Print name of node  
  c) Add children form eldest to youngest to queue  

#### Each tree node contains 
1) String name
2) int birth year
3) TNode first child
4) TNode next sibling
