package Sem_4;

import java.util.Comparator;

public class MyTree<T> {
    private Node root;
    private Node TNULL;
    private Comparator<T> comparator;

    public MyTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    {
        TNULL = new Node(0);
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
    }

    public void insert(T key) {
        Node<T> node = new Node<>(key);
        Node<T> y = null;
        Node<T> x = this.root;

        while (x != TNULL) {
            y = x;
            if (comparator.compare(key, x.data) < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (comparator.compare(key, y.data) < 0) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node != null && node.color == 1) {
            fixInsert(node);
        }
    }
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            } else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }


    static class Node <T>{
        T data;
        Node parent;
        Node left;
        Node right;
        int color;

        public Node(T data) {
            this.data = data;
            this.color = 1;
            this.parent = this.left = this.right = null;

        }
    }
}