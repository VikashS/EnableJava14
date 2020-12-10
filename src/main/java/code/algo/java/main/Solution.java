package code.algo.java.main;



public class Solution {
    public static void main(String[] args) {
        System.out.println("started");
        String str="abbaca";
        //removeDuplicate(str);
        System.out.println(removeDuplicate(str));
        System.out.println("End");
    }

    private static String removeDuplicate(String str) {
        char[] stack=str.toCharArray();
        int i = 0;
        for(int j=0;j<str.length();j++){
            char curent_char=str.charAt(j);
            if(i>0 && stack[i-1]==curent_char){
                i--;
            }else{
                stack[i]=curent_char;
                i+=1;
            }
        }
        return new String(stack,0,i);
    }


}