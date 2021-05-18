/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import cntr.Model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pkg1.PartnershipFee;

/**
 *This class saves the information which you want to save in the AbstractTableModel 
 * @author hayar.abderrafia
 */
public class PartnershipFeeTableModel extends AbstractTableModel{
    private final String[] rows={"Partnership DNI","Year","Fee charged"};
    private ArrayList<PartnershipFee> PartnershipFee=new ArrayList<>();
    
    /**
     * This method calls other method which returns an full ArrayList and saves it in another 
     */
    public PartnershipFeeTableModel() {
        PartnershipFee = Model.showPartnershipFee();
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
        return PartnershipFee.size();
    }

    /**
     * This method writes the data into the TableModel
     * @param row. This parameter says in which row is going to write
     * @param col. This parameter says in which column is going to write
     * @return 
     */
    public Object getValueAt(int row, int col) {

        switch (col) {
            case 0:
                return PartnershipFee.get(row).getDNI();

            case 1:
                return PartnershipFee.get(row).getYear();

            case 2:
                return PartnershipFee.get(row).isFee_charged();
            

        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int colIndex) {

        return getValueAt(0, colIndex).getClass();

    }
}
