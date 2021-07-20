package BitWise;

public class _191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
            System.out.println(Integer.toBinaryString(-2));
        }
        return count;
    }

    public static void main(String[] args) {
        _191_NumberOf1Bits nob = new _191_NumberOf1Bits();
        String input = "111111111111111111111111111101";
        int bin = Integer.parseInt(input, 2);
        System.out.println(nob.hammingWeight(bin));
    }
}
