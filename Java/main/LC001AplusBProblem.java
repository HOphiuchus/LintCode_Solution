package main;

public class LC001AplusBProblem {

    /*
     * @param : An integer
     * @param : An integer
     * @return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        // write your code here
        while (b != 0) {
            int _a = a ^ b;
            b = a & b << 1;
            a = _a;
        }
        return a;
    }

}
