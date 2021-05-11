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
 *
 * @author hayar.abderrafia
 */
public class PartnershipFeeTableModel extends AbstractTableModel{
    private final String[] rows={"Partnership DNI","Year","Fee charged"};
    private ArrayList<PartnershipFee> PartnershipFee=new ArrayList<>();

    public PartnershipFeeTableModel() {
        PartnershipFee = Model.showPartnershipFee();
    }
    
    @Override
    public int getColumnCount() {
        return rows.length;
    }
    
    @Override
    public String getColumnName(int col) {
        return rows[col];
    }
    
    @Override
    public int getRowCount() {
        return PartnershipFee.size();
    }


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
