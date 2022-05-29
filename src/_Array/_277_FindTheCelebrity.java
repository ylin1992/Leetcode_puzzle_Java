package _Array;

public class _277_FindTheCelebrity implements Relation{
   @Override
   public boolean knows(int a, int b) {
      // stub code
      return true;
   }

   public int findCelebrity(int n) {
      int res = 0;
      for (int i = 1; i < n; i++) {
         // if res knows i, than i could possibly be the celebrity
         // so we update res to i
         if (knows(res, i)) {
            res = i;
         }
      }

      // still need to check weather res knows nobody
      for (int i = 0; i < n; i++) {
         if (res != i && (knows(res, i) || !knows(i, res))) return -1;
      }
      return res;
   }

}

interface Relation {
   public boolean knows(int a, int b);
}
