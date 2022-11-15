package it.unibo.mvc;

import java.util.List;

/**
 * This is an interface for a controller
 */
public interface Controller {

    /**
     * This method sets the current message.
     * It throws a NullPointerException if the parameter is null.
     * 
     * @param msg
     * @throws NullPointerException
     */
    public void setString(String msg) throws NullPointerException;

    /**
     * This method returns the current message.
     * If the message is unset, it returns an empty string.
     * 
     * @return the current message
     */
    public String getString();

    /**
     * This method returns the list of messages printed up to this point.
     * It returns an empty list if nothing was printed.
     * 
     * @return the list of printed messages
     */
    public List<String> getHistory();

    /**
     * This method prints the current method.
     * If the message is unset it throws an IllegalStateException.
     * 
     * @throws IllegalStateException
     */
    public void print() throws IllegalStateException;

}
