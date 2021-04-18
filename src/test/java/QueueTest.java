import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void enqueueTest()
    {
        Queue<Integer> queue = new Queue<>();
        Assert.assertEquals(queue.size(), 0);

        queue.enqueue(1);
        Assert.assertEquals(queue.size(), 1);

        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(queue.size(), 3);
    }

    @Test
    public void dequeueTest()
    {
        Queue<Integer> queue = new Queue<>();
        Assert.assertNull(queue.dequeue());

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertEquals(queue.size(), 3);

        Assert.assertEquals((int) queue.dequeue(), 1);
        Assert.assertEquals((int) queue.dequeue(), 2);
        Assert.assertEquals((int) queue.dequeue(), 3);
        Assert.assertNull(queue.dequeue());

    }

}
