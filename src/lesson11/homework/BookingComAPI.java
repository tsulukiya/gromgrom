package lesson11.homework;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int person, String city, String hotel) {
        int index = 0;
        int priceMin = price - 100;
        int priceMax = price + 100;
        if (price <= 100)
            priceMin = 0;
        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i] != null) {

                if (rooms[i].getPrice() == price && rooms[i].getPersons() == person && rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel) {
                    index = index + 1;

                } else if ((rooms[i].getPrice() >= priceMin) && (rooms[i].getPrice() <= priceMax)) {
                    index = index + 1;

                }

            }
        }
        Room[] rooms1 = new Room[index];
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null) {

                if (rooms[i].getPrice() == price && rooms[i].getPersons() == person && rooms[i].getCityName() == city && rooms[i].getHotelName() == hotel) {
                    rooms1[i] = rooms[i];

                } else if ((rooms[i].getPrice() >= priceMin) && (rooms[i].getPrice() <= priceMax)) {
                    rooms1[i] = rooms[i];

                }

            }

        }
        return rooms1;


    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

}
