package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final JFrame frame = new JFrame();
    private final int PROPORTION = 5;

    public SimpleGUI() {
        final Controller controller = new SimpleController();
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JTextField upper = new JTextField();
        final JTextArea text = new JTextArea();
        text.setEditable(false);
        final JPanel buttons = new JPanel();
        buttons.setLayout(new FlowLayout());
        final JButton print = new JButton("Print");
        final JButton history = new JButton("Show History");
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.setString(upper.getText());
                controller.print();
            }
        });
        history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(null);
                for (final String msg : controller.getHistory()) {
                    text.append(msg + "\n");
                }
            }
        });
        buttons.add(print);
        buttons.add(history);
        panel.add(upper, BorderLayout.NORTH);
        panel.add(text, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        frame.add(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        display();
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }
}
