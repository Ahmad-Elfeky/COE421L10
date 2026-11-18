import java.util.Random;

// Mikasa and Armin: worried about Eren
public class Friend implements Observer {
    private String name;
    private UI ui;
    private Random rand = new Random();

    public Friend(String name, UI ui, Eren e) {
        this.name = name;
        this.ui = ui;
        e.registerObserver(this);
    }

    @Override
    public void update(int energy) {
        // 50% chance
        if (rand.nextBoolean()) {
            ui.print(name + ": \"Eren, please be safe!\"");
        }
        if (energy < 20) {
            ui.print(name + ": \"Rage, rage against the dying of the light\"");
        }
    }
}