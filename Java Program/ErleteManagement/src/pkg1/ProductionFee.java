/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

/**
 *This is the class which saves every movement in the production and its fee
 * @author hayar.abderrafia
 */
public class ProductionFee {
    
    private String DNI;
    private String month;
    private int year;
    private float price;
    
    /**
     * This is the class constructor
     * @param DNI This parameter saves the DNI of the partner 
     * @param month This parameter saves the month of the production fee
     * @param year This parameter saves the year of the production fee
     * @param price This parameter saves the price of your production in the month
     */
    public ProductionFee(String DNI, String month, int year, float price) {
        this.DNI = DNI;
        this.month = month;
        this.year = year;
        this.price = price;
    }
    
    /**
     * This is the year getter
     * @return Returns the year of the production fee
     */
    public int getYear() {
        return year;
    }

    /**
     * This is the year setter
     * @param year This parameter saves the year 
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * This is the DNI getter
     * @return Returns the DNI of the partner 
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * This is the DNI setter
     * @param DNI This parameter saves the DNI that you want to set
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * This is the price getter
     * @return Returns the price of the fee in a determined month
     */
    public float getPrice() {
        return price;
    }

    /**
     * This is the price setter
     * @param price This parameter saves the price of the fee
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    /**
     * This is the month getter
     * @return Returns the month of the production fee
     */
    public String getMonth() {
        return month;
    }

    /**
     * This is the month setter
     * @param month This parameter saves the month of the production fee
     */
    public void setMonth(String month) {
        this.month = month;
    }


    
    
}
