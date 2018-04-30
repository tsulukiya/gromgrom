package lesson11.homework;

public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int person, String city, String hotel) {
        return new Room[0];
    }

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
