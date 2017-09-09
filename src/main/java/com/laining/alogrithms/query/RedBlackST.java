package com.laining.alogrithms.query;

import com.laining.alogrithms.StdOut;

public class RedBlackST<Key extends Comparable<Key>, Value> extends BST<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root; // root of the BST

    // BST helper node data type
    private class Node {
        private Key key; // key
        private Value val; // associated data
        private Node left, right; // links to left and right subtrees
        private boolean color; // color of parent link
        private int size; // subtree count

        public Node(Key key, Value val, boolean color, int size) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public RedBlackST() {

    }

    /***************************************************************************
     * Node helper methods.
     ***************************************************************************/
    // is node x red; false if x is null ?
    private boolean isRed(Node x) {
        if (x == null)
            return false;
        return x.color == RED;
    }

    // number of node in subtree rooted at x; 0 if x is null
    private int size(Node x) {
        if (x == null)
            return 0;
        return x.size;
    }

    public void put(Key key, Value value) {

    }

    public Value get(Key key) {
        return super.get(key);
    }

    public void delete(Key key) {
        // TODO Auto-generated method stub

    }

    public boolean contains(Key key) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    public Key min() {
        // TODO Auto-generated method stub
        return null;
    }

    public Key max() {
        // TODO Auto-generated method stub
        return null;
    }

    public Key floor(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    public Key ceiling(Key key) {
        // TODO Auto-generated method stub
        return null;
    }

    public int rank(Key key) {
        // TODO Auto-generated method stub
        return 0;
    }

    public Key select(int k) {
        // TODO Auto-generated method stub
        return null;
    }

    public void deleteMin() {
        // TODO Auto-generated method stub

    }

    public void deleteMax() {
        // TODO Auto-generated method stub

    }

    public int size(Key lo, Key hi) {
        // TODO Auto-generated method stub
        return 0;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterable<Key> keys() {
        // TODO Auto-generated method stub
        return null;
    }

    /***************************************************************************
     * Check integrity of red-black tree data structure.
     ***************************************************************************/
    private boolean check() {
        if (!isBST())
            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent())
            StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent())
            StdOut.println("Ranks not consistent");
        if (!is23())
            StdOut.println("Not a 2-3 tree");
        if (!isBalanced())
            StdOut.println("Not balanced");
        return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null)
            return true;
        if (min != null && x.key.compareTo(min) <= 0)
            return false;
        if (max != null && x.key.compareTo(max) >= 0)
            return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    }

    // are the size fields correct?
    private boolean isSizeConsistent() {
        return isSizeConsistent(root);
    }

    private boolean isSizeConsistent(Node x) {
        if (x == null)
            return true;
        if (x.size != size(x.left) + size(x.right) + 1)
            return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    }

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i)))
                return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0)
                return false;
        return true;
    }

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean is23() {
        return is23(root);
    }

    private boolean is23(Node x) {
        if (x == null)
            return true;
        if (isRed(x.right))
            return false;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    }

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() {
        int black = 0; // number of black links on path from root to min
        Node x = root;
        while (x != null) {
            if (!isRed(x))
                black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) {
        if (x == null)
            return black == 0;
        if (!isRed(x))
            black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
    }

}
