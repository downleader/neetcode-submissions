class Solution {

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node node = head;
        while (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new Node(node.val));
            }

            if (node.next != null && !map.containsKey(node.next)) {
                map.put(node.next, new Node(node.next.val));
            }

            if (node.random != null && !map.containsKey(node.random)) {
                map.put(node.random, new Node(node.random.val));
            }

            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);

            node = node.next;
        }

        return map.get(head);
    }
}
