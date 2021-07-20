package BitWise;

public class _190_ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            System.out.println("i = " + i + ", ans: " + String.format("%32s", Integer.toBinaryString(ans)).replace(' ', '0'));
            System.out.println("i = " + i + ", inp: " + String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0'));
            ans <<= 1;
            ans |= (n & 1);
            n >>= 1;
            System.out.println("i = " + i + ", ans: " + String.format("%32s", Integer.toBinaryString(ans)).replace(' ', '0'));
            System.out.println();
        }
        return ans;
    }

    public static void main(String[] args) {
        _190_ReverseBits rb = new _190_ReverseBits();
        String input = "00000010100101000001111010011100";
        int bin = Integer.parseInt(input, 2);
        System.out.println(rb.reverseBits(bin));
    }
}
