/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author HK
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private RMIClient client;

    public GUI() {
        initComponents();
        setLocationRelativeTo(null);
        client = new RMIClient();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btRuttien = new javax.swing.JButton();
        btChuyenkhoan = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        btChangePw = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btRuttien.setText("Rút tiền");
        btRuttien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRuttienActionPerformed(evt);
            }
        });

        btChuyenkhoan.setText("Chuyển khoản");
        btChuyenkhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btChuyenkhoanMouseClicked(evt);
            }
        });
        btChuyenkhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChuyenkhoanActionPerformed(evt);
            }
        });

        btThoat.setText(".Thoát");
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });

        btChangePw.setText("Đổi mật khẩu");
        btChangePw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangePwActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(btRuttien, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(41, 41, 41)
                                                .addComponent(btChuyenkhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(140, 140, 140)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btThoat, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                                                        .addComponent(btChangePw, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btRuttien)
                                        .addComponent(btChuyenkhoan))
                                .addGap(31, 31, 31)
                                .addComponent(btChangePw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(btThoat)
                                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRuttienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRuttienActionPerformed
        new Withdraw().setVisible(true);
        dispose();
    }//GEN-LAST:event_btRuttienActionPerformed

    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        try {
            client.getBank().changeStatus(Login.userInfo.get(0));
            System.exit(0);
        } catch (RemoteException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btThoatActionPerformed

    private void btChangePwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangePwActionPerformed
        new ChangePass().setVisible(true);
        dispose();
    }//GEN-LAST:event_btChangePwActionPerformed

    private void btChuyenkhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChuyenkhoanActionPerformed

        new Trans().setVisible(true);
        dispose();
    }//GEN-LAST:event_btChuyenkhoanActionPerformed

    private void btChuyenkhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btChuyenkhoanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btChuyenkhoanMouseClicked

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btChangePw;
    private javax.swing.JButton btChuyenkhoan;
    private javax.swing.JButton btRuttien;
    private javax.swing.JButton btThoat;
    // End of variables declaration//GEN-END:variables
}
