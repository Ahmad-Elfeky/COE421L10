import java.util.ArrayList;
import java.util.Random;

// Eren is the Subject. He runs on his own thread.
public class Eren implements Subject, Runnable {
    private int energy;
    private UI ui;
    private ArrayList<Observer> observers = new ArrayList<>();
    private Random rand = new Random();

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
        // The driver never calls start(), so Eren starts his own thread here
        new Thread(this).start();
    }

    @Override
    public synchronized void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public synchronized void notifyObservers() {
        for (Observer o : observers) {
            o.update(energy);
        }
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public void run() {
        try {
            while (energy > 0) {
                // Wait a random time between 5 and 10 seconds
                int wait = 5 + rand.nextInt(6);
                Thread.sleep(wait * 1000);

                // Transform: lose 5 energy, then tell everyone
                energy -= 5;
                ui.print("\n*** Eren transforms into a Titan! Energy: " + energy + " ***");
                notifyObservers();

                // Stay a Titan for 10 seconds
                Thread.sleep(10000);
                ui.print("Eren returns to human form.");
            }
            ui.print("\nEren's energy has reached 0. He can no longer transform.");
        } catch (InterruptedException ex) {
            ui.print("Eren's thread was interrupted.");
        }
    }
}