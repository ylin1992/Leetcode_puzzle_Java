package String;

public class _168_ExcelColunTitle {
    public String convertToTitle(int columnNumber) {
        String ans = "";
        while (columnNumber > 0) {
            int rem = columnNumber % 26 == 0 ? 26 : columnNumber % 26;
            columnNumber = rem == 26 ? columnNumber - 1 : columnNumber;
            ans = String.valueOf((char) ('A' + rem - 1)) + ans;
            columnNumber /= 26;
        }
        return ans;
    }

    public static void main(String[] args) {
        _168_ExcelColunTitle ect = new _168_ExcelColunTitle();
        System.out.println(ect.convertToTitle(701));
    }
}
