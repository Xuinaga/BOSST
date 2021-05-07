/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *
 * @author hayar.abderrafia
 */
public class PartnershipFee {
    private String DNI;
    private int year;
    private boolean fee_charged;

    public PartnershipFee(String DNI, int year, boolean fee_charged) {
        this.DNI = DNI;
        this.year = year;
        this.fee_charged = fee_charged;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFee_charged() {
        return fee_charged;
    }

    public void setFee_charged(boolean fee_charged) {
        this.fee_charged = fee_charged;
    }

    @Override
    public String toString() {
        return "PartnershipFee{" + "DNI=" + DNI + ", year=" + year + ", fee_charged=" + fee_charged + '}';
    }
    
    
   
}
