import java.util.*;

public class WordLadder {
    /**
     * BFS
     */
    public static void main(String[] args){
        String[] words = {"hot", "dot", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(ladderLength_neighbor("hit", "cog", wordList));
    }
    public static int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList){
        if(wordList == null || !wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.add(endWord);
        dict.remove(beginWord);
        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                String str = queue.poll();
                if(str.equals(endWord)) return level;
                for(String neighbor : neighbors(str, wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    public static List<String> neighbors(String str, List<String> wordList){
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for(int i=0; i < str.length(); i++){
            char[] chars = str.toCharArray();
            for(char ch='a'; ch <='z'; ch++){
                chars[i] = ch; // ait ~ zit
                String word = new String(chars);
                if(dict.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }
}
