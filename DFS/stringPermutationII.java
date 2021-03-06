import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class stringPermutationII{
    public List<String> stringPermutation2(String str){
        List<String> permutations = new ArrayList<String>();
        if(str == null) return permutations;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        boolean[] visited = new boolean[chars.length];
        StringBuilder permutation = new StringBuilder();
        dfs(chars, visited, permutation, permutations);
        return permutations;
    }

    a b b
    public void dfs(char[] chars, boolean[] visited, StringBuilder permutation, List<String> permutations){
        if(permutation.length() == chars.length){
            permutations.add(permutation.toString());
            return;
        }

        for(int i = 0 ; i< chars.length; i++){
            if(visited[i]){
                continue;
            }
            
            if(i > 0 && chars[i-1] == chars[i] && !visited[i-1]){
                continue;
            }
            
            visited[i] = true; a = true b1 = true
            permutation.append(chars[i]); permutation[a,b]

            dfs(chars, visited, permutation, permutations);

            permutation.deleteCharAt(permutation.length() -1);
            visited[i] = false; 
        }
    }
}