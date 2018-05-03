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

        for (Room room : rooms) {
            if ((room != null) && (price >= 0))
                if (room.getPrice() >= minPrice && room.getPrice() <= maxPrice)
                    if ((room.getPersons() == persons) && (room.getCityName() == city) && (room.getHotelName() == hotel)) {
                        rooms1[index] = room;
                        index++;
                    }
        }

        Room[] rooms2 = new Room[index];
        for (Room room : rooms1) {
            if (room != null) {
                rooms2[index - 1] = room;
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
