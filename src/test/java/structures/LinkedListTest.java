package structures;

import org.junit.Assert;
import org.junit.Test;
public class LinkedListTest {

    @Test
    public void countTesting() {
        LinkedList linkedList = new LinkedList();
        Assert.assertEquals(0, linkedList.count());

        linkedList.addInTail(new Node(10));
        Assert.assertEquals(1, linkedList.count());

        linkedList.addInTail(new Node(200));
        linkedList.addInTail(new Node(400));
        Assert.assertEquals(3, linkedList.count());
    }

    @Test
    public void removeOneTesting() {
        LinkedList linkedList = new LinkedList();
        Assert.assertFalse(linkedList.remove(10));

        linkedList.addInTail(new Node(10));
        linkedList.addInTail(new Node(50));
        linkedList.addInTail(new Node(200));

        Assert.assertTrue(linkedList.remove(10));
        Assert.assertFalse(linkedList.remove(20));
        Assert.assertTrue(linkedList.remove(200));
        Assert.assertEquals(1, linkedList.count());
        Assert.assertEquals(50, linkedList.head.value);
        Assert.assertEquals(50, linkedList.tail.value);

        Assert.assertTrue(linkedList.remove(50));
        Assert.assertEquals(0, linkedList.count());
        Assert.assertNull(linkedList.head);
        Assert.assertNull(linkedList.tail);
    }

    @Test
    public void removeAllTesting() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new Node(10));
        linkedList.addInTail(new Node(200));
        linkedList.addInTail(new Node(10));
        linkedList.addInTail(new Node(50));
        linkedList.addInTail(new Node(10));

        Assert.assertEquals(5, linkedList.count());
        linkedList.removeAll(10);
        Assert.assertEquals(2, linkedList.count());
        Assert.assertEquals(200, linkedList.head.value);
        Assert.assertEquals(50, linkedList.tail.value);

        linkedList.removeAll(50);
        Assert.assertEquals(1, linkedList.count());
        Assert.assertEquals(200, linkedList.head.value);
        Assert.assertEquals(200, linkedList.tail.value);

        linkedList.addInTail(new Node(200));
        linkedList.removeAll(200);
        Assert.assertEquals(0, linkedList.count());
        Assert.assertNull(linkedList.head);
        Assert.assertNull(linkedList.tail);
    }

    @Test
    public void clearTesting() {
        LinkedList linkedList = new LinkedList();

        linkedList.addInTail(new Node(10));
        linkedList.addInTail(new Node(50));
        Assert.assertEquals(2, linkedList.count());

        linkedList.clear();
        Assert.assertEquals(0, linkedList.count());
        Assert.assertNull(linkedList.head);
        Assert.assertNull(linkedList.tail);
    }

    @Test
    public void findAllTesting() {
        LinkedList linkedList = new LinkedList();
        Assert.assertEquals(0, linkedList.findAll(10).size());

        linkedList.addInTail(new Node(10));
        linkedList.addInTail(new Node(50));
        linkedList.addInTail(new Node(80));
        linkedList.addInTail(new Node(110));
        linkedList.addInTail(new Node(10));
        Assert.assertEquals(1, linkedList.findAll(50).size());
        Assert.assertEquals(2, linkedList.findAll(10).size());
        Assert.assertEquals(0, linkedList.findAll(5000).size());
    }

    @Test
    public void insertAfterTesting() {
        Node node1 = new Node(10);
        Node node2 = new Node(20);
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(node1);
        linkedList.addInTail(node2);

        Assert.assertEquals(2, linkedList.count());
        linkedList.insertAfter(node1, new Node(50));
        Assert.assertEquals(3, linkedList.count());
        Assert.assertEquals(50, linkedList.head.next.value);

        linkedList.insertAfter(null, new Node(30));
        Assert.assertEquals(4, linkedList.count());
        Assert.assertEquals(30, linkedList.head.value);

        Assert.assertEquals(20, linkedList.tail.value);
        linkedList.insertAfter(node2, new Node(70));
        Assert.assertEquals(5, linkedList.count());
        Assert.assertEquals(70, linkedList.tail.value);
    }

    @Test
    public void sumEqualSizeListsTesting() {
        LinkedList first = new LinkedList();
        LinkedList second = new LinkedList();
        LinkedList linkedList1 = LinkedList.sumEqualSizeLists(first, second);
        Assert.assertEquals(0, linkedList1.count());

        first.addInTail(new Node(12));
        second.addInTail(new Node(30));

        LinkedList linkedList2 = LinkedList.sumEqualSizeLists(first, second);
        Assert.assertEquals(1, linkedList2.count());
        Assert.assertEquals(42, linkedList2.head.value);

        first.addInTail(new Node(50));
        first.addInTail(new Node(200));
        second.addInTail(new Node(100));
        second.addInTail(new Node(500));
        LinkedList linkedList3 = LinkedList.sumEqualSizeLists(first, second);
        Assert.assertEquals(3, linkedList3.count());
        Assert.assertEquals(42, linkedList3.head.value);
        Assert.assertEquals(700, linkedList3.tail.value);

        LinkedList linkedList4 = LinkedList.sumEqualSizeLists(linkedList2, linkedList3);
        Assert.assertEquals(0, linkedList4.count());
    }

}
