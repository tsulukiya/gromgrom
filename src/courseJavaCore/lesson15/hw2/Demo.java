package courseJavaCore.lesson15.hw2;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(110, 0, 3, new Date(), "Vine", "Kiev");
        Room room2 = new Room(1110, 0, 3, new Date(), "Vine", "Kiev");
        Room room3 = new Room(1120, 1000, 1, new Date(), "ABT", "Dnepropetrovsk");
        Room room4 = new Room(1130, 0, 2, new Date(), "Simpson", "Gdansk");
        Room room5 = new Room(1140, 1200, 4, new Date(), "Alpha", "Kiev");
        Room room6 = new Room(1150, 1300, 6, new Date(), "Beta", "NewYork");
        Room room7 = new Room(1100, 100, 3, new Date(), "Vine", "Kiev");
        Room room8 = new Room(111, 90, 3, new Date(), "Vine", "Kiev");
        Room room9 = new Room(112, 200, 3, new Date(), "Vine", "Kiev");
        Room room10 = new Room(113, -146, 3, new Date(), "Vine", "Kiev");
        Room room11 = new Room(114, -189, 3, new Date(), "Vine", "Kiev");
        Room room12 = new Room(115, 190, 3, new Date(), "Vine", "Kiev");

        Room room21 = new Room(110, 0, 3, new Date(), "Vine", "Kiev");
        Room room22 = new Room(1110, 200, 4, new Date(), "Ibis", "Kharkov");
        Room room33 = new Room(1120, 1000, 1, new Date(), "ABT", "Dnepropetrovsk");
        Room room44 = new Room(1130, 0, 2, new Date(), "Simpson", "Gdansk");
        Room room55 = new Room(1140, 1200, 4, new Date(), "Alpha", "Kiev");
        Room room66 = new Room(1150, 1300, 6, new Date(), "Beta", "NewYork");
        Room room77 = new Room(1100, 100, 3, new Date(), "Vine", "Kiev");
        Room room88 = new Room(111, 90, 3, new Date(), "Vine", "Kiev");
        Room room99 = new Room(112, 200, 3, new Date(), "Vine", "Kiev");
        Room room190 = new Room(113, -146, 3, new Date(), "Vine", "Kiev");
        Room room119 = new Room(114, -189, 3, new Date(), "Vine", "Kiev");
        Room room128 = new Room(115, 190, 3, new Date(), "Vine", "Kiev");

        Room[] rooms = new Room[]{room1, room2, room3, room4, room5, room8, room9, room10, room11, room12};
        //Room[] rooms1 = new Room[]{room21, room33, room44, room55, room66, room77, room88, room99, room190, room119, room128};

       // BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);
        System.out.println(Arrays.toString(googleAPI.findRooms(0, 3, "Vine", "Kiev")));
       // TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
       // API[] apis = new API[]{bookingComAPI, googleAPI, tripAdvisorAPI};

       // Controller controller = new Controller(apis);
       // Room[] rooms2 = controller.requestRooms(100, 3, "Kiev", "Vine");
       // Room[] rooms3 = controller.check(bookingComAPI, googleAPI);

       // for (Room room : rooms2) {
       //     System.out.println(room);
        //}

       // for (Room room : rooms3) {
       //     System.out.println(room);

        //}


    }


}
