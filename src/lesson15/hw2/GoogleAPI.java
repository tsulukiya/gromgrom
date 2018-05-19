package lesson15.hw2;

import java.util.Date;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room room1 = new Room(1001, price, persons, new Date(), city, hotel);
        int index = 0;
        for (Room room : rooms) {
            if (room != null && room.equals(room1))
                index++;
        }

        Room[] rooms2 = new Room[index];
        index = 0;
        for (Room room : rooms)
            if (room != null && room1.equals(room)) {
                rooms2[index] = room;
                index++;
            }
        return rooms2;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
