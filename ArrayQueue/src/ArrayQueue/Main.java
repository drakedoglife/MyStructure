package ArrayQueue;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayQueue aq = new ArrayQueue(3);
        try {
            aq.addData(3);
            aq.addData(4);
            aq.addData(5);

            aq.showQueue();

            aq.deleteData();
            aq.showQueue();
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
