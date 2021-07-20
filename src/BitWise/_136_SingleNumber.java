package BitwiseOperation;

public class _136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        _136_SingleNumber sn = new _136_SingleNumber();
        System.out.println(sn.singleNumber(new int[]{1, 2, 2, 3, 3}));
        System.out.println(sn.singleNumber(new int[]{2, 1, 2, 1, 3}));
        System.out.println(sn.singleNumber(new int[]{1, 1, 2, 3, 3}));
        System.out.println(sn.singleNumber(new int[]{1}));
    }
}
