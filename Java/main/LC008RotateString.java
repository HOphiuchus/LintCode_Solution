package main;


public class LC008RotateString {
    /*
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        int index = str.length - offset;
        char[] strBackup = new char[offset];
        System.arraycopy(str, index, strBackup, 0, offset);

        for (int i = index - 1; i >= 0; i--) {
            str[i + offset] = str[i];
        }

        System.arraycopy(strBackup, 0, str, 0, offset);
    }

    public void rotateString2(char[] str, int offset) {
        int size = str.length;
        int current = 0;
        int stub = 0;
        if (size == 0 || str == null) {
            return;
        }

        offset = offset % size;

        if (offset == 0) {
            return;
        } else {
            for (int i = 1; i < size; i++) {
                int next = (offset + current) % size;
                if (next == stub) {
                    stub++;
                    current = stub;
                    continue;
                }
                char temp = str[next];
                str[next] = str[stub];
                str[stub] = temp;
                current = next;

            }
        }
    }
}

