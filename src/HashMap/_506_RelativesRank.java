package HashMap;

import java.util.PriorityQueue;

public class _506_RelativesRank {
    class Pair{
        int score;
        int index;
        Pair(int s, int i){
            score = s;
            index = i;
        }
    }
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> (a.score - b.score));
        for (int i = 0; i < score.length; i++) {
            pq.offer(new Pair(score[i], i));
        }
        String[] res = new String[score.length];
        int medal = 1;
        while (!pq.isEmpty()) {
            int index = pq.poll().index;
            String medalName = "";
            if (medal == 1) {
                medalName = "Gold Medal";
            } else if (medal == 2) {
                medalName = "Silver Medal";
            } else if (medal == 3) {
                medalName = "Bronze Medal";
            }  else {
                medalName = String.valueOf(medal);
            }
            res[index] = medalName;
            medal++;
        }
        return res;
    }

    public static void main(String[] args) {
        _506_RelativesRank rr = new _506_RelativesRank();
        int[] in = new int[]{5,4,3,2,1};
        String[] res = rr.findRelativeRanks(in);
    }
}
