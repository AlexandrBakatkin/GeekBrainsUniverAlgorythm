import Dequeue.DequeueImpl;
import queue.QueueImpl;
import stack.StackImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StackImpl stack = new StackImpl(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.clear();
        System.out.println(stack);

        ReverseString reverseString = new ReverseString("Hello");
        System.out.println(reverseString.reverse());

        QueueImpl <Integer> queue = new QueueImpl<>(5);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        queue.insert(8);
        System.out.println("___");
        System.out.println(queue);

        /*DequeueImpl dequeue = new DequeueImpl(5);

        dequeue.insertLeft(1);
        dequeue.insertLeft(2);
        dequeue.insertLeft(3);
        dequeue.insertRight(4);
        dequeue.insertRight(5);
        dequeue.print();
        System.out.println("____");

        System.out.println(dequeue.removeLeft());
        System.out.println(dequeue.removeLeft());
        System.out.println(dequeue.removeLeft());
        System.out.println(dequeue.removeRight());
        System.out.println(dequeue.removeRight());*/

    }
}