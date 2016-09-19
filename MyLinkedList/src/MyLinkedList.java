import java.util.Iterator;
import java.util.Scanner;

/**
 * 双链表实现
 * Created by fish-Xiang on 2016/9/18.
 */
public class MyLinkedList<AnyType> implements Iterable<AnyType> {

    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n) {
            data = d;
            prev = p;
            next = n;
        }
    }

    public MyLinkedList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    public void doClear() {
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;

    }

    public int size() {
        return theSize;
    }

    private boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    //////////////////////////////////////////////////////////////
    public void add(int idx, AnyType x) {

    }

    ///////////////////////////////////////////////
    public Node<AnyType> getNode(int idx) {
        return getNode(idx, 0, size() - 1);
    }

    private Node<AnyType> getNode(int idx, int lower, int upper) {
        Node<AnyType> p;
        if (idx < lower || idx > upper)
            throw new IndexOutOfBoundsException();
        if (idx < size() / 2) {
            p = beginMarker.next;
            for (int i = 0; i < idx; i++) {
                p = p.next;
            }
        } else {
            p = endMarker.prev;
            for (int i = size(); i > idx; i--) {
                p = p.prev;
            }
        }
        return p;
    }


    @Override
    public Iterator<AnyType> iterator() {
        return null;
    }

    public static void main(String[] args) {
        new Scanner(System.in).next()
    }
}
