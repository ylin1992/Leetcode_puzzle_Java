package _Math;

public class _258_AddDigits {
   public int addDigitsBruteForce(int num) {
      if (num < 10) return num;
      int res = 0;
      while (num > 0) {
         res += num % 10;
         num /= 10;
      }
      return addDigitsBruteForce(res);
   }
}
