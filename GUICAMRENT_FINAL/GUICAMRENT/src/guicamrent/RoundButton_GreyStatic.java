package guicamrent;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;

public class RoundButton_GreyStatic extends JButton {

    private Color fillColor = new Color(189, 189, 189);
    private Color lineColor = new Color(220, 220, 220);

    public RoundButton_GreyStatic() {
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setForeground(Color.BLACK);
        setFocusable(false);
        setEnabled(false); 

        getModel().setRollover(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            int stroke = 1;
            int w = getWidth() - stroke * 2;
            int h = getHeight() - stroke * 2;

            g2.setColor(fillColor);
            g2.fillRoundRect(stroke, stroke, w, h, h, h);

            g2.setColor(lineColor);
            g2.drawRoundRect(stroke, stroke, w, h, h, h);
        } finally {
            g2.dispose();
        }

        super.paintComponent(g);
    }
}