 class Solution {
    public ListNode swapPairs(ListNode head) {

        if(head == null)
        {
            return head;
        }
        ListNode left = head;
        ListNode res = null;
        ListNode prev_left = null;
        ListNode right = head;
        int size = 2;
        while(true){
            for(int i=0;i<size-1;i++)
            { 
                right = left;

                if(right==null)
                {
                    break;
                } 
                right = right.next;
            } //  till this part we have got the right of the pair 

            if(right!=null)
            {
                ListNode nextLeft = right.next; //  for the next left we need right.next eg : 1 -> 2 
                left.next = right.next;
                right.next = left;

                if(prev_left!=null) // linking part
                {
                    prev_left.next = right;
                }
                prev_left = left; // updation of the prevleft to left for the next linking — must run every pair, not just when prev_left already existed

                if(res == null)
                {
                    res = right;
                }
                left = nextLeft;
            }
            else //  here right is null
            {
                if(prev_left !=null)
                {
                    prev_left.next = left;
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