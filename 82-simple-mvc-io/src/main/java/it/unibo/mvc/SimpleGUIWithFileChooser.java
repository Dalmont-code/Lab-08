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
    private final int PROPORTION = 5;

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
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.add(text.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        browse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select a file");
                switch (chooser.showSaveDialog(frame)) {
                    case JFileChooser.APPROVE_OPTION -> {
                        controller.setFile(chooser.getSelectedFile().getAbsolutePath());
                        filepath.setText(controller.getPath());
                    }
                    case JFileChooser.CANCEL_OPTION -> {}
                    default -> {
                        JOptionPane.showMessageDialog(frame, "An error has occured..", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser();
    }
}
