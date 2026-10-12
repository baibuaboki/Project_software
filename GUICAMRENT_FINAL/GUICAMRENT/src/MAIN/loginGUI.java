package MAIN;

import guicamrent.CreateAccount;
import guicamrent.Date_Time;
import guicamrent.UserDatabase;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class loginGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(loginGUI.class.getName());

    public loginGUI() {
        initComponents();
        setResizable(true);
        getContentPane().setBackground(java.awt.Color.WHITE);
        setLocationRelativeTo(null);

        // ข้อความตัวอย่าง: ล้างเมื่อคลิก / ใส่กลับถ้าปล่อยว่าง
        Username_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (Username_TextField.getText().equals("Username")) {
                    Username_TextField.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (Username_TextField.getText().trim().isEmpty()) {
                    Username_TextField.setText("Username");
                }
            }
        });
        Password_TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (new String(Password_TextField.getPassword()).equals("Password")) {
                    Password_TextField.setText("");
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (Password_TextField.getPassword().length == 0) {
                    Password_TextField.setText("Password");
                }
            }
        });
    }

   
    public static class RoundPasswordField extends JPasswordField {
        private Shape shape;
        private int cornerRadius = 50; // ความโค้ง

        public RoundPasswordField() {
            setOpaque(false);
            // ปรับสีพื้นหลังให้เป็นสีเทาอ่อนเหมือน Username
            setBackground(new Color(238, 240, 242)); 
            // เพิ่มระยะเว้นขอบซ้าย-ขวา ด้านใน ไม่ให้ตัวอักษรชิดขอบโค้ง
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // เทสีพื้นหลังสีเทาอ่อน
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
            
            super.paintComponent(g);
            g2.dispose();
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // วาดเส้นขอบสีดำ
            g2.setColor(Color.BLACK);
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
            g2.dispose();
        }

        @Override
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
            }
            return shape.contains(x, y);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LOGO = new javax.swing.JLabel();
        SIGNUP_LABEL = new javax.swing.JLabel();
        Username_TextField = new guicamrent.RoundTextField();
        Password_TextField = new RoundPasswordField(); 
        Login_Button = new guicamrent.RoundButton();
        Username_ICON = new javax.swing.JLabel();
        Password_ICON = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        LOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIPIC/logo (344x344 px).png"))); 

        SIGNUP_LABEL.setForeground(new java.awt.Color(102, 153, 255));
        SIGNUP_LABEL.setText("Never registered yet? Sign up for free!");
        SIGNUP_LABEL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIGNUP_LABELMouseClicked(evt);
            }
        });

        Username_TextField.setText("Username");
        Username_TextField.addActionListener(this::Username_TextFieldActionPerformed);

        Password_TextField.setText("Password"); 

        Login_Button.setText("Login");
        Login_Button.addActionListener(this::Login_ButtonActionPerformed);

        Username_ICON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIPIC/login (35x35 px).png"))); 
        Username_ICON.setText("jLabel3");

        Password_ICON.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIPIC/lock (33x33px).png"))); 
        Password_ICON.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LOGO)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Password_ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Password_TextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Username_ICON, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Username_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SIGNUP_LABEL, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LOGO, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Username_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username_ICON))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Password_TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Password_ICON))
                .addGap(36, 36, 36)
                .addComponent(Login_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(SIGNUP_LABEL)
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Username_TextFieldActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void Login_ButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = Username_TextField.getText().trim();
        String password = new String(Password_TextField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()
                || username.equals("Username") || password.equals("Password")) {
            JOptionPane.showMessageDialog(this, "กรุณากรอก Username และ Password ให้ครบถ้วน", "แจ้งเตือน", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (checkLoginCredentials(username, password)) {
            setContentPane(new Date_Time());
            pack();
            setLocationRelativeTo(null);
            revalidate();
            repaint();
        } else {
            JOptionPane.showMessageDialog(this, "ยังไม่ได้สมัครสมาชิก หรือ Username / Password ไม่ถูกต้อง", "แจ้งเตือน", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void SIGNUP_LABELMouseClicked(java.awt.event.MouseEvent evt) {
        setContentPane(new CreateAccount());
        pack();
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    private boolean checkLoginCredentials(String inputUser, String inputPass) {
        return UserDatabase.checkLogin(inputUser, inputPass);
    }

    public static void main(String args[]) {
        try {
            java.awt.Font thaiFont = new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 14);
            UIManager.put("OptionPane.messageFont", thaiFont);
            UIManager.put("OptionPane.buttonFont", thaiFont);

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new loginGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOGO;
    private guicamrent.RoundButton Login_Button;
    private javax.swing.JLabel Password_ICON;
    private RoundPasswordField Password_TextField;
    private javax.swing.JLabel SIGNUP_LABEL;
    private javax.swing.JLabel Username_ICON;
    private guicamrent.RoundTextField Username_TextField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}