package it.unibo.mvc;

import java.util.List;

/**
 * This is an interface for a controller.
 */
public interface Controller {

    /**
     * This method sets the current message.
     * It throws a NullPointerException if the parameter is null.
     * 
     * @param msg the message to set
     */
    void setString(String msg);

    /**
     * This method returns the current message.
     * If the message is unset, it returns an empty string.
     * 
     * @return the current message
     */
    String getString();

    /**
     * This method returns the list of messages printed up to this point.
     * It returns an empty list if nothing was printed.
     * 
     * @return the list of printed messages
     */
    List<String> getHistory();

    /**
     * This method prints the current method.
     * If the message is unset it throws an IllegalStateException.
     */
    void print();

}
