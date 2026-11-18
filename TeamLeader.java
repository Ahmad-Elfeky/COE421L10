// Levi: loses 5 patience every time Eren transforms
public class TeamLeader implements Observer {
    private String name;
    private int patience;
    private UI ui;

    public TeamLeader(String name, int patience, UI ui, Eren e) {
        this.name = name;
        this.patience = patience;
        this.ui = ui;
        e.registerObserver(this);
    }

    @Override
    public void update(int energy) {
        if (patience <= 0) {
            return; // already finished, print nothing further
        }
        patience -= 5;
        ui.print(name + " sees Eren transform. Patience is now " + patience + ".");

        if (patience == 10) {
            ui.print(name + ": \"My patience is waning!\"");
        } else if (patience == 5) {
            ui.print(name + ": \"Is this entertaining?\"");
        } else if (patience <= 0) {
            ui.print(name + ": \"Omae wa mou shindeiru\"");
        }
    }
}