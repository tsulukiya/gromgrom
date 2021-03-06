package courseJavaCore.lesson15.hw2;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room roomSearch = new Room(price, persons, hotel, city);

        for (Room room : rooms) {
            if (room != null &&
                    room.equals(roomSearch))
                index++;
        }

        Room[] rooms2 = new Room[index];
        index = 0;
        for (Room room : rooms)
            if (room != null &&
                    room.equals(roomSearch)) {
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
