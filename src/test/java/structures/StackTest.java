package structures;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void testCreateAndPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(stack.size(), 3);
    }

    @Test
    public void testPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(stack.size(), 3);

        Assert.assertEquals((int) stack.pop(), 3);
        Assert.assertEquals((int) stack.pop(), 2);
        Assert.assertEquals((int) stack.pop(), 1);
        Assert.assertNull(stack.pop());

    }

    @Test
    public void testPeek() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(stack.size(), 3);

        Assert.assertEquals((int) stack.peek(), 3);
        Assert.assertEquals((int) stack.peek(), 3);
        Assert.assertEquals((int) stack.pop(), 3);
        Assert.assertEquals((int) stack.pop(), 2);
        Assert.assertEquals((int) stack.peek(), 1);
        Assert.assertEquals((int) stack.pop(), 1);
        Assert.assertNull(stack.peek());
    }
}
