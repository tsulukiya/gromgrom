package lesson25.homeWork;

public class GeneralDAO<T> {

    private String[] mas = new String[10];

    public T save(T t) throws Exception {

        if (!(t instanceof String)) {
            throw new Exception("Incorrect type variable. Element don't save...");
        }

        int count = 0;
        for (String el : mas) {
            if (el == null) {
                count++;
            }
            if (count == 0) {
                throw new Exception("Access is full. Element don't save...");
            }


        }
        count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null) {
                mas [i] = (String) t;
                return (T) mas [i];
        }


        }
        return null;
    }

    public T [] getAll() {
        return ;
    }
}
