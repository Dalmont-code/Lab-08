package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame("Simple Text Edit UI");
    private static final int PROPORTION = 5;

    /**
     * Creates the GUI.
     */
    public SimpleGUIWithFileChooser() {
        final Controller controller = new Controller();
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JPanel upperpanel = new JPanel();
        upperpanel.setLayout(new BorderLayout());
        final JTextArea filepath = new JTextArea();
        filepath.setEditable(false);
        filepath.setText(controller.getPath());
        final JButton browse = new JButton("Browse..");
        upperpanel.add(filepath, BorderLayout.CENTER);
        upperpanel.add(browse, BorderLayout.EAST);
        final JTextArea text = new JTextArea();
        final JButton save = new JButton("Save");
        panel.add(upperpanel, BorderLayout.NORTH);
        panel.add(text, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.add(text.getText());
                } catch (IOException e1) {
                    e1.printStackTrace(); //NOPMD, allowed for this exercise
                }
            }
        });
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select a file");
                switch (chooser.showSaveDialog(frame)) {
                    case JFileChooser.APPROVE_OPTION -> {
                        controller.setFile(chooser.getSelectedFile().getAbsolutePath());
                        filepath.setText(controller.getPath());
                    }
                    case JFileChooser.CANCEL_OPTION -> { }
                    default -> {
                        JOptionPane.showMessageDialog(frame, "An error has occured..", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        this.frame.add(panel);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.display();
    }

    /**
     * Sets the initial position and dimension of the frame.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        this.frame.setSize(sw / PROPORTION, sh / PROPORTION);
        this.frame.setLocationByPlatform(true);
        this.frame.setVisible(true);
    }

    /**
     * Main method, starts a simple GUI application that lets the user edit and save a file.
     * It also lets the user choose which file they want to edit.
     * @param args unused
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser();
    }
}
