package main;

// 172
public class LC002TrailingZeros {
    /*
    * @param n: An integer
    * @return: An integer, denote the number of trailing zeros in n!
    */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        int result = 0;

        while (n != 0) {
            n = n / 5;
            result += n;
        }

        return result;
    }
}
