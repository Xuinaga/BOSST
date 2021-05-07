/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cntr;

import TableModels.ExpensesTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pkg1.Expense;
import pkg1.PartnershipFee;
import pkg1.ProductionFee;

public class Controller implements ActionListener {

    private ArrayList <Expense> Expenses=new ArrayList<>();
    private ArrayList<PartnershipFee> PartnershipFee=new ArrayList<>();
    private ArrayList<ProductionFee> ProductionFee=new ArrayList<>();
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        anadirActionListener(this);
        this.view.jTableExpenses.setModel(new ExpensesTableModel());

    }

    private void anadirActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        switch (actionCommand) {
            case "GEHITU":


            default:
                System.out.println("???");

        }
    }

   

    
   

}
