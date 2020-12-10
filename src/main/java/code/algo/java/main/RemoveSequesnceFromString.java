package code.algo.java.main;

import java.util.Arrays;

public class RemoveSequesnceFromString {
    public static void main(String[] args) {
        System.out.println("started");
        String str="aaabbcc";
        removeDuplicate(str);
        System.out.println("End");
    }

    private static void removeDuplicate(String str) {
        char[] ch=str.toCharArray();
        if (ch.length < 2) {
            return;
        }
        int j = 0;
        for (int i = 1; i < ch.length; i++) {
            System.out.println("just checking start");
            System.out.println(i);
            System.out.println(j);
            System.out.println(ch[i]);
            System.out.println("just checking end");
            if (ch[j] != ch[i])
            {
                System.out.println("inside if");
                System.out.println("just checking 1");
                System.out.println(ch[j]);
                System.out.println(ch[i]);
                System.out.println("just checking 2");
                j++;
                ch[j]=ch[i];

            }

        }
        System.out.println(Arrays.copyOfRange(ch, 0, j + 1));
    }
}
