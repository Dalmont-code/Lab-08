package it.unibo.mvc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File file;

    /**
     * 
     * @param pathname the file to write onto
     */
    public Controller(final String pathname) {
        file = new File(pathname);
    }

    /**
     * Default controller constructor, 
     * writes to "output.txt" in the user's home folder.
     */
    public Controller() {
        this(DEFAULT_PATH);
    }

    /**
     * Sets a new file to write to.
     * @param pathname the new file
     */
    public void setFile(final String pathname) {
        this.file = new File(pathname);
    }

    /**
     * Gets the current output file as a File Object.
     * @return the current file
     */
    public File getFile() {
        return this.file;
    }

    /**
     * Gets the current output file path as a String.
     * @return the current file path
     */
    public String getPath() {
        return this.file.getPath();
    }

    /**
     * Writes the String passed as argument to the current file.
     * @param arg the String to write on the file
     * @throws IOException
     */
    public void add(final String arg) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(this.file.toPath(), StandardCharsets.UTF_8)) {
            bf.write(arg);
        }
    }
}
