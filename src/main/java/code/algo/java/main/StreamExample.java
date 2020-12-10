package code.algo.java.main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        for(int i=0; i<100; i++) myList.add(i);
        System.out.println(myList);

        //sequential stream
        Stream<Integer> sequentialStream = myList.stream();

        //parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();
        Stream<Integer> str=parallelStream.filter(p->p>90);
        str.forEach(p-> System.out.println("High Nums parallel="+p));
    }
}
