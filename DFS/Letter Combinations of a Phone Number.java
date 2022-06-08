import java.util.ArrayList;
import java.util.List;

class Solution {
    public static final String[] KEYWORDS = {
        "",
        "",
        "adc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations (String digits){
        List<String> combinations = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return combinations;
        }
        // 0 代表dfs的起点为digits的下标0 位置
        //[] 表示combination 的初始值为空list
        dfs(digits, "", 0, combinations);
        return combinations;
    }
    // digits 表示要输入的数字
    // index 表示当前dfs要处理digits[index] 所代表的数字
    // combination 表示到目前位置所得到的组合
    // combinations 表示到目前为止找到的所有完整组合
    
    private void dfs(String digits, String combination, int index, List<String> combinations){
        if(index == digits.length()){
            combinations.add(combination);
            return ;
        }
        int digit = digits.charAt(index) - '0';

        for(int i = 0; i < KEYWORDS[digit].length(); i++){
            dfs(digits,index + 1, combination+KEYWORDS[digit].charAt(i), combinations);
        }
    }
}