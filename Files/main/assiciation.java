package Files.main;

public class assiciation<K, V> {
    private K identifier;
    private V element;

    public assiciation(K identifier, V element) {
        this.identifier = identifier;
        this.element = element;
    }

    public K getIdentifier() {
        return identifier;
    }

    public V getElement() {
        return element;
    }
}
