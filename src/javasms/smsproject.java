  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasms;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class smsproject extends javax.swing.JFrame {

    private String port;
    private String server;

    /**
     * Creates new form smsproject
     */
    public smsproject() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        l1 = new javax.swing.JLabel();
        apikey = new javax.swing.JTextField();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        t2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        message1 = new javax.swing.JTextArea();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        l4 = new javax.swing.JLabel();
        t4 = new javax.swing.JTextField();
        b3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l1.setForeground(new java.awt.Color(153, 153, 153));
        l1.setText("API Key");
        jPanel1.add(l1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 101, 20));
        jPanel1.add(apikey, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 203, -1));

        l2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l2.setForeground(new java.awt.Color(153, 153, 153));
        l2.setText("Mobile No.");
        jPanel1.add(l2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 80, 20));

        l3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l3.setForeground(new java.awt.Color(153, 153, 153));
        l3.setText("Message");
        jPanel1.add(l3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 80, 20));
        jPanel1.add(t2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 203, -1));

        message1.setColumns(20);
        message1.setRows(5);
        jScrollPane1.setViewportView(message1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 200, 100));

        b1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        b1.setText("Send");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel1.add(b1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 90, 30));

        b2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        b2.setText("Generate OTP");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        jPanel1.add(b2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, -1, 30));

        l4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        l4.setForeground(new java.awt.Color(153, 153, 153));
        l4.setText("Sender");
        jPanel1.add(l4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 80, 20));
        jPanel1.add(t4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 203, -1));

        b3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        b3.setText("Clear Text");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel1.add(b3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javasms/bc1.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        try {
            // Construct data
            String apiKey = "apikey=" + apikey.getText();
            String message = "&message=" + message1.getText();
            String sender = "&sender=" + t4.getText();
            String numbers = "&numbers=" + t2.getText();

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + message + sender +  numbers;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
               // stringBuffer.append(line);
                JOptionPane.showMessageDialog(null, "message sent");
            }
            rd.close();
            

        } catch (Exception e) {
            System.out.println("Error SMS " + e);

        }

    }//GEN-LAST:event_b1ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        apikey.setText("");
        t2.setText("");
        message1.setText("");
        t4.setText("");

    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        int refs = 99999 + (int) (Math.random() * 99999);
        message1.setText("Your One Time Password is " + refs);
        b2.setVisible(true);
    }//GEN-LAST:event_b2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(smsproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(smsproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(smsproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(smsproject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new smsproject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField apikey;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JTextArea message1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t4;
    // End of variables declaration//GEN-END:variables
}
