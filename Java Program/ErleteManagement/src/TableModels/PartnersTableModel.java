/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import cntr.Model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pkg1.Partner;

/**
 *
 * @author hayar.abderrafia
 */
public class PartnersTableModel extends AbstractTableModel{
    private final String[] rows={"ID","DNI","Name","Surname","Active"};
    private ArrayList<Partner> Partners=new ArrayList<>();        
    public PartnersTableModel() {
        Partners = Model.showPartners();
    }
    
    /**
     * This method returns how much columns there are going to be in the TableModel
     * @return 
     */
    @Override
    public int getColumnCount() {
        return rows.length;
    }

    /**
     * This method gets the column names
     * @param col. This is the parameter which gives a number for each column
     * @return 
     */
    @Override
    public String getColumnName(int col) {
        return rows[col];
    }

    /**
     * This method returns the rows that will have the TableModel
     * @return 
     */
    @Override
    public int getRowCount() {
        return Partners.size();
    }
    
    /**
     * This method writes the data into the TableModel
     * @param row. This parameter says in which row is going to write
     * @param col. This parameter says in which column is going to write
     * @return 
     */
    @Override
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return row+1;
            case 1:
                return Partners.get(row).getDNI();
            case 2:
                return Partners.get(row).getName();
            case 3:
                return Partners.get(row).getSurname();
            case 4:
                return Partners.get(row).isActive();      
        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int colIndex) {

        return getValueAt(0, colIndex).getClass();

    }
}
