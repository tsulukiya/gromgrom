package lesson11.homework;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room[] rooms1 = new Room[getAll().length];

        for (int i = 0; i < getAll().length; i++) {

            if ((getAll()[i] != null) && (price >= 0)) {

                if ((getAll()[i].getPrice() >= 0) && (getAll()[i].getPrice() >= (price - 100) && getAll()[i].getPrice() <= (price + 100)) || ((getAll()[i].getPersons() == persons) ||
                        (getAll()[i].getCityName() == city) || (getAll()[i].getHotelName() == hotel))) {
                    rooms1[i] = getAll()[i];
                    index++;
                }
            }
        }

        Room[] rooms2 = new Room[index];
        for (int i = 0; i < rooms1.length; i++) {
            if (rooms1[i] != null) {
                rooms2[index - 1] = rooms1[i];
                index--;

            }
        }
        return rooms2;


    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

}
