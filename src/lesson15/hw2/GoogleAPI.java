package lesson15.hw2;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room roomSearch = new Room(price, persons, city, hotel);
        int index = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(roomSearch)) 
                index++;

        }

        Room[] rooms2 = new Room[index];
        index = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(roomSearch)) {
                rooms2[index] = rooms[i];
                index++;
            }
        }
        return rooms2;
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
