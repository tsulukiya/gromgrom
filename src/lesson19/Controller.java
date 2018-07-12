package lesson19;

public class Controller {

    public static void put(Storage storage, File file) throws Exception {

        if (checkID(storage, file))
            throw new Exception("The item with the given id already exists in the repository. " +
                    "file ID - " + file.getId() + ", ID storage - " + storage.getId() + "(method put in Controller class)");

        if (!checkFormat(storage, file))
            throw new Exception("Incorrect file format. " +
                    "file ID - " + file.getId() + ", ID storage - " + storage.getId() + "(method put in Controller class)");

        if (countSizeStorage(storage, file))
            throw new Exception("Out of memory in storage. " +
                    "file ID - " + file.getId() + ", ID storage - " + storage.getId() + "(method put in Controller class)");

        if (!checkFreeIndex(storage))
            throw new Exception("Out of free index in storage. " +
                    "file ID - " + file.getId() + ", ID storage - " + storage.getId() + "(method put in Controller class)");
        else addToStorage(storage, file);

    }


    public void delete(Storage storage, File file) throws Exception {

        if (!searchEqualsFile(storage, file))
            throw new Exception("Out of file in storage. " +
                    "file ID - " + file.getId() + "ID storage - " + storage.getId() + "(method delete in Controller class)");
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null)
                if (storage.getFiles()[i].getId() == file.getId() && storage.getFiles()[i].getName().equals(file.getName()))
                    storage.getFiles()[i] = null;
        }
    }


    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {

        if (!checkTransferAll(storageFrom, storageTo))
            throw new Exception("Operation is not possible..." + "(method transferAll in Controller class)");

        for (File storageFromFile : storageFrom.getFiles()) {
            for (File storageToFile : storageTo.getFiles()) {
                if (storageFromFile != null && storageToFile == null) {

                    if (checkID(storageTo, storageFromFile))
                        throw new Exception("The item with the given id already exists in the repository. " +
                                "file ID - " + storageFromFile.getId() + ", ID storage - " + storageTo.getId()
                                + "(method transferAll in Controller class)");

                    if (!checkFormat(storageTo, storageFromFile))
                        throw new Exception("Incorrect file format. " +
                                "file ID - " + storageFromFile.getId() + ", ID storage - " + storageTo.getId()
                                + "(method transferAll in Controller class)");


                    if (countSizeStorage(storageTo, storageFromFile))
                        throw new Exception("Out of memory in storage. " +
                                "file ID - " + storageFromFile.getId() + ", ID storage - " + storageTo.getId()
                                + "(method transferAll in Controller class)");


                    if (!checkFreeIndex(storageTo))
                        throw new Exception("Out of free index in storage. " +
                                "file ID - " + storageFromFile.getId() + ", ID storage - " + storageTo.getId()
                                + "(method transferAll in Controller class)");


                    else {
                        delete(storageFrom, storageFromFile);
                        addToStorage(storageTo, storageFromFile);
                        break;
                    }
                }
            }
        }
    }


    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        int count = 0;

        for (File file : storageFrom.getFiles()) {
            if (file.getId() == id) {
                put(storageTo, file);
                delete(storageFrom, file);
                count++;
                break;
            }
        }

        if (count == 0)
            throw new Exception("Out file of this ID" + id);
    }


    private static boolean checkID(Storage storage, File file) {

        for (File fileStorage : storage.getFiles()) {
            if (fileStorage != null && file != null)
                if (fileStorage.getId() == file.getId())
                    return true;
        }
        return false;
    }

    private static boolean checkFormat(Storage storage, File file) {

        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return true;
        }
        return false;
    }

    private static boolean countSizeStorage(Storage storage, File file) {
        long countSize = storage.getStorageSize();

        for (File storageFile : storage.getFiles()) {
            if (storageFile != null)
                countSize -= storageFile.getSize();
        }
        return countSize <= file.getSize();
    }

    private static boolean checkFreeIndex(Storage storage) {
        for (File storageFile : storage.getFiles()) {
            if (storageFile == null)
                return true;
        }
        return false;
    }

    private static Storage addToStorage(Storage storage, File file) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                break;
            }
        }
        return storage;
    }

    private static boolean searchEqualsFile(Storage storage, File file) {

        for (File storageFile : storage.getFiles()) {
            if (storageFile != null)
                if (storageFile.getId() == file.getId() && storageFile.getName().equals(file.getName()))
                    return true;
        }
        return false;
    }

    private static boolean checkTransferAll(Storage storageFrom, Storage storageTo) {
        int countFrom = 0;
        int countTo = 0;
        for (File file : storageFrom.getFiles()) {
            if (file != null)
                countFrom++;
        }

        for (File file : storageTo.getFiles()) {
            if (file == null)
                countTo++;
        }
        return countFrom <= countTo;
    }
}
