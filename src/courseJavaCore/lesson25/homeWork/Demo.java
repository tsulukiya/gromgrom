package courseJavaCore.lesson25.homeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        String[] mas = {"sed", "weq", "sas", null};
        Integer[] mas1 = {1, 2, 3, 4, null};
        Double[] mas2 = {1.0, 2.0, 3.0, 4.0, 5.0, null};


        GeneralDAO generalDAO = new GeneralDAO();
        System.out.println(Arrays.toString(generalDAO.getAll(mas)));
        System.out.println(Arrays.toString(generalDAO.getAll(mas1)));
        System.out.println(Arrays.toString(generalDAO.getAll(mas2)));

        System.out.println("+++++++++++++++++++++++++++");

        generalDAO.save(mas, "time");
        generalDAO.save(mas1, 2);
        generalDAO.save(mas2, 0.0);

        System.out.println(Arrays.toString(generalDAO.getAll(mas)));
        System.out.println(Arrays.toString(generalDAO.getAll(mas1)));
        System.out.println(Arrays.toString(generalDAO.getAll(mas2)));



    }
}
