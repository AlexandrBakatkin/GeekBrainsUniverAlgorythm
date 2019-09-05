import LinkedList.SimpleLinkedList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        SimpleLinkedList <String> linkedList = new SimpleLinkedList();
        linkedList.insertFirst("123");
        linkedList.insertFirst("456");
        linkedList.insertFirst("789");

        for (String str: linkedList) {
            System.out.println(str);
        }

        ArrayList arrayList = new ArrayList();
       /* System.out.println(linkedList.toString());

        TwoSideLinkedListImpl twoSideLinkedList = new TwoSideLinkedListImpl();
        twoSideLinkedList.insertFirst(1);
        twoSideLinkedList.insertFirst(2);
        twoSideLinkedList.insertFirst(3);
        System.out.println(twoSideLinkedList);
        twoSideLinkedList.removeFirst();
        System.out.println(twoSideLinkedList);*/
    }
}