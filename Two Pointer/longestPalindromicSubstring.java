
// General Ideal is: if we have example babad, loop through. Expand two pointers from each character: exmaple if we are here(case1) babad at index 1: a, then we expand to the left and right
                                                                                                                     //       | 
                                                                                                                        


class Solution {
    public String longestPalindrome(String s) {
        // write your code here
        int start = 0;
        int end = 0;
        int curMax = end - start;
        if(s== null || s.length()<1) return "";
        for(int i = 0; i< s.length(); i++){
            int len1 = expandFromMiddle(s,i,i); // case 1, which we have odd number of palindrome
            int len2 = expandFromMiddle(s,i,i+1); // case 2, which we have even number of palindrome
            int len = Math.max(len1,len2);        // get the maximum length of len1 and len2

            if(len >curMax){
                start = i -((len-1)/2); // update start and end to the index of the longest palindrome (tricky) 这个地方的代码我感觉是推出来的 
                end = i +(len/2);
                curMax = end - start;   
            }
        }
        return s.substring(start,end+1);
    }
    
    public int expandFromMiddle(String s, int left, int right) {
        if(s == null || left > right) return 0;
        while(left>=0 && right <s.length()&&s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return right - left -1; // if we have  an example like this:  cabbad, after we on the 'a' then we expand again, we found two chars doesn't equal, because index start with 0, then we -1 but not 2 
    }
}


