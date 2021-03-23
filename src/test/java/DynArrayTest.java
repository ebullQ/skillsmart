import org.junit.Assert;
import org.junit.Test;

public class DynArrayTest {
    @Test
    public void testCreateNewArray() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        Assert.assertEquals(array.array.length, 16);
        Assert.assertEquals(array.clazz, Integer.class);
        Assert.assertEquals(array.count, 0);
        Assert.assertEquals(array.capacity, 16);
    }

    @Test(expected = RuntimeException.class)
    public void appendIndexIsOutOfBound_ThrowRuntimeException() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(1);
        array.getItem(1);
    }

    @Test
    public void appendArrayIsEmpty() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.append(5);

        Assert.assertEquals((long)array.getItem(0), 5L);
        Assert.assertEquals(array.clazz, Integer.class);
        Assert.assertEquals(array.count, 1);
        Assert.assertEquals(array.capacity, 16);
    }

    @Test(expected = RuntimeException.class)
    public void getItemIndexLessThanZero_ThrowRuntimeException() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.getItem(-5);
    }

    @Test
    public void appendBufferIsFull() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        for (int i = 0; i < 17; i++) {
            array.append(i);
        }

        Assert.assertEquals(array.clazz, Integer.class);
        Assert.assertEquals(array.count, 17);
        Assert.assertEquals(array.capacity, 32);
    }

    @Test(expected = RuntimeException.class)
    public void insertIndexLessThanZero_ThrowRuntimeException() {
        DynArray<Integer> array = new DynArray<>(Integer.class);
        array.insert(5, -5);
    }

    @Test(expected = RuntimeException.class)
    public void insertIndexIsOutOfBound_ThrowRuntimeException() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.insert(5, 5);
    }

    @Test(expected = RuntimeException.class)
    public void insertIndexIsOutOfBuffer_ThrowRuntimeException() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.insert(5, 100);
    }

    @Test
    public void insertEmptyArray() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.insert(5, 0);

        Assert.assertEquals(array.count, 1);
        Assert.assertEquals(array.capacity, 16);
        Assert.assertEquals(array.clazz, Integer.class);
        Assert.assertEquals(array.array[0], Integer.valueOf(5));
    }

    @Test
    public void insertNotEmptyArray() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(2);
        array.insert(1, 1);

        Assert.assertEquals(array.count, 2);
        Assert.assertEquals(array.capacity, 16);
        Assert.assertEquals(array.clazz, Integer.class);
        Assert.assertEquals(array.array[1], Integer.valueOf(1));
    }

    @Test
    public void insertBufferIsFull() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            array.append(i);
        }
        array.insert(111, 10);

        Assert.assertEquals(array.count, 17);
        Assert.assertEquals(array.capacity, 32);
        Assert.assertEquals(array.clazz, Integer.class);
        Assert.assertEquals(array.array[10], Integer.valueOf(111));
    }

    @Test(expected = RuntimeException.class)
    public void removeArrayIsEmpty() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.remove(0);
    }

    @Test(expected = RuntimeException.class)
    public void removeIndexIsOutOfBound() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.remove(0);
    }

    @Test
    public void removeIndexIsZero() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);
        array.append(2);
        array.remove(0);

        Assert.assertEquals(1, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(Integer.valueOf(2), array.getItem(0));
    }

    @Test
    public void removeIndexAroundTheMiddle() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        array.append(1);
        array.append(2);
        array.append(3);
        array.remove(1);

        Assert.assertEquals(2, array.count);
        Assert.assertEquals(16, array.capacity);
        Assert.assertEquals(Integer.valueOf(3), array.getItem(1));
    }

    @Test
    public void removeBufferIsMoreThanCountOverFiftyPercents() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        for (int i = 0; i < 17; i++) {
            array.append(i);
        }
        array.remove(4);
        array.remove(3);

        Assert.assertEquals(15, array.count);
        Assert.assertEquals(21, array.capacity);
        Assert.assertEquals(Integer.valueOf(6), array.getItem(4));
    }

    @Test
    public void removeIndexIsEndOfArray() {
        DynArray<Integer> array = new DynArray<>(Integer.class);

        for (int i = 0; i < 16; i++) {
            array.append(i);
        }
        array.remove(15);

        Assert.assertEquals(15, array.count);
        Assert.assertEquals(16, array.capacity);
    }
}
