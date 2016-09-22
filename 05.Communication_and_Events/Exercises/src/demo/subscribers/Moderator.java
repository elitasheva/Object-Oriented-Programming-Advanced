package demo.subscribers;

public class Moderator implements Subscriber{

    private String name;

    public Moderator(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(String.format("The moderator: %s has to check the new video", this.name));
    }
}
