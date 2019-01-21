package courseJavaCore.lesson11.homework;

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
                if (room.getPrice() == room1.getPrice() &&
                        room.getHotelName() == room1.getHotelName() &&
                        room.getCityName() == room1.getCityName() &&
                        room.getPersons() == room1.getPersons())
                    index++;


            }
        }
        Room[] rooms = new Room[index];
        index = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPrice() == room1.getPrice() &&
                        room.getHotelName() == room1.getHotelName() &&
                        room.getCityName() == room1.getCityName() &&
                        room.getPersons() == room1.getPersons()) {
                    rooms[index] = room;
                    index++;
                }


            }
        }
        return rooms;
    }
}


