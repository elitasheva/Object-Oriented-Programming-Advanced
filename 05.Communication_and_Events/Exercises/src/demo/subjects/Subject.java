package demo.subjects;

import demo.subscribers.Subscriber;

public interface Subject {

    void subcribe(Subscriber subscriber);

    void unsubscribe(Subscriber subscriber);

    void notifySubscribers();
}
