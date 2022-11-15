package it.unibo.mvc;

import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String msg;
    
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> getHistory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        
    }
    
}
