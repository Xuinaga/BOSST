/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *This class saves the partnership info and if it's paid 
 * @author hayar.abderrafia
 */
public class PartnershipFee {
    private String DNI;
    private int year;
    private boolean fee_charged;

    /**
     * This is the class constructor.
     * @param DNI. This parameter saves the partner DNI
     * @param year. This parameter saves the year of the partnership
     * @param fee_charged. This parameter saves if the fee is charged or not
     */
    public PartnershipFee(String DNI, int year, boolean fee_charged) {
        this.DNI = DNI;
        this.year = year;
        this.fee_charged = fee_charged;
    }
    
    /**
     * This is the DNI getter
     * @return Returns the DNI
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * This is the DNI setter
     * @param DNI This parameter saves the DNI
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * This is the year getter
     * @return Returns the year of the partnership
     */
    public int getYear() {
        return year;
    }

    /**
     * This is the year setter
     * @param year This parameter saves the year of the partnership
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * This is the fee_charged getter
     * @return Returns if the fee is charged or not
     */
    public boolean isFee_charged() {
        return fee_charged;
    }
    
    /**
     * This is the fee_charged setter
     * @param fee_charged This parameter saves if the fee is charged or not
     */
    public void setFee_charged(boolean fee_charged) {
        this.fee_charged = fee_charged;
    }

   
    
    
   
}
