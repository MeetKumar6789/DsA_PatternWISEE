 class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        int i = s.length() - 1;
       
        //skip the khali jagah
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        //now count++ and then iterate the pointer throughout the word 
        while (i >= 0 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        
        return count;
    }
}
