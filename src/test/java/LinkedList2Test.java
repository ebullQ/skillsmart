import org.junit.Assert;
import org.junit.Test;

public class LinkedList2Test {

    @Test
    public void countTesting() {
        LinkedList2 linkedList = new LinkedList2();
        Assert.assertEquals(0, linkedList.count());

        linkedList.addInTail(new Node(10));
        Assert.assertEquals(1, linkedList.count());

        linkedList.addInTail(new Node(200));
        linkedList.addInTail(new Node(400));
        Assert.assertEquals(3, linkedList.count());
    }

    @Test
    public void removeOneTesting() {
        LinkedList2 linkedList = new LinkedList2();
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
        LinkedList2 linkedList = new LinkedList2();
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
        LinkedList2 linkedList = new LinkedList2();

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
        LinkedList2 linkedList = new LinkedList2();
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
        LinkedList2 linkedList = new LinkedList2();
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
}
