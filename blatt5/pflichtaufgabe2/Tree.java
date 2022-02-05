/**
 * A binary tree with int values.
 */
class Tree {

    /**
     * The value of this node in the tree.
     */
    private int node;

    /**
     * The left subtree.
     */
    private Tree lhs;

    /**
     * The right subtree.
     */
    private Tree rhs;

    /**
     * Creates a new tree with the value node.
     * @param node The value of this node in the tree.
     */
    public Tree(int node) {
        this.node = node;
        this.lhs = null;
        this.rhs = null;

    }

    /**
     * Method to add a node to the tree. Duplicates will be refused.
     *
     * @param insert the new number
    */
    public void add(int insert) {
        Tree newTree = new Tree(insert);
        if ((insert < node) && (lhs == null)) {
            lhs = newTree;
        } else if ((insert < node) && (lhs != null)) {
            lhs.add(insert);
        }
        if ((insert > node) && (rhs == null)) {
            rhs = newTree;
        } else if ((insert > node) && (rhs != null)) {
            rhs.add(insert);
        }
    }

    /**
     * Method to calculate the depth of a tree. It is defined by the maximal
     * number of edges to a leaf.
     *
     * @return the depth of the tree
    */
    public int depth() {
        int depth = 0;
        int left = 0;
        int right = 0;
        if (lhs == null && rhs == null) {
            return 0;
        }
        if (lhs != null) {
            left = lhs.depth();
        }
        if (rhs != null) {
            right = rhs.depth();
        }
        if (left > right) {
            depth = left + 1;
        } else {
            depth = right + 1;
        }

        return depth;
    }

    /**
     * Method to find a number in the tree.
     *
     * @param wanted the wanted number
     * @return true, if the wanted number exists in the try, else false
    */
    public boolean exists(int wanted) {
        boolean exists = false;
        if (wanted == node) {
            return true;
        } else if ((wanted < node) && (lhs != null)) {
            exists = lhs.exists(wanted);
        } else if ((wanted > node) && (rhs != null)) {
            exists = rhs.exists(wanted);
        }
        return exists;
    }

    /**
     * Method to find the smallest number in the tree.
     *
     * @return the smallest number in the tree
    */
    public int smallest() {
        int smallest = 0;
        if (lhs == null) {
            return node;
        } else {
            smallest = lhs.smallest();
        }
        return smallest;
    }

    /**
     * Method to find the biggest number in the tree.
     *
     * @return the biggest number in the tree
    */
    public int biggest() {
        int biggest = 0;
        if (rhs == null) {
            return node;
        } else {
            biggest = rhs.biggest();
        }
        return biggest;
    }

    /**
     * Method to check whether a tree is degenerate.
     *
     * @return true if every node has either no or one child node, else false
    */
    public boolean isDegenerate() {
        boolean degenerate = true;
        if ((lhs != null) && (rhs != null)) {
            degenerate = false;
        } else if ((lhs != null) && (rhs == null)) {
            degenerate = lhs.isDegenerate();
        } else if ((rhs != null) && (lhs == null)) {
            degenerate = rhs.isDegenerate();
        }
        return degenerate;
    }

    /**
     * Method that formats the tree into a readable string.
     *
     * @return the formatted string
    */
    public String toString() {
        String visualTree = "";
        if (lhs == null && rhs == null) {
            visualTree += node;
            return visualTree;
        }
        if (lhs != null) {
            visualTree += "(" + lhs.toString() + ")";
            if (rhs == null) {
                visualTree += node;
            }
            if (lhs != null && rhs != null) {
                visualTree += node;
            }
        }
        if (rhs != null) {
            if (lhs == null) {
                visualTree += node;
            }
            visualTree += "(" + rhs.toString() + ")";
        }
        return visualTree;
    }
}
