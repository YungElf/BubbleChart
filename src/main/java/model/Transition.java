package model;

public class Transition {
    private String fromStateName;
    private String toStateName;
    private String eventType;

    public Transition(String fromStateName, String toStateName, String eventType) {
        this.fromStateName = fromStateName;
        this.toStateName = toStateName;
        this.eventType = eventType;
    }

    public String getFromStateName() {
        return fromStateName;
    }

    public void setFromStateName(String fromStateName) {
        this.fromStateName = fromStateName;
    }

    public String getToStateName() {
        return toStateName;
    }

    public void setToStateName(String toStateName) {
        this.toStateName = toStateName;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
