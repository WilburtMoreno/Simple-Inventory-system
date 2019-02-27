/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_frames;

import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import java.util.ArrayList;

public class mainPage extends javax.swing.JFrame {
      public static  int x  = 1;
      DefaultTableModel productModel;
    public mainPage() {
        initComponents();
        show_products_in_jtable();   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        product_table = new javax.swing.JTable();
        option_panel = new javax.swing.JPanel();
        addRows_btn = new javax.swing.JButton();
        logOut_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();
        title_panel = new javax.swing.JPanel();
        minimizeButton = new javax.swing.JPanel();
        __lbl = new javax.swing.JLabel();
        extiButton = new javax.swing.JPanel();
        X_lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(850, 550));

        product_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Product Code", "Quantity", "Price", "***"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        product_table.setRequestFocusEnabled(false);
        jScrollPane1.setViewportView(product_table);
        if (product_table.getColumnModel().getColumnCount() > 0) {
            product_table.getColumnModel().getColumn(3).setMinWidth(100);
            product_table.getColumnModel().getColumn(3).setMaxWidth(100);
            product_table.getColumnModel().getColumn(4).setMinWidth(30);
            product_table.getColumnModel().getColumn(4).setMaxWidth(30);
        }

        option_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addRows_btn.setText("Create data");
        addRows_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRows_btnActionPerformed(evt);
            }
        });
        option_panel.add(addRows_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        logOut_btn.setText("Log Out");
        logOut_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOut_btnActionPerformed(evt);
            }
        });
        option_panel.add(logOut_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        delete_btn.setText("Delete data");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        option_panel.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
            }
        });
        option_panel.add(refresh_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 90, -1));

        title_panel.setBackground(new java.awt.Color(153, 153, 153));
        title_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        minimizeButton.setBackground(new java.awt.Color(0, 102, 102));
        minimizeButton.setLayout(new java.awt.BorderLayout());

        __lbl.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        __lbl.setText(" __");
        minimizeButton.add(__lbl, java.awt.BorderLayout.CENTER);

        title_panel.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 40, 35));

        extiButton.setPreferredSize(new java.awt.Dimension(40, 35));
        extiButton.setLayout(new java.awt.BorderLayout());

        X_lbl.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        X_lbl.setText("  x");
        extiButton.add(X_lbl, java.awt.BorderLayout.CENTER);

        title_panel.add(extiButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, 40, 35));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(option_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(title_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(title_panel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(option_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addRows_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRows_btnActionPerformed
       create_form createForm;
       createForm = new create_form();
       createForm.setVisible(true);
       System.out.println("input registered");
    }//GEN-LAST:event_addRows_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        deleteRows();
    }//GEN-LAST:event_delete_btnActionPerformed

    private void logOut_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOut_btnActionPerformed
//logOut_btn performs showConfirmDialog for confirmation and proceed to lon_in_frame.java
        if(JOptionPane.showConfirmDialog(null, "Log Out?", "Are you sure?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            dispose();
            new log_in_frame().setVisible(true);
        }else;
    }//GEN-LAST:event_logOut_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
      
        show_products_in_jtable();
    }//GEN-LAST:event_refresh_btnActionPerformed
   //a method that turning the 4th collumn into a button
    public void getButtonColumn() {
       product_table.getColumnModel().getColumn(4).setCellRenderer(new columnButton());
       product_table.getColumnModel().getColumn(4).setCellEditor(new editorButton(new JTextField()));
   }
    public ArrayList<product> getProductList() {
        ArrayList<product> productList = new ArrayList<product>();
        Connection conn = new mysqlConnection().getConnection();
        String query = "SELECT * FROM product";
        ResultSet rs;
        Statement st;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            product prdct;
            while(rs.next()) {
                prdct = new product(rs.getString("id"), rs.getString("pName"), rs.getInt("pCode"), rs.getInt("pQuantity"), Float.parseFloat(rs.getString("pPrice")), rs.getBytes("pImage"));
                productList.add(prdct);
            }
        }catch(Exception e ) {System.out.println("mainPage Line: 181 getP error: " + e);}
        return productList;
    }
    public void show_products_in_jtable() {
        ArrayList<product> list = getProductList();
        productModel =(DefaultTableModel)product_table.getModel();
        productModel.setRowCount(0);
        Object[] row = new Object[4];
        for(int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getName();
            row[1] = list.get(i).getCode();
            row[2] = list.get(i).getQuantity();
            row[3] = list.get(i).getPrice();
            productModel.addRow(row);
            getButtonColumn();
         }
    }
    //Delete a row with warning showMessageDialog.
    public void deleteRows() {
     int rowFocus = product_table.getSelectedRow();
     if(rowFocus == -1) {
           JOptionPane.showMessageDialog(null, "Select a row to delete");
     }
     else if(JOptionPane.showConfirmDialog(null, "Delete Row?", "Are you sure?" ,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
         productModel.removeRow(rowFocus);
      } else;
    }
    public void addRow(String productN, int productC, int quantity, int price, Object b){}
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainPage().setVisible(true);
            }
        });
    }
