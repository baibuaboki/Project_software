package guicamrent;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class RoundButton_Grey extends JButton {

    private final Color fillNormal = new Color(189, 189, 189);
    private final Color fillHover = new Color(158, 158, 158);
    private final Color fillPressed = new Color(117, 117, 117);
    private final Color lineColor = new Color(220, 220, 220);

    private Color fill = fillNormal;
    private boolean hovering;

    public RoundButton_Grey() {
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setForeground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
                fill = fillHover;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
                fill = fillNormal;
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                fill = fillPressed;
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                fill = hovering ? fillHover : fillNormal;
                repaint();
            }
        });
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

            g2.setColor(fill);
            g2.fillRoundRect(stroke, stroke, w, h, h, h);

            g2.setStroke(new BasicStroke(stroke));
            g2.setColor(lineColor);
            g2.drawRoundRect(stroke, stroke, w, h, h, h);
        } finally {
            g2.dispose();
        }

        super.paintComponent(g);
    }
}