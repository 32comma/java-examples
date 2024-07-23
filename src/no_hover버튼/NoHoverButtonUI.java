package no_hover버튼;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class NoHoverButtonUI extends BasicButtonUI {
    @Override
    public void paint(Graphics g, JComponent c) {
        JButton button = (JButton) c;
        if (button.getModel().isPressed()) {
            g.setColor(Color.GRAY);
        } else {
            g.setColor(button.getBackground());
        }
        g.fillRect(0, 0, button.getWidth(), button.getHeight());
        super.paint(g, c);
    }
}

