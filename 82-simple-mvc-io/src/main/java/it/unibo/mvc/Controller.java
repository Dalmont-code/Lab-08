package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String DEFAULT_PATH = System.getProperty("user.home")
            + System.getProperty("file.separator")
            + "output.txt";
    private File file;
    
    public Controller(final String pathname) {
        file = new File(pathname);
    }

    public Controller() {
        this(DEFAULT_PATH);
    }
    
    public void setFile(final String pathname) {
        this.file = new File(pathname);
    }

    public File getFile() {
        return this.file;
    }

    public String getPath() {
        return this.file.getPath();
    }

    public void add(final String arg) throws IOException {
        try (final PrintStream ps = new PrintStream(this.file)) {
            ps.print(arg);
        }
    }
}
