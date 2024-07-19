package rudy.dsa.Graphs.Distance;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

class NodeInfo{
    String word;
    int level;

    NodeInfo( String word, int level){
        this.word= word;
        this.level= level;
    }
}

public class WordLadder1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<NodeInfo> queue= new LinkedList<>();
        Set<String>wordSet = new HashSet<>(wordList);

        queue.add(new NodeInfo(beginWord,1));
        wordSet.remove(beginWord);
        while (!queue.isEmpty()){
            NodeInfo front = queue.poll();
            String word = front.word;
            int level = front.level;
            if(word.equals(endWord)) {
                return level;
            }
            //hit

            for(int i=0;i<word.length();i++){

                for(char ch = 'a'; ch<='z' ; ch++){
                    char[] charArray = word.toCharArray();
                    charArray[i] = ch;
                    String transformedWord = new String(charArray);
                    if(wordSet.contains(transformedWord)){
                        wordSet.remove(transformedWord);
                        queue.add(new NodeInfo(transformedWord, level+1));
                    }
                }

            }


        }

        return 0;

    }

    public static void main(String[] args) {
        WordLadder1 obj = new WordLadder1();
        int ladderLength = obj.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength);
    }
}
