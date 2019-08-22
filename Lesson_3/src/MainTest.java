import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import queue.QueueImpl;
import stack.StackImpl;
import Dequeue.DequeueImpl;

public class MainTest {
    @Test
    void checkStack(){
        StackImpl stack = new StackImpl(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Assertions.assertEquals(5, stack.size());
        stack.pop();
        Assertions.assertEquals(4, stack.pop());
        Assertions.assertEquals(3, stack.size());
    }

    @Test
    void checkQueue(){
        QueueImpl queue = new QueueImpl(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);

        Assertions.assertEquals("[12345]", queue.toString());
    }

    @Test
    void checkDequeue(){
        DequeueImpl dequeue = new DequeueImpl(5);
        dequeue.insertRight(1);
        dequeue.insertRight(2);
        dequeue.insertRight(3);
        dequeue.insertLeft(4);
        dequeue.insertLeft(5);

        Assertions.assertEquals("[32145]", dequeue.toString());
    }
}
