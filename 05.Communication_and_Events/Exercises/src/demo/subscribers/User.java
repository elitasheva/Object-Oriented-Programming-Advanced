package demo.subscribers;

public class User implements Subscriber {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println(String.format("The user: %s have to watch the new video", this.name));
    }
}
