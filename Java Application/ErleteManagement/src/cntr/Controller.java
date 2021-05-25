/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cntr;

import TableModels.ExpensesTableModel;
import TableModels.PartnersTableModel;
import TableModels.PartnershipFeeTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import pkg1.Expense;
import pkg1.Partner;
import pkg1.PartnershipFee;
import pkg1.ProductionFee;

/**
 * This class is going to control the buttons and frames
 * 
 * @author hayar.abderrafia
 */
public class Controller implements ActionListener {

    private ArrayList<Expense> Expenses = new ArrayList<>();
    private ArrayList<PartnershipFee> PartnershipFee = new ArrayList<>();
    private ArrayList<ProductionFee> ProductionFee = new ArrayList<>();
    private Model model;
    private Menu menu;
    private Partnership_Fee partnershipFee = new Partnership_Fee();
    private Expenses expenses = new Expenses();
    private NewExpense newExpense = new NewExpense();
    private MonthFee monthFee = new MonthFee();
    private Partners partners= new Partners();

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
//        
        partnershipFee.jButtonCharge.addActionListener(listener);
        partnershipFee.jButtonUnsuscribe.addActionListener(listener);
        partnershipFee.jButtonReturn.addActionListener(listener);
        menu.jButtonMembers.addActionListener(listener);
        menu.jButtonExpenses.addActionListener(listener);
        expenses.jButtonNewExpense.addActionListener(listener);
        expenses.jButtonBackE.addActionListener(listener);
        newExpense.jButtonInsert.addActionListener(listener);
        newExpense.jButtonBack.addActionListener(listener);
        menu.jButtonMonthFee.addActionListener(listener);
        monthFee.jButtonSee.addActionListener(listener);
        monthFee.jComboBoxDNI.addActionListener(listener);
        monthFee.jComboBoxMonth.addActionListener(listener);
        monthFee.jButtonChargeFee.addActionListener(listener);
        monthFee.jComboBoxYears.addActionListener(listener);
        monthFee.jButtonBackE.addActionListener(listener);
        partners.jButtonReturn.addActionListener(listener);
        partners.jButtonUnsuscribe.addActionListener(listener);
       
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
                    String dni = partnershipFee.jTableMembers.getValueAt(partnershipFee.jTableMembers.getSelectedRow(), 0) + "";
                    System.out.println(dni);
                    Model.payPartnershipFee(dni);
                    actualizar();
                } catch (Exception z) {

                    JOptionPane.showMessageDialog(null, "You have to select one", "Error", JOptionPane.ERROR_MESSAGE);
                }
