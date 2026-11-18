// Shared UI object: ALL printing goes through here.
// synchronized so lines from different objects never get mixed up.
public class UI {
    public synchronized void print(String message) {
        System.out.println(message);
    }
}