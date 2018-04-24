package lesson10.HomeWorkLesson10;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    void validateOrder() {
        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Харьков") &
                (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Харьков") &
                (getBasePrice() >= 100) & (getCustomerOwned().getGender() == "Женский")) {

            confirmShipping();

        }


    }

    @Override
    void calculatePrice() {
        setTotalPrice(deliveryPrice() + getBasePrice());
        if (getTotalPrice() > 1000)
            setTotalPrice(getTotalPrice() * 0.05);

    }

    private double deliveryPrice() {
        double delivery;
        if ((getShipToCity() != "Киев") && (getShipToCity() != "Одесса")) {
            delivery = getBasePrice() * 0.15;
        } else {
            delivery = getBasePrice() * 0.1;
        }
        return delivery;
    }
}
