package no_hover버튼;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Disable Hover Effect Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        JPanel panel = new JPanel();
        JButton button = new JButton("No Hover Effect");
        button.setUI(new NoHoverButtonUI());
        button.setBackground(Color.CYAN);
        button.setPreferredSize(new Dimension(200, 50));
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }
}
