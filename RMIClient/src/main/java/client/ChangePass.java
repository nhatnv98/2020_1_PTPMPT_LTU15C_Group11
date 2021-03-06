/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.swing.*;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author HK
 */
public class ChangePass extends javax.swing.JFrame {

    private RMIClient client;

    public ChangePass() {
        initComponents();
        setLocationRelativeTo(null);
        client = new RMIClient();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btsave = new javax.swing.JButton();
        btBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tfpwnew = new javax.swing.JPasswordField();
        tfpwnewagain = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        tfpwolld = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nhập mật cũ.: ");

        btsave.setText("Thay đổi.");
        btsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsaveActionPerformed(evt);
            }
        });

        btBack.setText("Trở về.");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });
        // change pass
        jLabel2.setText("Nhập lại mật khẩu. : ");

        jLabel3.setText("Nhập mật khẩu mới .: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btBack, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                                .addComponent(btsave)
                                                .addGap(78, 78, 78))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel1)
                                                                        .addComponent(jLabel2))
                                                                .addGap(26, 26, 26)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(tfpwnew, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                                        .addComponent(tfpwnewagain)
                                                                        .addComponent(tfpwolld, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tfpwolld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfpwnew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tfpwnewagain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btsave)
                                        .addComponent(btBack))
                                .addGap(35, 35, 35))
        );

        pack();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum.length() == 6) {
            return strNum.matches("-?\\d+(\\.\\d+)?");
        } else {
            return false;
        }
    }

    private ArrayList<String> validation(String str1, String str2, String str3) {
        ArrayList<String> error = new ArrayList<>();
        if (!isNumeric(str2) || !isNumeric(str3)) {
            error.add("Mật khẩu mới phải là số và độ dài là 6 ký tự!");
        }

        if (!str2.equals(str3)) {
            error.add("Mật khẩu không khớp!");
        } else {
            if (str2.equals(str1)) {
                error.add("Mật khẩu mới không được trùng với mật khẩu cũ!");
            }
        }

        return error;
    }

    private void reset() {
        tfpwolld.setText("");
        tfpwnew.setText("");
        tfpwnewagain.setText("");
    }

    private void btsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsaveActionPerformed
        try {
            ArrayList<String> code;
            String codeshow = "";
            code = client.getBank().changepass(Login.userInfo.get(1), tfpwolld.getText(), tfpwnewagain.getText());
            if (code.size() > 0) {
                for (int i = 0; i < code.size(); i++) {
                    codeshow = code.get(i) + "\n";
                }
                JOptionPane.showMessageDialog(null, codeshow, "Warning",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                ArrayList<String> error = validation(tfpwolld.getText(), tfpwnew.getText(), tfpwnewagain.getText());
                if (error.isEmpty()) {
                    client.getBank().changepass(Login.userInfo.get(0), tfpwolld.getText(), tfpwnew.getText());
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    reset();
                } else {
                    JOptionPane.showMessageDialog(null, error.get(0), "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }

        } catch (RemoteException ex) {
            Logger.getLogger(ChangePass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ChangePass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {
        new GUI().setVisible(true);
        dispose();
    }


    private javax.swing.JButton btBack;
    private javax.swing.JButton btsave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField tfpwnew;
    private javax.swing.JPasswordField tfpwnewagain;
    private javax.swing.JPasswordField tfpwolld;

}
