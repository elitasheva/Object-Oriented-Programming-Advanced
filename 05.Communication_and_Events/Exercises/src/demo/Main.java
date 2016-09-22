package demo;

import demo.subjects.Subject;
import demo.subjects.YouTubeChannel;
import demo.subscribers.Moderator;
import demo.subscribers.Subscriber;
import demo.subscribers.User;

public class Main {

    public static void main(String[] args) {

        Subject youTube = new YouTubeChannel();

        Subscriber pesho = new User("Pesho");
        youTube.subcribe(pesho);
        Subscriber gosho = new User("Gosho");
        youTube.subcribe(gosho);
        Subscriber stamat = new Moderator("Stamat");
        youTube.subcribe(stamat);

        youTube.notifySubscribers();

        youTube.unsubscribe(gosho);

        youTube.notifySubscribers();
    }
}
