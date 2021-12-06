package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @program: thread-demo
 * @description:
 * @author: XTZ
 * @create: 2021-12-05 15:26
 **/
public class CollectionDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList<String>();
        collection.add("aaa");
        collection.add("bbb");
        collection.add("ccc");
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }
    }
}
