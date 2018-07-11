package lesson19;

public class Controller {

    public void put(Storage storage, File file) throws Exception {

        if (checkID(storage, file))
            throw new Exception("The item with the given id already exists in the repository. " +
                    "file NAME - " + file.getName() + "ID file - " + file.getId());

        if (!checkFormat(storage, file))
            throw new Exception("Incorrect file format. " +
                    "file NAME - " + file.getName() + "ID file - " + file.getId());

        if (countSizeStorage(storage, file))
            throw new Exception("Out of memory in storage. " +
                    "file NAME - " + file.getName() + "ID file - " + file.getId());

        if (!checkFreeIndex(storage))
            throw new Exception("Out of free index in storage. " +
                    "file NAME - " + file.getName() + "ID file - " + file.getId());
        else addToStorage(storage, file);

        System.out.println("File add to storage...");


    }

    public void delete(Storage storage, File file) {

    }

    public void transferAll(Storage storageFrom, Storage storageTo) {

    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {

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

        return storage.getFormatsSupported().equals(file.getFormat());

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
}