//                
                break;

            case "Unsuscribe":
                this.partnershipFee.setVisible(false);
                partners.setVisible(true);

            break;
            case "Unsus":
                try {
                String DNI = partners.jTablePartners.getValueAt(partners.jTablePartners.getSelectedRow(), 1) + "";
                 
                System.out.println(DNI);
                int aukera=JOptionPane.showConfirmDialog(null, "Are you sure you want to unsuscribe this partner? \n DNI: "+DNI,
                "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
                if (aukera==0){
                    Model.unsuscribe(DNI);
                actualizar();
                JOptionPane.showMessageDialog(null, "Unsuscribed succesfully");
                }else{
                    JOptionPane.showMessageDialog(null, "No member have been unsuscribed");
                }
                

            } catch (Exception z) {

                JOptionPane.showMessageDialog(null, "You have to select one", "Error", JOptionPane.ERROR_MESSAGE);
            }
            break;

            case "Return":
                this.partnershipFee.setVisible(false);
                menu.setVisible(true);
                break;
            case "ReturnPS":
                this.partners.setVisible(false);
                partnershipFee.setVisible(true);
                break;

            case "Members":
                System.out.println("Boton members (menu)");
                partnershipFee.setVisible(true);
                this.menu.setVisible(false);

                break;
            case "Expenses":
                System.out.println("Boton expenses (menu)");
                expenses.setVisible(true);
                this.menu.setVisible(false);
                
                break;
            case "NewExpense":
                System.out.println("Boton newExpense (expenses)");
                newExpense.setVisible(true);
                this.expenses.setVisible(false);

                break;
            case "Insert":
                System.out.println("Boton Insert (newExpense)");
                Expense newexpense = new Expense(newExpense.jTextAreaDescription.getText(), Float.parseFloat(newExpense.jTextFieldPrice.getText()), newExpense.jComboBoxType.getSelectedItem().toString());
                Model.addExpense(newexpense);
                JOptionPane.showMessageDialog(null, "Added succesfully ");
                actualizar();
                newExpense.setVisible(false);
                expenses.setVisible(true);

                break;
            case "Back":
                this.newExpense.setVisible(false);
                expenses.setVisible(true);
                break;
            case "BackE":
                this.expenses.setVisible(false);
                menu.setVisible(true);
                break;
            case "BackF":
                monthFee.setVisible(false);
                menu.setVisible(true);
                break;
            case "productionFee":
                this.menu.setVisible(false);
                monthFee.setVisible(true);


                break;
            case "comboBoxChangedMonth":
                int mnth=calculateInt(monthFee.jComboBoxMonth.getSelectedItem().toString());
                ArrayList<Date> d = Model.showDate(mnth);
                ArrayList<String> years = new ArrayList<String>();
                String tmp = monthFee.jComboBoxYears.getItemAt(0);
                monthFee.jComboBoxYears.removeAllItems();
                monthFee.jComboBoxYears.addItem(tmp);
                
                String sas = monthFee.jComboBoxDNI.getItemAt(0);
                monthFee.jComboBoxDNI.removeAllItems();
                monthFee.jComboBoxDNI.addItem(sas);
                
                
      
                monthFee.jLabelName.setText("");
                monthFee.jLabelTotal.setText("");
                for (Date ds : d) {

                    String yeara = ds.toString();
                    String y[] = yeara.split("-");
                    years.add(y[0]);

                }
                Set<String> hashSet = new HashSet<String>(years);
                years.clear();
                years.addAll(hashSet);

                for (String s : years) {
                    monthFee.jComboBoxYears.addItem(s);
                }
                
                break;
            
            case "comboBoxChangedYears":
                monthFee.jLabelTotal.setText("");
                monthFee.jLabelName.setText("");
                String saas = monthFee.jComboBoxDNI.getItemAt(0);
                monthFee.jComboBoxDNI.removeAllItems();
                monthFee.jComboBoxDNI.addItem(saas);
                try {
                    int mes =calculateInt(monthFee.jComboBoxMonth.getSelectedItem().toString());
                int año =Integer.parseInt(monthFee.jComboBoxYears.getSelectedItem().toString());
                System.out.println(mes);
                ArrayList<String> DNIs=Model.showDNIMonth(mes,año);
                
                for(String dnis :DNIs){
                    monthFee.jComboBoxDNI.addItem(dnis);
                }
                } catch (Exception as) {
                }
                
             
                break;
            case "comboBoxChanged":
                try {
                ArrayList<Partner> p=Model.showPartnerPR();
                for (Partner part : p) {
                    if(monthFee.jComboBoxDNI.getSelectedItem().toString().equals(part.getDNI()))
                    monthFee.jLabelName.setText(part.getName()+" "+part.getSurname());
                }
                monthFee.jLabelTotal.setText("");
            } catch (Exception asd) {
            }
                

                break;
             
            case "Calculate":
                try {
                String p_dni = monthFee.jComboBoxDNI.getSelectedItem().toString();
                String month="";
            month = monthFee.jComboBoxMonth.getSelectedItem().toString();
                String year = monthFee.jComboBoxYears.getSelectedItem().toString();
                int yearInt = Integer.parseInt(year);
                int monthInt = calculateInt(month);
                System.out.println(monthInt);
                double total = 0;
                ArrayList<Integer> quantity = Model.showPartnerMonthFee(p_dni, monthInt, yearInt);
                System.out.println(quantity);
                for (int q : quantity) {
                    total = total + q;
                }
                total = total * 0.25;

                monthFee.jLabelTotal.setText(total + " €");

            } catch (NumberFormatException asde) {
                JOptionPane.showMessageDialog(null, "There is nothing selected", "Error", JOptionPane.ERROR_MESSAGE);
            }
                
                break;

            
            case "Charge":
                try {
                 String[] tot;
                tot = monthFee.jLabelTotal.getText().split(" ");
                ProductionFee prod = new ProductionFee(monthFee.jComboBoxDNI.getSelectedItem().toString(), monthFee.jComboBoxMonth.getSelectedItem().toString(), Integer.parseInt(monthFee.jComboBoxYears.getSelectedItem().toString()), Float.parseFloat(tot[0]));
               
          
                if (Model.addProductionFee(prod)==1062){
                    JOptionPane.showMessageDialog(null, "This is already charged",
                        "Hey!", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Charged succesfully");
                }
                
            } catch (Exception ae) {
                JOptionPane.showMessageDialog(null, "First you have to calculate the fee", "Error", JOptionPane.ERROR_MESSAGE);
            }
                


            break;

            default:
                System.out.println("???");

        }
    }

    /**
     * This method updates the current table
     */
    public void actualizar() {
        partnershipFee.modelo = new PartnershipFeeTableModel();
        expenses.jTableExpenses.setModel(new ExpensesTableModel());
        partnershipFee.jTableMembers.setModel(partnershipFee.modelo);
        partners.jTablePartners.setModel(new PartnersTableModel());
        
    }

    public int calculateInt(String month) {
        int monthInt = 0;
        switch (month) {
            case "January":
                monthInt = 1;
                break;
            case "February":
                monthInt = 2;
                break;
            case "March":
                monthInt = 3;
                break;
            case "April":
                monthInt = 4;
                break;
            case "May":
                monthInt = 5;
                break;
            case "June":
                monthInt = 6;
                break;
            case "July":
                monthInt = 7;
                break;
            case "August":
                monthInt = 8;
                break;
            case "September":
                monthInt = 9;
                break;
            case "October":
                monthInt = 10;
                break;
            case "November":
                monthInt = 11;
                break;
            case "December":
                monthInt = 12;
                break;
            default:
                break;

        }
        return monthInt;
    }

}
