import java.util.Random;

public class Hilos implements Runnable{

    private int numHilos = 0;
    private int maxHilos = 4;
    Random random = new Random();


    public Hilos(int numHilos, int MAX_HILOS){

        this.numHilos = numHilos;
        maxHilos = MAX_HILOS;
    }


    @Override
    public void run() {

        try{

            if(numHilos < maxHilos){

                Thread hiloHijo = new Thread(new Hilos(numHilos + 1, maxHilos));
                hiloHijo.start();
                hiloHijo.join();
            }

            for(int i = 0; i < 5; i++){
                System.out.println("Hilo " + numHilos + " ejecutando proceso: " + (i + 1)  + "/5");
                Thread.sleep(random.nextInt(1000));
            }
            System.out.println("hilo " + numHilos + " finalizado");

        }catch(InterruptedException e){
            e.printStackTrace();
        }

    }
}
