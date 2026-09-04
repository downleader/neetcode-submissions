class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node node = head;
        while (node != null) {
            if (!map.containsKey(node)) {
                map.put(node, new Node(node.val));
            }
            node = node.next;
        }

        node = head;
        while (node != null) {
            Node newNode = map.get(node);
            newNode.next = map.get(node.next);
            newNode.random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
