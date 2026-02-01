package LinkedList;
import LinkedList.DoublyLinkedList;


public class Concatenate {
    public static void main(String[] args){

        DoublyLinkedList<Integer> L = new DoublyLinkedList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);

        DoublyLinkedList<Integer> M = new DoublyLinkedList<>();
        M.addLast(4);
        M.addLast(5);

        System.out.println("L before: " + L);
        System.out.println("M before: " + M);

        L.concatenate(M);

        System.out.println("L after: " + L);
        System.out.println("M after: " + M);

    }
}
