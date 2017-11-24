package main;

public class LC003DigitCounts {
    /*
         * @param : An integer
         * @param : An integer
         * @return: An integer denote the count of digit k in 1..n
         */
    public int digitCounts(int k, int n) {
        int counts = 0;
        // write your code here
        for (int i = 0; i <= n; i++) {
            counts += digitCount(k, i);
        }
        return counts;
    }

    private int digitCount(int k, int i) {
        if (i == 0 && k == 0) {
            return 1;
        }
        int count = 0;
        while (i != 0) {
            int reminder = i % 10;
            if (reminder == k) {
                count++;
            }
            i /= 10;
        }
        return count;
    }

    public int digitCounts2(int k, int n) {
        int temp = n;
        int counts = 0;
        int reminder;
        int pow = 1;
        while (temp > 0) {
            reminder = temp % 10;
            temp = temp / 10;
            if (k == 0 && temp == 0) {
                break;
            }

            counts += temp * pow;

            if (reminder > k) {
                counts += pow;
            }
            if (reminder == k) {
                counts += n - temp * pow * 10 + 1;
            }

            pow *= 10;
        }
        return counts;
    }
}