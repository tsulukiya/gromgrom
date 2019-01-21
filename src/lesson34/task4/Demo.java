package lesson34.task4;

public class Demo {
    public static void main(String[] args) throws Exception {
        Solution.copyFileContent("/Users/macbook/Documents/testFrom.txt",
                "/Users/macbook/Documents/testTo.txt");

        Solution.copyFileContentApacheIO("/Users/macbook/Documents/testFrom.txt",
                "/Users/macbook/Documents/testTo.txt");
    }
}
