package lesson11.homework;

public interface API {

    Room[] findRooms(int price, int person, String city, String hotel);

    Room[] getAll();
}
