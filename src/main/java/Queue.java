import java.util.*;

public class Queue<T>
{
    private final Stack<T> firstStack;
    private final Stack<T> secondStack;
    private int size;

    public Queue() {
        this.secondStack = new Stack<>();
        this.firstStack = new Stack<>();
        this.size = 0;
    }

    public void enqueue(T item) {
        this.firstStack.push(item);
        size++;
    }

    public T dequeue() {
        if(size == 0)
            return null;
        if(secondStack.empty()) {
            while(!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }
        }
        size--;
        return secondStack.pop();
    }

    public int size() {
        return size;
    }

}