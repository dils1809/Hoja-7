package Files.main;

import java.util.Optional;

public class BinaryTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node<K, V> insert(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            node.setLeftChild(insert(node.getLeftChild(), key, value));
        } else if (cmp > 0) {
            node.setRightChild(insert(node.getRightChild(), key, value));
        }

        return node;
    }

    public Optional<V> search(K key) {
        return search(root, key);
    }

    private Optional<V> search(Node<K, V> node, K key) {
        if (node == null) {
            return Optional.empty();
        }

        int cmp = key.compareTo(node.getKey());
        if (cmp < 0) {
            return search(node.getLeftChild(), key);
        } else if (cmp > 0) {
            return search(node.getRightChild(), key);
        } else {
            return Optional.of(node.getValue());
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<K, V> node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            System.out.println(node.getKey() + ": " + node.getValue());
            inOrderTraversal(node.getRightChild());
        }
    }

    private static class Node<K extends Comparable<K>, V> {
        private final K key;
        private V value;
        private Node<K, V> leftChild;
        private Node<K, V> rightChild;

        private Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K getKey() {
            return key;
        }

        private V getValue() {
            return value;
        }

        private Node<K, V> getLeftChild() {
            return leftChild;
        }

        private void setLeftChild(Node<K, V> leftChild) {
            this.leftChild = leftChild;
        }

        private Node<K, V> getRightChild() {
            return rightChild;
        }

        private void setRightChild(Node<K, V> rightChild) {
            this.rightChild = rightChild;
        }
    }
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        // Insertar algunos nodos en el árbol
        tree.insert(5, "Cinco");
        tree.insert(3, "Tres");
        tree.insert(8, "Ocho");
        tree.insert(1, "Uno");
        tree.insert(4, "Cuatro");

        // Realizar una búsqueda
        System.out.println("Búsqueda de la clave 3: " + tree.search(3).orElse("No encontrado"));

        // Realizar recorrido inorden
        System.out.println("Recorrido inorden del árbol:");
        tree.inOrderTraversal();
    }

}
