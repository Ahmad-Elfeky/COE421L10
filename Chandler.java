import java.util.Random;

// Chandler is the Context: he HAS a Humor and can swap it at runtime
public class Chandler implements Runnable {
    private Humor humor;
    private Random rand = new Random();
    private Humor[] techniques = {
        new SarcasmHumor(), new WitHumor(), new SelfDeprecationHumor()
    };

    public Chandler() {
        humor = new SarcasmHumor(); // default technique
        new Thread(this).start();   // driver only creates him, so start here
    }

    public void setHumor(Humor humor) {
        this.humor = humor;
    }

    public void performHumor() {
        humor.joke();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {   // 10 jokes, then stop
                Thread.sleep(3000);
                setHumor(techniques[rand.nextInt(techniques.length)]);
                performHumor();
            }
        } catch (InterruptedException e) {
            System.out.println("Chandler was interrupted.");
        }
    }
}