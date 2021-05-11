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
import pkg1.Expense;
import pkg1.PartnershipFee;
import pkg1.ProductionFee;

public class Controller implements ActionListener {

    private ArrayList <Expense> Expenses=new ArrayList<>();
    private ArrayList<PartnershipFee> PartnershipFee=new ArrayList<>();
    private ArrayList<ProductionFee> ProductionFee=new ArrayList<>();
    private Model model;
    private Menu menu;
    private Members members = new Members();

    public Controller(Model model, Menu menu) {
        this.model = model;
        this.menu = menu;
        anadirActionListener(this);
        

    }

    private void anadirActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
//        members.jButtonExpense.addActionListener(listener);
        members.jButtonCharge.addActionListener(listener);
       menu.jButtonMembers.addActionListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        //listenerrak entzun dezakeen eragiketa bakoitzeko. Konponenteek 'actionCommad' propietatea daukate
        switch (actionCommand) {
            case "Pay":
                System.out.println("Charge fee (members)");
                
                try {
            String dni = members.jTableMembers.getValueAt(members.jTableMembers.getSelectedRow(), 0) + "";
            System.out.println(dni);
            Model.payPartnershipFee(dni);
            
        } catch (Exception z) {

            JOptionPane.showMessageDialog(null, "Aukeratu bat, ezabatzeko", "Error", JOptionPane.WARNING_MESSAGE);
        }
//                
               break;
               
            case "Unsuscribe":
                try {
            String dni = members.jTableMembers.getValueAt(members.jTableMembers.getSelectedRow(), 0) + "";
            System.out.println(dni);
            Model.unsuscribe(dni);
            
        } catch (Exception z) {

            JOptionPane.showMessageDialog(null, "Aukeratu bat, ezabatzeko", "Error", JOptionPane.WARNING_MESSAGE);
        }
                break;
               
                case "Members":
                System.out.println("Boton members (menu)");
                members.setVisible(true);
                this.menu.setVisible(false);
                
               break;
            default:
                System.out.println("???");

        }
    }

   

    
   

}
