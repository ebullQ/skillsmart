package structures;

import java.util.*;

public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;
        Node previous = null;
        while (node != null) {
            if (node.value == _value) {
                if (head == tail) {
                    head = null;
                    tail = null;
                    return true;
                }
                if (previous == null) {
                    head = node.next;
                    return true;
                }
                previous.next = node.next;
                if (node.next == null) {
                    tail = previous;
                }
                return true;
            } else {
                previous = node;
                node = node.next;
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        boolean removed = true;
        while (removed) {
            removed = remove(_value);
        }
    }

    public void clear() {
        head = null;
        tail = null;
    }

    public int count() {
        if (this.head == null) {
            return 0;
        }
        int couner = 0;
        Node node = this.head;
        do {
            couner++;
            node = node.next;
        } while (node != null);
        return couner;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
        }
        Node node = this.head;
        while (node != null) {
            if (node == _nodeAfter) {
                _nodeToInsert.next = node.next;
                node.next = _nodeToInsert;
            }
            if (node.next == null) {
                tail = node;
            }
            node = node.next;
        }
    }

    public static LinkedList sumEqualSizeLists(LinkedList first, LinkedList second) {
        if (first.count() == 0 || second.count() == 0) {
            return new LinkedList();
        }
        if (first.count() == second.count()) {
            LinkedList linkedList = new LinkedList();
            Node firstHead = first.head;
            Node secondHead = second.head;
            while(firstHead != null) {
                linkedList.addInTail(new Node(firstHead.value + secondHead.value));
                firstHead = firstHead.next;
                secondHead = secondHead.next;
            }
            return linkedList;
        }
        return new LinkedList();
    }

    static class Node {
        public int value;
        public Node next;
        public Node(int _value)
        {
            value = _value;
            next = null;
        }
    }
}
