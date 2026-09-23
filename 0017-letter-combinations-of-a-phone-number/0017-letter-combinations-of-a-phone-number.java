class Solution {

    List<String>res = new ArrayList<>();   
    HashMap<Character , String> map = new HashMap<>();
    public void helperFun(String s , int n , int idx , StringBuilder diary )
    {  
        //stage 5
        if(idx == n)
        { 
            res.add(diary.toString());
            return;
        }

        //Getting the letters corrosponding to the idx
        String choice  = map.get(s.charAt(idx));

        //try every possible letter
        for(int i=0;i<choice.length();i++)
        {
          diary.append(choice.charAt(i));

          helperFun(s, n ,idx+1 , diary);

          //backTrackk
          diary.deleteCharAt(diary.length()-1);
        }

    }
    public List<String> letterCombinations(String digits) {
    //mapping all the phone_no's value;
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
      
      if(digits.length()==0)
      {
        return res;
      }
      StringBuilder diary = new StringBuilder();
      helperFun(digits , digits.length() , 0 , diary);
      return res;
    }
}