package proyectoclinica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 * @author CHENAO GitHub
 *
 */
public class HeaderTable  implements TableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        
        JComponent jcomponent = null;
        
        if( value instanceof String ) {
            jcomponent = new JLabel((String) value);
            ((JLabel)jcomponent).setHorizontalAlignment( SwingConstants.CENTER );
            ((JLabel)jcomponent).setSize( 22, jcomponent.getWidth() );   
            ((JLabel)jcomponent).setPreferredSize( new Dimension(6, jcomponent.getWidth())  );
        }         
   
        //jcomponent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(221, 211, 211)));
        jcomponent.setBorder(javax.swing.BorderFactory.createEmptyBorder()); //sin bordes en el encabezado
        jcomponent.setOpaque(true);
        jcomponent.setBackground( new Color(204,204,255) );
//        jcomponent.setBackground( new Color(51,51,51) );
//        jcomponent.setToolTipText("Tabla Seguimiento");
        jcomponent.setForeground(new Color(51,51,51));
//        jcomponent.setForeground(new Color(0,153,0));
        jcomponent.setFont(new Font("Dialog", Font.BOLD, 11));
        
        return jcomponent;
    }


}
