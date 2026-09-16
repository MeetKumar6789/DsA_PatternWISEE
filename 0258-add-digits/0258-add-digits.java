class Solution {
    public int sum(int num )
    {  
        int sum =0;
        if(num >0){
       int n1 = num % 10;//got the last num
       int n2 = num / 10;//got the first num
        sum = n1 + n2;
        }
        return sum;
    }
    public int addDigits(int num) {
        if(num<=9)
        {
            return num;
        }
        

       return addDigits(sum(num));
        
    }
}