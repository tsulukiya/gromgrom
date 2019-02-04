package lesson35.services;

import lesson35.model.Hotel;
import lesson35.repository.ShareRepository;

import java.io.*;
import java.util.List;

public abstract class ShareService extends ShareRepository {

    public void validatePathFileTo(String path) throws IOException {
        File fileTo = new File(path);

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + "does not exist");
        }
        if (!fileTo.canWrite()) {
            throw new IOException("File " + fileTo + " does not have permission to be written");
        }
    }

    public void validateAddDuplicatesHotelToDb(Hotel hotel, String path) throws IOException {
        List<Hotel> hotelList = convertContentFromPathToListHotel(path);

        for (Hotel hotel1 : hotelList) {
            if (hotel.getId() == hotel1.getId()) {
                throw new IOException("Hotel with ID - " + hotel.getId() + "is in hotelDb" );
            }
        }
    }
}


