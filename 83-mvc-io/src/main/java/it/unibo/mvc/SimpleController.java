package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a simple controller responsible of I/O access.
 * It prints on terminal, the history doesn't check for duplicates.
 */
public final class SimpleController implements Controller {

    private final List<String> history;
    private String msg;

    /**
     * Constructor that inizializes the controller.
     */
    public SimpleController() {
        this.history = new ArrayList<>();
        this.msg = null;
    }

    @Override
    public void setString(final String msg) {
        if (msg == null) {
            throw new IllegalArgumentException("Can't set message to null");
        } else {
            this.msg = msg;
        }
    }

    @Override
    public String getString() {
        return this.msg == null ? "" : this.msg;
    }

    @Override
    public List<String> getHistory() {
        return List.copyOf(this.history);
    }

    @Override
    public void print() {
        if (this.msg == null) {
            throw new IllegalStateException("Can't print unset message");
        } else {
            System.out.println(this.msg); //NOPMD, required for this exercise
            this.history.add(this.msg);
        }
    }
}
