package courseJavaCore.lesson15.hw2;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int index = 0;

        for (API api : apis) {
            index = index + api.findRooms(price, persons, city, hotel).length;
        }
        Room[] rooms = new Room[index];
        index = 0;

        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                rooms[index] = room;
                index++;
            }
        }
        return rooms;
    }


    public Room[] check(API api1, API api2) {
        int index = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.equals(room1))
                    index++;


            }
        }
        Room[] rooms = new Room[index];
        index = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.equals(room1)) {
                    rooms[index] = room;
                    index++;
                }


            }
        }
        return rooms;
    }
}


