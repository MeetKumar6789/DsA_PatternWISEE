 class Solution {
    public ListNode swapPairs(ListNode head) {
         if(head == null)
         {return head;}
         ListNode left = head;
         ListNode right = head;
         ListNode prev_left = null;
         int size = 2;
         ListNode res = null;
while(true){
      right = left;
        for(int i=0;i<size-1;i++)
        {
            if(right == null)
            {   
                right = left;
                break; //breaking cause if right is null then nothing is gonna happend;
            }
            else
            {
                right = right.next;
            }
        }
        if(right!=null)
        {
           ListNode next_left = right.next;
           left.next = right.next;
           right.next = left; 
           if(prev_left!=null)
           {
            prev_left.next = right; // as we know in this part its abt the l1.next = right2;
            
           }
        prev_left = left; // now storing the val for the next pairs

        if(res==null)
        {
            res = right;
        }
        left = next_left;
        } 
        else  //right is null
        {
           if(prev_left == null)
           {
            prev_left = left;
           }
           if(res==null)
           {
            res = left;
           }
           break;
        }
}
        return res;
    }
}