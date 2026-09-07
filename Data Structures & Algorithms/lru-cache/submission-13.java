class LRUCache {

    private final Map<Integer, Node> map;
    private final int capacity;

    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }

        this.map = new HashMap<>();
        this.capacity = capacity;

        this.left = new Node(0, 0);
        this.right = new Node(0, 0);

        left.next = right;
        right.prev = left;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
        }
        insert(node);

        if (map.size() > capacity) {
            Node tail = right.prev;
            map.remove(tail.key);
            remove(tail);
        }
    }

    private void insert(Node node) {
        node.next = left.next;
        node.prev = left;

        left.next.prev = node;
        left.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.next = null;
        node.prev = null;
    }

    private static class Node {
        final int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
