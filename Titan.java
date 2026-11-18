import java.util.Random;

// Armored and Colossal Titan: want Eren's power
public class Titan implements Observer {
    private String name;
    private UI ui;
    private Random rand = new Random();

    public Titan(String name, UI ui, Eren e) {
        this.name = name;
        this.ui = ui;
        e.registerObserver(this);
    }

    @Override
    public void update(int energy) {
        // 50% chance to attack
        if (rand.nextBoolean()) {
            ui.print(name + " attacks Eren!");
            if (energy > 40) {
                ui.print(name + ": \"Now we got problems, and I don't think we can solve 'em\"");
            }
        }
    }
}