//PopUp option column
    class editorButton extends DefaultCellEditor { 
    protected JButton btn;  
    private String lbl;
    private boolean clicked;
    private JMenuItem popUpEdit;
    private JMenuItem popUpCreate;
    private JMenuItem popUpDelete;
    private JPopupMenu rowMenuB;
    public editorButton(JTextField txt) {
        super(txt);
        btn = new JButton();
        popUpEdit = new JMenuItem("Edit");
        popUpCreate = new JMenuItem("Create Row");
        popUpDelete = new JMenuItem("Delete");
        btn.setOpaque(true);
        
        btn.addMouseListener( new MouseAdapter() {
        public void mouseReleased(MouseEvent ev) {  
            rowMenuB = new JPopupMenu();
            rowMenuB.add(popUpEdit);
            rowMenuB.add(popUpCreate);
            rowMenuB.add(popUpDelete);
            rowMenuB.show(ev.getComponent(),ev.getY(),ev.getX());
        }});
       popUpEdit.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent ev) {
                int selectedRowIndex = product_table.getSelectedRow();
                String rowName = productModel.getValueAt(selectedRowIndex, 0).toString();
                String rowCode = productModel.getValueAt(selectedRowIndex, 1).toString();
                String rowQuantity = productModel.getValueAt(selectedRowIndex, 2).toString();
                String rowPrice = productModel.getValueAt(selectedRowIndex, 3).toString();
                int rowId = selectedRowIndex + 1 ;
                String idString = Integer.toString(rowId);

                new edit_form(rowName, rowCode, rowQuantity, rowPrice, idString).setVisible(true);
           }
       });
       popUpCreate.addActionListener(new ActionListener(){
           
           public void actionPerformed(ActionEvent ev) {
               new create_form().setVisible(true);
           }
       });
        popUpDelete.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ect) {
            int rowFocus = product_table.getSelectedRow();
            productModel.removeRow(rowFocus);
        }
        });
    }
    public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected, 
                                                  int row, int column) {
        lbl = (obj == null) ? "": obj.toString();
        btn.setText(lbl);
        clicked = true;
        return btn;
    }   
}
    public class columnButton extends JButton implements TableCellRenderer {
    public columnButton() { 
        setOpaque(true);
    }
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected,
                                                   boolean focus, int row, int column) {
        setText(obj == null ? "": obj.toString());
        return this;
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel X_lbl;
    private javax.swing.JLabel __lbl;
    private javax.swing.JButton addRows_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JPanel extiButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logOut_btn;
    private javax.swing.JPanel minimizeButton;
    private javax.swing.JPanel option_panel;
    public javax.swing.JTable product_table;
    public javax.swing.JButton refresh_btn;
    private javax.swing.JPanel title_panel;
    // End of variables declaration//GEN-END:variables
}
