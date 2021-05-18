/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import java.util.Date;

/**
 * This class which saves the info of the room and the extraction that each partner booked
 * @author hayar.abderrafia
 */
public class RoomBooking {
    private int id_booking;
    private String partner_DNI;
    private Date Date ; 
    private int extracted_quantity;

    /**
     * This is the class constructor
     * @param id_booking This parameter saves the id of the booking which is created automatically when you book a room
     * @param partner_DNI This parameter saves the DNI of the partner that booked the room
     * @param date This parameter saves the date of the booking 
     * @param extracted_quantity This parameter saves the extracted quantity of honey
     */
    public RoomBooking(int id_booking, String partner_DNI, Date date, int extracted_quantity) {
        this.id_booking = id_booking;
        this.partner_DNI = partner_DNI;
        this.Date = date;
        this.extracted_quantity = extracted_quantity;
    }

    /**
     * This is the getter of the id_booking
     * @return Returns the id of the booking
     */
    public int getId_booking() {
        return id_booking;
    }

    /**
     * This is the id_booking setter
     * @param id_booking This parameter saves the id_booking number
     */
    public void setId_booking(int id_booking) {
        this.id_booking = id_booking;
    }

    /**
     * This is the getter of the DNI of the partner
     * @return Returns the DNI of the partner
     */
    public String getPartner_DNI() {
        return partner_DNI;
    }

    /**
     * This is the setter of the DNI of the partner
     * @param partner_DNI This parameter saves the DNI of the partner
     */
    public void setPartner_DNI(String partner_DNI) {
        this.partner_DNI = partner_DNI;
    }

    /**
     * This is the date getter
     * @return Returns the date of the booking (yyyy/mm/dd)
     */
    public Date getDate() {
        return Date;
    }

    /**
     * This is the date setter
     * @param date This parameter saves the date of the booking
     */
    public void setDate(Date date) {
        this.Date = date;
    }

    /**
     * This is the getter of the extracted quantity
     * @return Returns the quantity of honey extracted
     */
    public int getExtracted_quantity() {
        return extracted_quantity;
    }

    /**
     * This is the setter of the extracted quantity
     * @param extracted_quantity This parameter saves the quantity of the honey extracted
     */
    public void setExtracted_quantity(int extracted_quantity) {
        this.extracted_quantity = extracted_quantity;
    }

    
}
