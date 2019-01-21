package courseJavaCore.lesson10.HomeWorkLesson10;

import java.util.Date;

public class Demo {

    public static void main(String[] args) {

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("PS4", new Date(), "Киев", "Одесса",
                1000, new Customer("Anton", "Киев", "Мужской"), 12);

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("PS3", new Date(), "Луганск", "Харьков",
                100, new Customer("Ирина", "Киев", "Женский"), 18);

        FurnitureOrder furnitureOrder = new FurnitureOrder("Divan", new Date(), "Киев", "Днепр",
                500, new Customer("Sergey", "Днепр", "Женский"), "123ACD");

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Divan1", new Date(), "Чернигов", "Харьков",
                5000, new Customer("Sergey", "Днепр", "Женский"), "103ACD");


        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");

        electronicsOrder.confirmShipping();
        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();
        System.out.println(electronicsOrder);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");


        electronicsOrder1.validateOrder();
        electronicsOrder1.confirmShipping();
        electronicsOrder1.calculatePrice();
        System.out.println(electronicsOrder1);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        furnitureOrder.validateOrder();
        furnitureOrder.confirmShipping();
        furnitureOrder.calculatePrice();
        System.out.println(furnitureOrder);

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


        furnitureOrder1.validateOrder();
        furnitureOrder1.confirmShipping();
        furnitureOrder1.calculatePrice();
        System.out.println(furnitureOrder1);


    }
}
