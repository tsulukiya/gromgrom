package lesson25.homeWork;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO <String> generalDAO = new GeneralDAO<>();
        System.out.println(generalDAO.save("111"));
        System.out.println(generalDAO.getAll());
    }
}
