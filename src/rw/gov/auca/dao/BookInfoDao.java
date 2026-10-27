/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.gov.auca.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.RowSet;
import javax.swing.JOptionPane;
import rw.gov.auca.model.BookInfo;

/**
 *
 * @author N.Eric
 */
public class BookInfoDao {
    
    
    String jdbcUrl="jdbc:postgresql://localhost:5432/Library_Management";
    String username="postgres";
    String password="0000";
    
    public int RegisterBook(BookInfo bookinfo){
        String sqlToRegister = "INSERT INTO books (isbn,title,author,price,quantity,category,publicationyear) VALUES (?,?,?,?,?,?,?)";
        
        try {
            Connection conToRegisterBook= DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statToRegisterBook = conToRegisterBook.prepareStatement(sqlToRegister);
            statToRegisterBook.setString(1, bookinfo.getIsbn());
            statToRegisterBook.setString(2, bookinfo.getTitle());
            statToRegisterBook.setString(3, bookinfo.getAuthor());
            statToRegisterBook.setString(4, String.valueOf(bookinfo.getPrice()));
            statToRegisterBook.setString(5, String.valueOf(bookinfo.getQuantity()));
            statToRegisterBook.setString(6, bookinfo.getCategory());
            statToRegisterBook.setString(7, String.valueOf(bookinfo.getPublicationYear()));
            int rowsAffected = statToRegisterBook.executeUpdate();
            if (rowsAffected>0) {
                return rowsAffected;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null," Database Error"+ e.getMessage());
        }
        return 0;
    }
    
    public BookInfo SearcBook( BookInfo bookToSearch){
        
        String SqlSearch="SELECT * FROM books Where isbn=?";
        
        try {
            Connection conTosearch = DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statTosearch=conTosearch.prepareStatement(SqlSearch);
            statTosearch.setString(1, bookToSearch.getIsbn());
            ResultSet resTosearch=statTosearch.executeQuery();
            if (resTosearch.next()) {
                bookToSearch.setIsbn(resTosearch.getString("isbn"));
                bookToSearch.setTitle(resTosearch.getString("title"));
                bookToSearch.setAuthor(resTosearch.getString("author"));
                bookToSearch.setPrice(Double.parseDouble(resTosearch.getString("price")));
                bookToSearch.setQuantity(Integer.parseInt(resTosearch.getString("quantity")));
                bookToSearch.setCategory(resTosearch.getString("category"));
                bookToSearch.setPublicationYear(Integer.parseInt(resTosearch.getString("publicationyear")));
               
                return bookToSearch;
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Database Error" +e.getMessage());
        }
        return null;
    }
    
    public int DeleteBook(BookInfo bookToDelete){
        String sqlToDelete = "DELETE FROM books WHERE isbn=? ";
        
        try {
            Connection conTodelete = DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statToDelete = conTodelete.prepareStatement(sqlToDelete);
            statToDelete.setString(1, bookToDelete.getIsbn());
            int rowsAffected = statToDelete.executeUpdate();
            if (rowsAffected>0) {
                return rowsAffected;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Database Error" +e.getMessage());
            
        }
        return 0;
    }
    
    public int UpdateBook( BookInfo bookToUpdate){
        String sqlToUpdate="UPDATE books SET  title=?,author=?,price=?,quantity=?,category=?,publicationyear=? WHERE isbn=?";
        try {
            Connection conToUpdate = DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statToUpdate= conToUpdate.prepareStatement(sqlToUpdate);
            statToUpdate.setString(1, bookToUpdate.getTitle());
            statToUpdate.setString(2, bookToUpdate.getAuthor());
            statToUpdate.setString(3, String.valueOf(bookToUpdate.getPrice()));
            statToUpdate.setString(4, String.valueOf(bookToUpdate.getQuantity()));
            statToUpdate.setString(5, bookToUpdate.getCategory());
            statToUpdate.setString(6, String.valueOf(bookToUpdate.getPublicationYear()));
            statToUpdate.setString(7, bookToUpdate.getIsbn());
            int rowsAffected = statToUpdate.executeUpdate();
            if (rowsAffected>0) {
                return rowsAffected;
            }

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null ,"Database Error" +e.getMessage());
        }
        return 0;
    }
    
    public List<BookInfo> getAllBookInfos(){
        List<BookInfo> bookInfoToLoad = new ArrayList<>();
        String sqlToGet="SELECT isbn,title,author,price,quantity,category,publicationyear FROM books";
        
        try {
            Connection conToGetBook= DriverManager.getConnection(jdbcUrl,username,password);
            PreparedStatement statToGetBook  = conToGetBook.prepareStatement(sqlToGet);
            ResultSet resToGetBook = statToGetBook.executeQuery();
            while (resToGetBook.next()) {                
                BookInfo bookBack=new BookInfo();
                bookBack.setIsbn(resToGetBook.getString("isbn"));
                bookBack.setTitle(resToGetBook.getString("title"));
                bookBack.setAuthor(resToGetBook.getString("author"));
                bookBack.setPrice(Double.parseDouble(resToGetBook.getString("price")));
                bookBack.setQuantity(Integer.parseInt(resToGetBook.getString("quantity")));
                bookBack.setCategory(resToGetBook.getString("category"));
                bookBack.setPublicationYear(Integer.parseInt(resToGetBook.getString("publicationyear")));
                bookInfoToLoad.add(bookBack);
            }
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null ,"Database Error" +e.getMessage());
        }
        return bookInfoToLoad;
    }
    
}
