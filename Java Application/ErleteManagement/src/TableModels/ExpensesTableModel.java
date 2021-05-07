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
 *
 * @author hayar.abderrafia
 */
public class ExpensesTableModel extends AbstractTableModel{
    private final String[] rows={"Expense id","Description","Price","Type"};
    private ArrayList <Expense> Expenses=new ArrayList<>();

    public ExpensesTableModel() {
        Expenses = Model.showExpense();
    }
    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public int getColumnCount() {
        return Expenses.size();
    }
    
    @Override
    public String getColumnName(int col) {
        return rows[col];
    }

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
