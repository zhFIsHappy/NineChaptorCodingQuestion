import javax.lang.model.element.QualifiedNameable;

public class wordLadder {
    public int ladderLength(String start, String end, Set<String> dict){
        dict.add(end);
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new ArrayDeque<String>();
        queue.offer(start);
        queue.offer(start);
        int length = 1; //because we add end in the dict first, so at least 1
        while(!queue.isEmpty()) {
            length ++;
            int size = queue.size();
            for(int i = 0; i< size; i++){
                String word = queue.poll();
                for(String nextWord : nextWords(word,dict)){
                    if(visited.contains(nextWord)){
                        continue;
                    }
                    if(nextWord.equals(end)){
                        return length;
                    }
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
                
            }
        }
        return 0;
    }

    private ArrayList<String> nextWords(String word, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<String>();
        boolean hasOneDiff = false;
        for(String nextWord : dict){
            boolean hasOneDiff = false;
            for(int i = 0; i < word.length(); i++){     // 如果已经有一个letter 不一样了 就set 成 false 并且break
                if(nextWord.charAt(i) != word.charAt(i)){
                    if(hasOneDiff){
                        hasOneDiff = false;
                        break;
                    }
                    hasOneDiff = true;
                }
            }
            if(hasOneDiff){
                nextWords.add(nextWord);
            }
        }
        return nextWords;
    }
}
