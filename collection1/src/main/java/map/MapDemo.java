package map;

import javax.swing.text.Keymap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @program: thread-demo
 * @description:
 * @author: XTZ
 * @create: 2021-12-05 18:55
 **/
public class MapDemo {
    public static void main(String[] args) {
        Map map1 = new HashMap<String, String>();
        map1.put("aaa","1111");
        map1.put("bbb","2222");
        map1.put("ccc","3333");
        map1.put("ddd","4444");
        map1.put("ddd","5555");


        Set set = map1.keySet();
        Iterator iterator = set.iterator();
        while ( iterator.hasNext()){
            String next = (String)iterator.next();
            System.out.println(map1.get(next));
        }

    }
}
