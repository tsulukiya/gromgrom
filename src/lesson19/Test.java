package lesson19;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        try {

            File file = new File(1, "disk111", "jpeg", 923);
            File file1 = new File(2, "disk2", "png", 100);
            File file2 = new File(3, "disk3", "psd", 900);
            File file3 = new File(4, "disk4", "pdf", 9230);
            File file4 = new File(5, "disk5", "txt", 92);
            File file5 = new File(6, "disk6", "xml", 921);
            File file6 = new File(7, "disk7", "doc", 922);
            File file7 = new File(12, "disk8", "jpeg", 800);
            File file8 = new File(10, "disk9", "jpeg", 890);
            File file9 = new File(11, "disk10", "jpeg", 902);
            File[] files1 = new File[]{file, file1, file2, file3, file5, null, null, null, null, null};
            File[] files2 = new File[]{file4, file6, file7, file8, file9};
            Storage storageOne = new Storage(1001, files1, "jpeg", "Ukraine", 20000);
            Storage storageTwo = new Storage(1002, files2, "psd", "Russia", 10000);
            Controller controller = new Controller();
            controller.put(storageOne, file7);

        } catch (Exception e) {
            System.out.println(e);

        }


    }
}
