package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a simple controller responsible of I/O access.
 * It prints on terminal, the history doesn't check for duplicates.
 */
public final class SimpleController implements Controller {

    private List<String> history;
    private String msg;

    public SimpleController() {
        this.history = new ArrayList<>();
        this.msg = "";
    }
    
    @Override
    public void setString(final String msg) {
        if (msg == null) {
            throw new NullPointerException("Can't set message to null");
        } else {
            this.msg = msg;
        }
    }

    @Override
    public String getString() {
        return new String(this.msg);
    }

    @Override
    public List<String> getHistory() {
        return this.history;
    }

    @Override
    public void print() {
        if (this.msg.isEmpty()) {
            throw new IllegalStateException("Can't print unset message");
        } else {
            System.out.println(this.msg);
            this.history.add(this.msg);
        }
    }
}
