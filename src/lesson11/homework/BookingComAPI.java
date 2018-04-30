package lesson11.homework;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int person, String city, String hotel) {
        int index = 0;
        Room[] rooms1 = new Room[rooms.length];
        int priceMin = price - 100;
        int priceMax = price + 100;
        if (price <= 100) {
            priceMin = 0;
        }
        for (int i = 0; i < rooms.length; i++) {

            if ((rooms[i] != null) && (price >= 0)) {

                if ((rooms[i].getPrice() >= priceMin) && (rooms[i].getPrice() <= (priceMax) && rooms[i].getPersons() == person &&
                        rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel)) {
                    rooms1[i] = rooms[i];
                    index++;
                }
            }
        }

        if (index > 0) {
            Room[] rooms2 = new Room[index];
            for (int i = 0; i < rooms1.length; i++) {
                if (rooms1[i] != null) {
                    rooms2[i] = rooms1[i];
                }
            }
            return rooms2;
        }
        return null;

    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

}
