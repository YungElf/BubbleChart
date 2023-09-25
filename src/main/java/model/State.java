package model;

import java.util.List;

public class State {
    private String name;
    private String action;
    private List<Transition> transitions;

    public State(String name, String action, List<Transition> transitions) {
        this.name = name;
        this.action = action;
        this.transitions = transitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }
}
