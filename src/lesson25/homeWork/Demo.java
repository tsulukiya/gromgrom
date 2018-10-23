package lesson25.homeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        String[] mas = {"sed", "weq", "sas"};
        Integer[] mas1 = {1, 2, 3, 4};
        Short[] mas2 = {1,2,3,4,5};


        GeneralDAO generalDAO = new GeneralDAO();
        System.out.println(Arrays.toString(generalDAO.getAll(mas)));
        System.out.println(Arrays.toString(generalDAO.getAll(mas1)));
        System.out.println(Arrays.toString(generalDAO.getAll(mas2)));

    }
}
