/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_frames;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LaptopKo
 */
public class edit_form extends javax.swing.JFrame {

    private String pId;
    private String pName;
    private String pCode;
    private String pQuantity;
    private String pPrice;
    public edit_form() {
        initComponents();    
    }
    public edit_form(String name, String code, String quantity, String price, String id) {
        initComponents();
        pName = name;
        pCode = code;
        pQuantity = quantity;
        pPrice = price;
        pId = id;
        getEdit();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        edit_btn = new javax.swing.JButton();
        cancel_btn = new javax.swing.JButton();
        name_field = new javax.swing.JTextField();
        price_field = new javax.swing.JTextField();
        code_field = new javax.swing.JTextField();
        quantity_field = new javax.swing.JTextField();
        price_lbl = new javax.swing.JLabel();
        productCode_lbl = new javax.swing.JLabel();
        productName_lbl = new javax.swing.JLabel();
        quantity_lbl = new javax.swing.JLabel();
        title_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setBackground(new java.awt.Color(153, 153, 153));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit_btn.setBackground(new java.awt.Color(153, 153, 153));
        edit_btn.setForeground(new java.awt.Color(255, 255, 255));
        edit_btn.setText("Edit");
        edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        });
        MainPanel.add(edit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 180, -1, -1));

        cancel_btn.setBackground(new java.awt.Color(153, 153, 153));
        cancel_btn.setForeground(new java.awt.Color(255, 255, 255));
        cancel_btn.setText("Cancel");
        cancel_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_btnActionPerformed(evt);
            }
        });
        MainPanel.add(cancel_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, -1, -1));
        MainPanel.add(name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, -1));
        MainPanel.add(price_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, -1));
        MainPanel.add(code_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 100, -1));

        quantity_field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantity_fieldActionPerformed(evt);
            }
        });
        MainPanel.add(quantity_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 80, -1));

        price_lbl.setForeground(new java.awt.Color(255, 255, 255));
        price_lbl.setText("Price");
        MainPanel.add(price_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        productCode_lbl.setForeground(new java.awt.Color(255, 255, 255));
        productCode_lbl.setText("Product Code");
        MainPanel.add(productCode_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, -1, -1));

        productName_lbl.setForeground(new java.awt.Color(255, 255, 255));
        productName_lbl.setText("Product Name");
        MainPanel.add(productName_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        quantity_lbl.setForeground(new java.awt.Color(255, 255, 255));
        quantity_lbl.setText("Quantity");
        MainPanel.add(quantity_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        title_lbl.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        title_lbl.setForeground(new java.awt.Color(255, 255, 255));
        title_lbl.setText("Edit ");
        MainPanel.add(title_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancel_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_btnActionPerformed
        dispose();
    }//GEN-LAST:event_cancel_btnActionPerformed

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
        try {
            Connection conn = new mysqlConnection().getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET pName = ?, pCode = ?, pPrice = ?, pQuantity = ? WHERE id = ?");
            DefaultTableModel dtm = new mainPage().productModel;
            ps.setString(1, name_field.getText());
            ps.setString(2, code_field.getText());
            ps.setString(3, quantity_field.getText());
            ps.setString(4, price_field.getText());
            ps.setString(5, pId);
            ps.executeUpdate();
            dispose();
            System.out.println("ID: " + pId + "\nName: " + name_field.getText() + "\nCode: " + code_field.getText()+ "\nQuantity: " +
                                quantity_field.getText() + "\nPrice: " + price_field.getText());
        }catch(Exception e ) {System.out.println("Edit Error: " + e);}
    }//GEN-LAST:event_edit_btnActionPerformed

    private void quantity_fieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantity_fieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantity_fieldActionPerformed

    public void getEdit() {
        name_field.setText(pName);
        code_field.setText(pCode);
        quantity_field.setText(pQuantity);
        price_field.setText(pPrice);
    }
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
            java.util.logging.Logger.getLogger(edit_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(edit_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(edit_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(edit_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new edit_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton cancel_btn;
    private javax.swing.JTextField code_field;
    private javax.swing.JButton edit_btn;
    private javax.swing.JTextField name_field;
    private javax.swing.JTextField price_field;
    private javax.swing.JLabel price_lbl;
    private javax.swing.JLabel productCode_lbl;
    private javax.swing.JLabel productName_lbl;
    private javax.swing.JTextField quantity_field;
    private javax.swing.JLabel quantity_lbl;
    private javax.swing.JLabel title_lbl;
    // End of variables declaration//GEN-END:variables
}
