public class Main {

    public static void main(String[] args) {
        DataHandler handler=new DataHandler("Resources/Wuzzuf_Jobs.csv");
        System.out.println(handler.Process());
    }
}
