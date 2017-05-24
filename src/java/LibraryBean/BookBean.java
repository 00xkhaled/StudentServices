/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryBean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import BusReservationDao.StudentInformationDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import LibraryModel.Book;
import beans.SessionBean;
import LibraryDao.BookInformationDao;


/**
 *
 * @author tarekashi
 */
@Named(value = "BookBean")
@SessionScoped
public class BookBean implements Serializable {
    private int bookId;
    private String booktitleEn;
    private String booktitleAr;
    private String authorsnameEn;
    private String authorsnameAr;
    private String genre;
    private int publishyear;
    private String version;
    private int numofpages;
    private int price;
    private int priceday;
    private String status;
    private String ownername;
    
    private Book SelectedBook; //model object to save the selected book;
    private final BookInformationDao book_inf_dao = new BookInformationDao();
    private ArrayList<Book> list;
    
    @Inject
    
    private SessionBean sessionBean;
    
    public BookBean(){
        init ();
    }
       @PostConstruct
       
       public void init(){
           try{
               list = book_inf_dao.buildEvents();
           } catch (Exception ex){
               Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);   
           } 
       }
       
}
