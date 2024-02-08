package Sem_4;

public class MyTree<K, V> implements Comparable{
    Node root;

    public MyTree() {
    }

    public V get(Object key) {
        if (root == null) return null;
        if (root.key.equals(key)) return (V) root.value;
        return compareTo();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    static class Node<K, V> {
        K key;
        V value;
        Node parent;
        Node leftChild;
        Node rightChild;

        public Node(K key, V value, Node parent, Node leftChild, Node rightChild) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

    }
}
