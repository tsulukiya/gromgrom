package courseJavaCore.lesson25.homeWork;

public class GeneralDAO<T> {

    public void save(T[] mas, T t) throws Exception {

        int count = 0;
        for (T ma : mas) {
            if (ma == null)
                count++;
        }
        if (count == 0) {
            throw new Exception("Access is full. Element don't save...");
        }

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == null) {
                mas[i] = t;
                break;
            }
        }
    }

    public T[] getAll(T[] mas) {
        return mas;
    }
}
