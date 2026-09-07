class LRUCache {

    private final Map<Integer, Node> map;
    private final int capacity;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
        } else {
            node = new Node(key, value);
            map.put(key, node);
        }
        moveToHead(node);

        if (map.size() > capacity) {
            map.remove(tail.key);
            Node prev = tail.prev;
            prev.next = null;
            tail = prev;
        }
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }

        Node prev = node.prev;
        Node next = node.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }

        if (node == tail) {
            tail = prev;
        }

        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        } else {
            tail = node;
        }

        head = node;
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
