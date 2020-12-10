package code.algo.java.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Segments {
    public static void main(String[] args) {
        Segments sg=new Segments();
        int arr[]={8,2,4,7,1};
        int k=2;
        sg.segment(k,arr);
    }

    private static void segment(int k, int[] arr)
    {
        List<Integer>[] l1=new List[arr.length-k+1];
        List<Integer> lmin =new ArrayList<>(l1.length);
        int upcount=0;

            int currentPointer=0;
            int outerCount=arr.length-k+1;
            for(int i=currentPointer;currentPointer<outerCount;i++)
            {
                List<Integer> l2 =new ArrayList<>(k);
                l2.removeAll(l2);
                int innerCount=0;
                for(int j=i;innerCount<k;j++) {
                    innerCount++;
                    l2.add(arr[j]);
                }
                currentPointer++;
                l1[upcount]=l2;
                upcount++;
            }
        print(l1);
        System.out.println("Main data");

        // get minimum from l1
        for(int i=0;i<l1.length;i++)
        {
            Collections.sort(l1[i]);
            lmin.add( l1[i].get(0));
        }
        print(l1);
        Collections.sort(lmin);
        System.out.println(lmin.get(lmin.size()-1));
    }

    private static void print(List<Integer>[] l1) {
        for(int i=0;i<l1.length;i++)
        {
            List<Integer> list=l1[i];
            System.out.println(list);
        }
    }



}
