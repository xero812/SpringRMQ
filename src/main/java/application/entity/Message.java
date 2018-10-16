package application.entity;

import application.actions.Actions;

import java.io.Serializable;
import java.util.Objects;

public class Message implements Serializable {

    private static final long serialversionUID = 129348938L;

    String id;
    String data;
    Actions actions;

    public Message() {
        this.actions = Actions.PRIORITY_3;
    }

    public Message(String id, String data) {
        this.id = id;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message = (Message) o;
        return Objects.equals(getId(), message.getId()) &&
                Objects.equals(getData(), message.getData()) &&
                getActions() == message.getActions();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getData(), getActions());
    }

    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", actions=" + actions +
                '}';
    }

}
