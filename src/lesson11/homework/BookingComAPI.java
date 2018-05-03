package lesson11.homework;

public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;

        for (Room room : rooms) {
            if (room != null &&
                    room.getPrice() >= price - 100 &&
                    room.getPrice() <= price + 100 &&
                    room.getPersons() == persons &&
                    room.getCityName() == city &&
                    room.getHotelName() == hotel)
                index++;
        }

        Room[] rooms2 = new Room[index];
        for (Room room : rooms)
            if (room != null &&
                    room.getPrice() >= price - 100 &&
                    room.getPrice() <= price + 100 &&
                    room.getPersons() == persons &&
                    room.getCityName() == city &&
                    room.getHotelName() == hotel) {
                rooms2[index - 1] = room;
                index--;
            }
        return rooms2;


    }

    @Override
    public Room[] getAll() {
        return rooms;
    }

}
