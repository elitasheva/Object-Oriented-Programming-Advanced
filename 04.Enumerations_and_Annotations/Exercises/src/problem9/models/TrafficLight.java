package problem9.models;


import problem9.enums.Light;

import java.util.List;

public class TrafficLight {

    private List<Light> currentState;

    public TrafficLight(List<Light> currentState) {
        this.currentState = currentState;
    }

    public Light changeLight(Light currentLight) {

        switch (currentLight) {
            case YELLOW:
                return Light.RED;
            case RED:
                return Light.GREEN;
            case GREEN:
                return Light.YELLOW;
        }
        return null;
    }

    public List<Light> getCurrentState() {
        return currentState;
    }

    public void setCurrentState(List<Light> currentState) {
        this.currentState = currentState;
    }
}
