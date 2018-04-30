package lesson11.firstinterface;

public class TestClass implements FirstIntarface {

    private int test = 10;

    @Override
    public void send() {
        // some logic
    }

    @Override
    public String receive() {
        // some logic
        return null;
    }
}
