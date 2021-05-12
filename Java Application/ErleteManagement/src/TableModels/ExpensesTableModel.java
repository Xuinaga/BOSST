/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModels;

import cntr.Model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pkg1.Expense;

/**
 *This class saves the information which you want to save in the AbstractTableModel 
 * @author hayar.abderrafia
 */
public class ExpensesTableModel extends AbstractTableModel{
    private final String[] rows={"Expense id","Description","Price","Type"};
    private ArrayList <Expense> Expenses=new ArrayList<>();
    
    /**
     * This method calls other method which returns an full ArrayList and saves it in another 
     */
    public ExpensesTableModel() {
        Expenses = Model.showExpense();
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
        return Expenses.size();
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
                return Expenses.get(row).getId();

            case 1:
                return Expenses.get(row).getDescription();

            case 2:
                return Expenses.get(row).getPrice();
            case 3:
                return Expenses.get(row).getType();

        }
        return null;
    }
    @Override
    public Class<?> getColumnClass(int colIndex) {

        return getValueAt(0, colIndex).getClass();

    }
}
