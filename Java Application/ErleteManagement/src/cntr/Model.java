/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cntr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import pkg1.Expense;
import pkg1.Partner;
import pkg1.PartnershipFee;
import pkg1.ProductionFee;
import pkg1.RoomBooking;

/**
 * This is the class which has every method
 *
 * @author hayar.abderrafia. This class is where all principal methods are
 * located
 */
public class Model {

    /**
     * This method connects the program to the data base
     *
     * @return
     */
    private static Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
//            conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/erlete_db", "abde", "abde");
            conn = DriverManager.getConnection("jdbc:mariadb://192.168.65.222:3306/erlete_db", "dios", "dios");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }

    /**
     * This method adds an Expense to the Expense table
     *
     * @param ex . This parameter gives the information to add in our data base
     * @return 
     */
    public static int addExpense(Expense ex) {
        String sql = "INSERT INTO Expense(description,price,expense_type) VALUES(?,?,?)";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, ex.getDescription());
            pstmt.setFloat(2, ex.getPrice());
            pstmt.setString(3, ex.getType());

            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    /**
     * This method selects all the data from the table and saves it in an
     * ArrayList
     *
     * @return
     */
    public static ArrayList<Expense> showExpense() {
        int contEx=0;
        ArrayList<Expense> Expenses = new ArrayList<>();
        String taula = "Expense";
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Expense e = new Expense(rs.getInt("id_expense"), rs.getString("description"), rs.getFloat("price"), rs.getString("expense_type"));
                Expenses.add(e);
                contEx=+1;
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        System.out.println(contEx);
        return Expenses;
    }

    /**
     * This method adds new data into the table using the p parameter
     *
     * @param p .This parameter gives the information to add in our data base
     * @return 
     */
    public static int addProductionFee(ProductionFee p) {
        String sql = "INSERT INTO Production_fee(partner_DNI,month,year,total_price) VALUES(?,?,?,?)";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, p.getDNI());
            pstmt.setString(2, p.getMonth());
            pstmt.setInt(3, p.getYear());
            pstmt.setFloat(4, p.getPrice());

            pstmt.executeUpdate();

        } catch (SQLException e) {

            return 1062;

        }
        return 1;
    }

    /**
     *
     * @return
     */
    public static ArrayList<PartnershipFee> showPartnershipFee() {
        ArrayList<PartnershipFee> PartnershipFee = new ArrayList<>();
        
        String taula = "Partnership_fee";
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                PartnershipFee p = new PartnershipFee(rs.getString("partner_DNI"), rs.getInt("year"), rs.getBoolean("fee_charged"));
                PartnershipFee.add(p);
                      
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        
        return PartnershipFee;
    }
    
    public static ArrayList<Partner> showPartners() {
        ArrayList<Partner> Partners = new ArrayList<>();
       
        String sql = "SELECT DNI,name,surname,active FROM partner WHERE active=1";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Partner p = new Partner(rs.getString("DNI"), rs.getString("name"), rs.getString("surname"),rs.getBoolean("active"));
                Partners.add(p);
                      
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        
        return Partners;
    }

    /**
     * This method updates the table changing the fee_charged to true
     *
     * @param partner_DNI . This is the parameter which says which partner that
     * wants to change
     */
    public static void payPartnershipFee(String partner_DNI) {
        String sql = "UPDATE partnership_fee SET fee_charged = 1 "
                + "WHERE partner_DNI = ?"
                + "AND fee_charged= 0";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, partner_DNI);

            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method deletes a member from the table partnership_fee
     *
     * @param dni . This parameter is says who we want to delete
     * @return 
     */
    public static int unsuscribePF(String dni) {
        String sql = "DELETE FROM partnership_fee WHERE partner_DNI = ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, dni);
            // execute the delete statement
            pstmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
    
    public static void unsuscribe(String dni) {
        String sql = "UPDATE partner SET active=0 WHERE DNI= ?";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setString(1, dni);
            // execute the delete statement
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
    }
    

    /**
     * This method selects every room booking
     *
     * @return Returns an ArrayList of RoomBooking
     */
    public static ArrayList<RoomBooking> showRoomBooking() {
        ArrayList<RoomBooking> roomBooking = new ArrayList<>();
        String taula = "room_booking";
        String sql = "SELECT * FROM " + taula;

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RoomBooking rb = new RoomBooking(rs.getInt("id_booking"), rs.getString("partner_DNI"), rs.getDate("book_date"), rs.getInt("extracted_quantity"));
                roomBooking.add(rb);
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        return roomBooking;
    }

    public static ArrayList<Partner> showPartnerPR() {
        ArrayList<Partner> pr = new ArrayList<>();
        String taula = "room_booking";
        String sql = "SELECT Partner_DNI, name, surname,active FROM " + taula + " INNER JOIN partner on room_booking.Partner_DNI = partner.DNI GROUP BY room_booking.Partner_DNI";

        try (Connection conn = connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Partner f = new Partner(rs.getString("partner_DNI"), rs.getString("name"), rs.getString("surname"), rs.getBoolean("active"));
                pr.add(f);
            }
        } catch (Exception a) {
            System.out.println(a.getMessage());
        }
        return pr;
    }

    public static String memberName(String dni) {
        String sql = "SELECT name,surname FROM partner INNER JOIN production_fee on partner.DNI = production_fee.partner_DNI WHERE production_fee.partner_DNI = ?";
        String name = "";

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setString(1, dni);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                name = rs.getString("name") + " " + rs.getString("surname");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return name;
    }

    public static ArrayList<Date> showDate(int month) {
        String sql = "SELECT book_date FROM room_booking WHERE MONTH(book_date)=?";

        ArrayList<Date> dates = new ArrayList<Date>();
        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, month);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Date date = rs.getDate("book_date");
                dates.add(date);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dates;
    }

    public static ArrayList<Integer> showPartnerMonthFee(String dni, int month, int year) {
        String sql = "SELECT extracted_quantity FROM room_booking WHERE partner_DNI = ? AND MONTH(book_date) = ? AND YEAR(book_date) = ?";
        ArrayList<Integer> prices = new ArrayList<Integer>();

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, dni);
            pstmt.setInt(2, month);
            pstmt.setInt(3, year);

            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                int price = rs.getInt("extracted_quantity");
                prices.add(price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return prices;
    }

    public static ArrayList<String> showDNIMonth(int month, int year) {
        String sql = "SELECT partner_DNI FROM room_booking WHERE MONTH(book_date) = ? AND YEAR(book_date)=? GROUP BY partner_DNI";
        ArrayList<String> DNIs = new ArrayList<String>();

        try (Connection conn = connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, month);
            pstmt.setInt(2, year);

            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {
                String price = rs.getString("partner_DNI");
                DNIs.add(price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return DNIs;
    }

}
