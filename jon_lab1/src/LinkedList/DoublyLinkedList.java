package LinkedList;

public class DoublyLinkedList<E> {
     private static class Node<E> {
         private E element;
         private Node<E> prev;
         private Node<E> next;

         public Node(E e, Node<E> p, Node<E> n) {
             element = e;
             prev = p;
             next = n;
         }

         public E getElement() { return element; }
         public Node<E> getPrev() { return prev; }
         public Node<E> getNext() { return next; }
         public void setPrev(Node<E> p) { prev = p; }
         public void setNext(Node<E> n) { next = n; }
     }

     private Node<E> header;
     private Node<E> trailer;
     private int size = 0;

     public DoublyLinkedList() {
         header = new Node<>(null, null, null);
         trailer = new Node<>(null, header, null);
         header.setNext(trailer);
     }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public E first() {
         if (isEmpty()) return null;
         return header.getNext().getElement();
     }

    public E last() {
         if (isEmpty()) return null;
         return trailer.getPrev().getElement();
     }


    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
         Node<E> newest = new Node<>(e, predecessor, successor);
         predecessor.setNext(newest);
         successor.setPrev(newest);
         size++;
     }


    public void addFirst(E e) {
         addBetween(e, header, header.getNext());
     }

    public void addLast(E e) {
         addBetween(e, trailer.getPrev(), trailer);
     }


    private E remove(Node<E> node) {
         Node<E> predecessor = node.getPrev();
         Node<E> successor = node.getNext();
         predecessor.setNext(successor);
         successor.setPrev(predecessor);
         size--;
         return node.getElement();
     }



    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
     }


    public E removeLast() {
         if (isEmpty()) return null;
         return remove(trailer.getPrev());
     }


    @Override
    public String toString() {
         StringBuilder sb = new StringBuilder("[");
         Node<E> walk = header.getNext();
         while (walk != trailer) {
             sb.append(walk.getElement());
             walk = walk.getNext();
             if (walk != trailer) sb.append(", ");
         }

         sb.append("]");
         return sb.toString();
     }


    public void concatenate(DoublyLinkedList<E> other){

         if (other.isEmpty()){
             return;
         }

         if (this.isEmpty()) {
             this.header.setNext(other.header.getNext());
             other.header.getNext().setPrev(this.header);

             this.trailer.setPrev(other.trailer.getPrev());
             other.trailer.getPrev().setNext(this.trailer);

             this.size = other.size;
         }
         else {
             Node<E> lastOfThis = this.trailer.getPrev();
             Node<E> firstOfOther = other.header.getNext();

             lastOfThis.setNext(firstOfOther);
             firstOfOther.setPrev(lastOfThis);

             this.trailer.setPrev(other.trailer.getPrev());
             other.trailer.getPrev().setNext(this.trailer);

             this.size += other.size;

         }

         other.header.setNext(other.trailer);
         other.trailer.setPrev(other.header);
         other.size = 0;

    }





}

