package algorithm.nowcoder_algorithm;

public class test3_5 {
    public static boolean chkRotation(String A, int lena, String B, int lenb) {
        String str = A + A;
        int ans = kmp(str, B);
        if(ans != -1) {
            return true;
        } else {
            return false;
        }
    }

    public static void calNext(String pattern, int[] next) {
        int len = pattern.length();
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < len - 1) {
            if(k == -1 || pattern.charAt(k) == pattern.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    //使用kmp算法对两个字符串进行匹配，如果匹配成功，返回在str中字符串的起始位置。
    //失败返回-1
    public static int kmp(String str, String pattern) {
        int i = 0;
        int j = 0;
        int sLen = str.length();
        int pLen = pattern.length();

        int[] next = new int[pattern.length()];
        calNext(pattern, next);

        while(i < sLen && j < pLen) {
            if(str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if(next[j] == -1) {
                    i++;
                    j = 0;
                } else {
                    j = next[j];
                }
            }
            if(j == pLen) {
                return i - j;
            }
        }
        return -1;
    }
}
