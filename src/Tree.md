# Tree

**A tree is a nonlinear hierarchical data structure that consists of nodes connected by edges.**
Each **node** in the tree store data and references to other nodes (its children).

## Tree Terminologies

**Root**: Root node is a node from which the entire tree originates. It does not have a parent.

**Leaf**: Nodes with no children, i.e., nodes at the end of a branch in the tree.

**Parent Node**: An immediate predecessor of any node is its parent node.

**Child Node**: All immediate successors of a node are its children. The relationship between the parent and child is considered as the parent-child relationship.

**Siblings**: Nodes with common parents are siblings.

**Edge**: The connections between nodes that define the relationships within the tree. In a tree with n nodes, there will be ‘n-1’ edges in a tree.

**Path**: Path is a number of successive edges from source node to destination node.

**Height of a Node**: The height of a node is the number of edges from the node to the deepest leaf (i.e. the longest path from the node to a leaf node).

**Depth of a Node**: The depth of a node is the number of edges from the root to the node.

**Levels of Node**: Level of a node represents the generation of a node. The root node is at level 0, then its next child node is at level 1, its grandchild is at level 2, and so on.

**Degree of Node**: Degree of a node is the number of child nodes a node has.

**Internal Node**: A node that has at least one child is known as an internal node.

**Traversing**: Traversing is a process of visiting each node in a specific order in a tree data structure.

**Ancestor node**: An ancestor or ancestors to a node are all the predecessor nodes from root until that node.

**Descendant**: Any successor node on the path from the leaf node to that node.

**Sub tree**: Descendants of a node represent subtree. Tree being a recursive data structure can contain many subtrees inside of it.

**Height (Depth)**: The height (or depth) of a tree is the height of the root node or the depth of the deepest node (i.e. maximum level of any node in the tree).

**Visiting**: When we’ve iterated or traversed to a specific node programmatically, accessing value or checking value of the current node is called visiting.
