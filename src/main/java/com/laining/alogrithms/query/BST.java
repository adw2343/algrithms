package com.laining.alogrithms.query;

public class BST<Key extends Comparable<Key>, Value> implements ST<Key, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left;
        private Node right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    public void put(Key key, Value value) {
        put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null)
            return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, value);
        else if (cmp > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private int size(Node node) {
        if (node == null)
            return 0;
        return node.size;
    }

    public Value get(Key key) {
        Node node = get(root, key);
        return node == null ? null : node.value;
    }

    private Node get(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    public void delete(Key key) {
        if (key == null)
            return;
        root = delete(root, key);
    }

    private Node delete(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;
            Node xNode = node;
            node = min(xNode.right);
            node.right = deleteMin(xNode.right);
            node.left = xNode.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;

    }

    public boolean contains(Key key) {
        return get(root, key) != null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size(root);
    }

    public Key min() {
        if (root == null)
            return null;
        return min(root).key;
    }

    private Node min(Node node) {
        if (node.left == null)
            return node;
        return min(node.left);
    }

    public Key max() {
        if (root == null)
            return null;
        return max(root).key;
    }

    private Node max(Node node) {
        if (node.right == null)
            return node;
        return max(node.right);
    }

    public Key floor(Key key) {
        if (key == null)
            return null;
        Node node = floor(root, key);
        return node == null ? null : node.key;
    }

    private Node floor(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = node.key.compareTo(key);
        if (cmp == 0) {
            return node;
        } else if (cmp > 0) {
            return floor(node.left, key);
        }
        Node tNode = floor(node.right, key);
        if (tNode == null)
            return node;
        else {
            return tNode;
        }
    }

    public Key ceiling(Key key) {
        if (key == null)
            return null;
        Node node = ceiling(root, key);
        return node == null ? null : node.key;
    }

    private Node ceiling(Node node, Key key) {
        if (node == null)
            return null;
        int cmp = node.key.compareTo(key);
        if (cmp == 0)
            return node;
        else if (cmp < 0) {
            return ceiling(node.right, key);
        } else {
            Node tNode = ceiling(node.left, key);
            if (tNode != null)
                return tNode;
            else
                return node;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if (node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            return rank(node.left, key);
        if (cmp > 0)
            return 1 + size(node.left) + rank(node.right, key);
        else
            return size(node.left);

    }

    public Key select(int k) {
        Node node = select(root, k);
        return node == null ? null : node.key;
    }

    private Node select(Node node, int k) {
        if (node == null)
            return null;
        int t = size(node.left);
        if (k < t)
            return select(node.left, k);
        else if (k > t)
            return select(node.right, k - t - 1);
        else {
            return node;
        }
    }

    public void deleteMin() {
        if (root == null)
            return;
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
        if (node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if (node == null)
            return null;
        if (node.right == null)
            return node.left;
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int size(Key lo, Key hi) {
        return size(root);
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    public Iterable<Key> keys() {
        return null;
    }

    private boolean check() {
        if (!isBST())
            System.out.println("Not in symmetric order");
        if (!isSizeConsistent())
            System.out.println("Subtree counts not consistent");
        if (!isRankConsistent())
            System.out.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
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

}
