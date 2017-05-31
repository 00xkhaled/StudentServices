/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryBean;

import LibraryDao.AuthorsDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
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
    private final AuthorsDao authors_dao = new AuthorsDao ();
    private ArrayList<Book> list;
    
    @Inject
    
    private SessionBean sessionBean;
    
    public BookBean(){
        init ();
    }
       @PostConstruct
       
       public void init(){
           try{
               list = book_inf_dao.buildEvents(authors_dao.buildAuthorsMap());
           } catch (Exception ex){
               Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);   
           } 
       }
        /**
     * @return the bookId
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @param bookId the bookId to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * @return the booktitleEn
     */
    public String getBooktitleEn() {
        return booktitleEn;
    }

    /**
     * @param booktitleEn the booktitleEn to set
     */
    public void setBooktitleEn(String booktitleEn) {
        this.booktitleEn = booktitleEn;
    }

    /**
     * @return the booktitleAr
     */
    public String getBooktitleAr() {
        return booktitleAr;
    }

    /**
     * @param booktitleAr the booktitleAr to set
     */
    public void setBooktitleAr(String booktitleAr) {
        this.booktitleAr = booktitleAr;
    }

    /**
     * @return the authorsnameEn
     */
    public String getAuthorsnameEn() {
        return authorsnameEn;
    }

    /**
     * @param authorsnameEn the authorsnameEn to set
     */
    public void setAuthorsnameEn(String authorsnameEn) {
        this.authorsnameEn = authorsnameEn;
    }

    /**
     * @return the authorsnameAr
     */
    public String getAuthorsnameAr() {
        return authorsnameAr;
    }

    /**
     * @param authorsnameAr the authorsnameAr to set
     */
    public void setAuthorsnameAr(String authorsnameAr) {
        this.authorsnameAr = authorsnameAr;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @return the publishyear
     */
    public int getPublishyear() {
        return publishyear;
    }

    /**
     * @param publishyear the publishyear to set
     */
    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return the numofpages
     */
    public int getNumofpages() {
        return numofpages;
    }

    /**
     * @param numofpages the numofpages to set
     */
    public void setNumofpages(int numofpages) {
        this.numofpages = numofpages;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the priceday
     */
    public int getPriceday() {
        return priceday;
    }

    /**
     * @param priceday the priceday to set
     */
    public void setPriceday(int priceday) {
        this.priceday = priceday;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the ownername
     */
    public String getOwnername() {
        return ownername;
    }

    /**
     * @param ownername the ownername to set
     */
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    /**
     * @return the SelectedBook
     */
    public Book getSelectedBook() {
        return SelectedBook;
    }

    /**
     * @param SelectedBook the SelectedBook to set
     */
    public void setSelectedBook(Book SelectedBook) {
        this.SelectedBook = SelectedBook;
    }
    public void saveSelectedBookID(){
        sessionBean.setSelectedItemId(SelectedBook.getBookId());
    } 
       public ArrayList<Book> getList() {
        return list;
    }
       
       public void setList(ArrayList<Book> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }
       
       
           /** hamza adda
     */       
       
          public void BuySelectedBook(){
        try {
            book_inf_dao.BuyBook(getSelectedBook());     
        } catch (Exception ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
       
           public void borrowSelectedBook(){
        try {
            book_inf_dao.borrowBook(getSelectedBook());     
        } catch (Exception ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
}
