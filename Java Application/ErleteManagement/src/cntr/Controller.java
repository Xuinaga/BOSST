/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package cntr;

import TableModels.ExpensesTableModel;
import TableModels.PartnershipFeeTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pkg1.Expense;
import pkg1.PartnershipFee;
import pkg1.ProductionFee;

/**
 * This class is going to control the buttons and frames 
 * @author hayar.abderrafia
 */

public class Controller implements ActionListener {

    private ArrayList<Expense> Expenses = new ArrayList<>();
    private ArrayList<PartnershipFee> PartnershipFee = new ArrayList<>();
    private ArrayList<ProductionFee> ProductionFee = new ArrayList<>();
    private Model model;
    private Menu menu;
    private Members members = new Members();

    public Controller(Model model, Menu menu) {
        this.model = model;
        this.menu = menu;
        anadirActionListener(this);
        actualizar();

    }
    /**
     * 
     * @param listener . This is the listener of the application
     */

    private void anadirActionListener(ActionListener listener) {
        //GUIaren konponente guztiei gehitu listenerra
//        members.jButtonExpense.addActionListener(listener);
        members.jButtonCharge.addActionListener(listener);
        members.jButtonUnsuscribe.addActionListener(listener);
        members.jButtonReturn.addActionListener(listener);
        menu.jButtonMembers.addActionListener(listener);
    }

    /**
     * 
     * @param e. This is the one which control the button options 
     */
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
                    actualizar();
                } catch (Exception z) {

                    JOptionPane.showMessageDialog(null, "You have to select one", "Error", JOptionPane.ERROR_MESSAGE);
                }
//                
                break;

            case "Unsuscribe":
                try {
                String dni = members.jTableMembers.getValueAt(members.jTableMembers.getSelectedRow(), 0) + "";
                System.out.println(dni);
                Model.unsuscribe(dni);
                actualizar();

            } catch (Exception z) {

                JOptionPane.showMessageDialog(null, "You have to select one", "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;

            case "Return":
                this.members.setVisible(false);
                menu.setVisible(true);
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


    
   /**
    * This method updates the current table
    */
   public void actualizar() {
        members.modelo = new PartnershipFeeTableModel();
        members.jTableMembers.setModel(members.modelo);
    }

}
