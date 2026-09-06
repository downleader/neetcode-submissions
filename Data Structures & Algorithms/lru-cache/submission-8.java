class LRUCache {

    private final Map<Integer, Node> map;
    private final int capacity;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be posivite.");
        }
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        if (node != head) {
            moveToHead(node);
        }

        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);

            if (head == null) {
                tail = node;
            } else {
                node.next = head;
                head.prev = node;
            }
            head = node;

            if (map.size() > capacity) {
                System.out.println("Map size: " + map.size() + ", capacity: " + capacity);
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }
        } else {
            Node node = map.get(key);
            node.val = value;
            if (node != head) {
                moveToHead(node);
            }
        }
    }

    private void moveToHead(Node node) {
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
        }
        head = node;
    }

    private static class Node {
        final int key;
        int val;

        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
