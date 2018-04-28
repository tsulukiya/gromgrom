package lesson10.HomeWorkLesson10;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if (((getShipFromCity() == "Киев" || getShipFromCity() == "Львов")) &
                (getBasePrice() >= 500) & (getCustomerOwned().getName() != "Тест")) {
            confirmShipping();
        }

    }

    @Override
    public void calculatePrice() {
        setTotalPrice(deliveryPrice() + getBasePrice());
    }

    private double deliveryPrice() {
        double delivery;
        if (getBasePrice() < 5000) {
            delivery = getBasePrice() * 0.05;
        } else {
            delivery = getBasePrice() * 0.02;
        }
        return delivery;
    }

}

