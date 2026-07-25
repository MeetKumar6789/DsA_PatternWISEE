class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
        {
            return null;
        }
        ListNode left = head;
        ListNode right = null;
        ListNode prev_left = null;
        ListNode res = null;
        int size = k;

        while(true){
            right = left;
            for(int i=0;i<k-1;i++)
            {
                if(right == null)
                {
                    break;
                }
                else
                {
                    right = right.next;
                }
            }

            if(right != null)
            {
                ListNode next_left = right.next; //storing the value fo the right.next first

                if(prev_left != null)
                {
                    prev_left.next = right; // l1.next = right2, same as before
                }
                if(res == null)
                {
                    res = right;
                }

                prev_left = left; // save this group's start — it becomes the tail after reversing

                // reverse this group by walking left -> next_left,
                right = next_left;
                while(left != next_left)
                {
                    ListNode temp = left.next;
                    left.next = right;
                    right = left;
                    left = temp;
                } 
            }
            else  
            {
                if(prev_left == null)
                {
                    prev_left = left; //  1st node case
                }
                if(res == null)
                {
                    res = left;
                }
                break;
            }
        }
        return res;
    }
}