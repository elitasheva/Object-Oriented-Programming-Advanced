package demo.subjects;

import demo.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class YouTubeChannel implements Subject {

    private List<Subscriber> subscribers;

    public YouTubeChannel() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subcribe(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {

        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }
}
