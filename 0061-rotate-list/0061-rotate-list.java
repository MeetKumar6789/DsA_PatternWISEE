/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

    if(head ==null)
    {
        return head;
    }
    //first task is to find the last:
    ListNode last = head;
    int n = 1;
    while(last.next!=null)
    {
        n++;
        last = last.next; 
    }

    //now lets check that if out n==k
    k=k%n;
    if(k==0)
    {
        return head;
    }
        
    // third task is to check for the n-k  th node 
    ListNode t = head;
    int count =1; //just for checking n-k == 0
    while(count<n-k)
    {
        if(n-k==0)
        {
            break;
        }
         count++;
         t =t.next;
    }

    last.next = head; //1st make the head
    ListNode res = t.next; // n-k th 
    t.next = null; //3rd
    return res;


    }
}