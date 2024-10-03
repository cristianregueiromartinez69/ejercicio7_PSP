public class Main {
    public static void main(String[] args) {

        Thread hiloPadre = new Thread(new Hilos(1,4));
        hiloPadre.start();
    }
}