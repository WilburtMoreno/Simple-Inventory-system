package inventory_frames;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.*;

class buttonColumn extends JFrame { 
    public buttonColumn() {
        //Column names
        String columnHeader[] = {"Position","Team","Last Year Won","Trophies"};
        //row information
          Object[][] data =  {
            {"1","Man Utd",new Integer(2013), " 21"},
            {"2","Mss",new Integer(2002), " 2"},
            {"3","fds",new Integer(2003), " 31"},
            {"4","Man ",new Integer(2012), " 1"}  
        };
        JTable table = new JTable(data, columnHeader);
        //set custom renderer to teams column
        table.getColumnModel().getColumn(1).setCellRenderer(new buttonRenderer());
        //set custom editor to teams column
        table.getColumnModel().getColumn(1).setCellEditor(new buttonEditor(new JTextField()));
        JScrollPane pane = new JScrollPane(table);
        getContentPane().add(pane);
        setSize(450,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String [] args) {
        buttonColumn bc = new buttonColumn();
        bc.setVisible(true);
    }
}

public class buttonRenderer extends JButton implements TableCellRenderer {
    public buttonRenderer() {
        //set button priorities
        setOpaque(true);
    }
    public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected,
            boolean focus, int row, int column) {
        //set passed object as button text
        setText((obj==null) ? "":obj.toString());
        return this;
        }
    }
//button editor class
class buttonEditor extends DefaultCellEditor {
    protected JButton btn;
    private String lbl;
    private Boolean clicked;
    
    public buttonEditor(JTextField txt) {
        super(txt);
        
        btn = new JButton();
        btn.setOpaque(true);
        // when a button is clicked 
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }
    //overrided method
    public Component getTableCellEditorComponent(JTable table, Object obj, boolean selected,
            int row, int col) {
        //checks if obj is null before converting to string
        lbl = (obj == null) ? "": obj.toString();
        btn.setText(lbl);
        clicked = true;
        return btn;
    }
    //if button cell value changes, if clicked that is
    public Object getCellEditorValue() {
        if(clicked) { 
        JOptionPane.showMessageDialog(btn, lbl + " Clicked" );
    }
        //set it to false now that its clicked
        clicked= false;
        return new String(lbl);
    }
    public boolean stopCellEditing() {
        //set clicked to false first
        clicked = false;
        return super.stopCellEditing();   
    }
    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}
