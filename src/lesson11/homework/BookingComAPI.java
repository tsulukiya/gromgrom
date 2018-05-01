package lesson11.homework;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room[] rooms1 = new Room[rooms.length];
        int maxPrice = price + 100;
        int minPrice = price - 100;
        if (minPrice <= 0)
            minPrice = 0;

        for (int i = 0; i < rooms.length; i++) {

            if ((rooms[i] != null) && (price >= 0)) {
                if (rooms[i].getPrice() >= minPrice && rooms[i].getPrice() <= maxPrice) {
                    if ((rooms[i].getPersons() == persons) && (rooms[i].getCityName() == city) && (rooms[i].getHotelName() == hotel)) {
                        rooms1[i] = rooms[i];
                        index++;
                    }
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
