package Design;

public class _1041_RobotBoundedInCircle {
   private static int[] N = new int[] {0, 1};
   private static int[] S = new int[] {0, -1};
   private static int[] E = new int[] {1, 0};
   private static int[] W = new int[] {-1, 0};

   private static int DIR_N = 0;
   private static int DIR_E = 1;
   private static int DIR_S = 2;
   private static int DIR_W = 3;

   public boolean isRobotBounded(String instructions) {
      int[] coor = new int[] {0, 0};
      int dir = DIR_N;
      for (char c : instructions.toCharArray()) {
         if (c == 'L' || c == 'R') {
            dir = rotate(c, dir);
         } else {
            int[] sub = new int[2];
            if (dir == DIR_N) sub = N;
            if (dir == DIR_S) sub = S;
            if (dir == DIR_E) sub = E;
            if (dir == DIR_W) sub = W;

            coor[0] += sub[0];
            coor[1] += sub[1];
         }
      }
      return (coor[0] == 0 && coor[1] == 0) || (dir != DIR_N);
   }

   private int rotate(char dir, int prevDir) {
      if (dir == 'L') {
         prevDir -= 1;
         if (prevDir < 0)
            prevDir = 3;
      } else {
         prevDir += 1;
         prevDir %= 4;
      }
      return prevDir;
   }
}
