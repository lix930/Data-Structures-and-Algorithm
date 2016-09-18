/**
 * 单链表的实现
 * 参考  http://blog.csdn.net/a19881029/article/details/22695289
 *
 * Created by fish-xiang on 16-9-18.
 */
public class LinkedList {

    private class Data {
        private Object obj;
        private Data next = null;

        Data(Object obj) {
            this.obj = obj;
        }
    }


    private Data first = null;

    public void insertFirst(Object obj) {
        Data data = new Data(obj);
        data.next = first;
        first = data;
    }

    public Object deleteFirst() throws Exception {
        if (first == null)
            throw new Exception("empty!");
        Data temp = first;
        first = first.next;
        return temp.obj;
    }

    public Object find(Object obj) throws Exception {
        if (first == null)
            throw new Exception("empty!");
        Data cur = first;
        while(cur != null){
            if(cur.obj.equals(obj))
                return cur.obj;
            cur = cur.next;
        }
        return null;
    }

    public void remove(Object obj) throws Exception {
        if (first == null)
            throw new Exception("empty!");
        if (first.obj.equals(obj)) {
            first = first.next;
        }else {
            Data pre = first;
            Data cur = first.next;
            while(cur != null){
                if(cur.obj.equals(obj)){
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }


    public boolean isEmpty() {
        return first == null;
    }

    public void display() {
        if(first == null)
            System.out.println("empty");
        Data cur = first;
        while(cur != null) {
            System.out.print(cur.obj.toString() + " -> ");
            cur = cur.next;
        }
        System.out.println();
    }


    public static void main(String[] args) throws Exception{
        LinkedList ll = new LinkedList();
        ll.insertFirst(4);
        ll.insertFirst(3);
        ll.insertFirst("string");
        ll.insertFirst(1.5);
        ll.display();
        ll.deleteFirst();
        ll.display();
        ll.remove(3);
        ll.display();
        System.out.println(ll.find("string"));
        System.out.println(ll.find(4));

    }

}
