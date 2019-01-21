package courseJavaCore.lesson29;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    private static Set<Order> useHashSet() {
        Order order1 = new Order(1001,2000,"USD", "aaa", "k1");
        Order order2 = new Order(1002,2001,"UAH", "bbb", "k2");
        Order order3 = new Order(1003,2002,"RUB", "ccc", "k3");
        Order order4 = new Order(1004,2003,"AUD", "ddd", "k4");
        Order order5 = new Order(1005,2004,"AED", "eee", "k5");
        Order order6 = new Order(1006,2044,"AED", "fff", "k6");

        Set<Order>orderSet1 = new HashSet<>();
        orderSet1.add(order1);
        orderSet1.add(order2);
        orderSet1.add(order3);
        orderSet1.add(order4);
        orderSet1.add(order5);
        orderSet1.add(order6);

        Set<Order>orderSet = new HashSet<>();
        orderSet.add(order1);
        orderSet.add(order2);
        orderSet.add(order3);
        orderSet.add(order4);
        orderSet.add(order5);
        orderSet.add(order6);

        orderSet.remove(order6);
        orderSet.retainAll(orderSet1);
        orderSet.toArray();
        orderSet.size();

        System.out.println(orderSet.iterator().next().getId());



      return orderSet;

    }

    public static void main(String[] args) {

        System.out.println(useHashSet());
    }
}
