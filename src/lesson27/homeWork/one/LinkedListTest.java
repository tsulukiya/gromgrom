package lesson27.homeWork.one;

import lesson26.Order;

import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTest {

    private static LinkedList<Order> useList() {

        Order order1 = new Order(11, 1000, "USD", "element1", "WW11");
        Order order2 = new Order(12, 100, "UAH", "element2", "WW12");
        Order order3 = new Order(13, 10, "RUB", "element3", "WW13");
        Order order4 = new Order(14, 1200, "EUR", "element4", "WW14");
        Order order5 = new Order(15, 1035, "AUD", "element5", "WW15");
        Order order6 = new Order(16, 10305, "AUD", "element6", "WW16");
        Order order7 = new Order(17, 10375, "AUD", "element7", "WW17");
        Order order8 = new Order(18, 10365, "AUD", "element8", "WW18");

        LinkedList<Order> orderArrayList2 = new LinkedList<>();
        orderArrayList2.add(order7);
        orderArrayList2.add(order8);


        LinkedList<Order> orderArrayList = new LinkedList<>();
        orderArrayList.add(order1);
        orderArrayList.add(order2);
        orderArrayList.add(order3);
        orderArrayList.add(order4);
        orderArrayList.add(order5);

        orderArrayList.add(0, order6);
        orderArrayList.remove(0);
        orderArrayList.remove(order1);
        orderArrayList.addAll(orderArrayList2);
        orderArrayList.subList(0, 2);
        orderArrayList.set(1, order8);
        orderArrayList.contains(orderArrayList2);
        orderArrayList.toArray(new Order[orderArrayList.size()]);
        orderArrayList.subList(1, 2).clear();

        return orderArrayList;


    }
}
