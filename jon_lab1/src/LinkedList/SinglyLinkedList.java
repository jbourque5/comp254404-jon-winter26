package LinkedList;

public class SinglyLinkedList<E> {

    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {}

    public boolean isEmpty() { return size == 0; }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.setNext(newest);
        tail= newest;
        size++;
    }

    public Node<E> getHead() { return head; }

    public String toString() {
        StringbBuilder sb = new StringBuilder("[");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            walk = walk.getNext();
            if (walk != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
