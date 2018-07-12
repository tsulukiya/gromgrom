package lesson19;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        try {

            File file1 = new File(1, "disk111", "psd", 923);
            File file2 = new File(2, "disk2", "psd", 100);
            File file3 = new File(3, "disk3", "psd", 900);
            File file4 = new File(4, "disk4", "psd", 920);
            File file5 = new File(5, "disk5", "psd", 92);
            File file6 = new File(6, "disk6", "psd", 921);
            File file7 = new File(7, "disk777777", "txt", 922);
            File file8 = new File(12, "disk8", "jpeg", 800);
            File file9 = new File(10, "disk9", "jpeg", 890);
            File file10 = new File(11, "disk10", "jpeg", 902);
            File[] files1 = new File[]{file1, null};
            File[] files2 = new File[]{file4, null, null, null, null, null};
            String[] format1 = new String[]{"psd", "xml", "txt"};
            String[] format2 = new String[]{"doc", "xls", "java"};
            Storage storageOne = new Storage(1001, files1, format1, "Ukraine", 20000);
            //Storage storageTwo = new Storage(1002, files2, format2, "Russia", 10000);
            Controller controller = new Controller();
            controller.put(storageOne, file7);
            //controller.delete(storageOne, file9);

           //controller.transferAll(storageOne, storageTwo);

            //controller.transferFile(storageOne, storageTwo, 1);


            System.out.println(storageOne);
//            System.out.println(storageTwo);


        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
