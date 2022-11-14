package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JPanel upperpanel = new JPanel();
        upperpanel.setLayout(new BorderLayout());
        final JTextArea filepath = new JTextArea();
        filepath.setEditable(false);
        filepath.setText(Controller.DEFAULT_PATH);
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
                final Controller controller = new Controller();
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
                final Controller controller = new Controller();
                final JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Select a file");
                switch (chooser.showSaveDialog(frame)) {
                    case JFileChooser.APPROVE_OPTION -> {
                        //controller.setFile();
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
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser();
    }
}
