import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Main {



    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l11 = l1;
        l1.next = new ListNode(2);
        l1= l1.next;
        l1.next = new ListNode(4);
        l1= l1.next;
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l22=l2;
        l22.next = new ListNode(6);
        l22= l22.next;
        l22.next = new ListNode(4);
        Main main = new Main();
        ListNode node = main.addTwoNumbers(l11, l2);
        while(node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }

    public ListNode reverseList(ListNode node){
        ListNode pre=null;
        while(node!=null){
            ListNode temp = node.next;
            node.next = pre;
            pre = node;
            node=temp;
        }
        return  pre;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }

        ListNode head=null;
        ListNode pre = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            ListNode node1 = s1.isEmpty() ? null : s1.pop();
            ListNode node2 = s2.isEmpty() ? null : s2.pop();
            int a = node1 == null ? 0 : node1.val;
            int b = node2 == null ? 0 : node2.val;
            int n = a+b+carry;
            carry = n/10;
            n=n%10;
            ListNode node = new ListNode(n);
            node.next = pre;
            pre = node;

        }
        if(carry>0){
            ListNode node = new ListNode(1);
            node.next = pre;
            pre = node;
        }
        return pre;
    }


}
