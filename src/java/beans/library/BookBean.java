/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.library;

import daos.library.AuthorsDao;
import javax.inject.Named;
import java.io.Serializable;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import models.library.Book;
import beans.SessionBean;
import javax.faces.view.ViewScoped;
import daos.library.BookInformationDao;


/**
 *
 * @author tarekashi
 */
@Named(value = "bookBean")
@ViewScoped
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
    private Book SelectedBook;//model object to save the selected book;
    private Book book;
    private final BookInformationDao book_inf_dao = new BookInformationDao();

    
    private final AuthorsDao authors_dao = new AuthorsDao();
    private ArrayList<Book> list;
    
    @Inject

    private SessionBean sessionBean;

    public BookBean() {
       // init();
    }

    @PostConstruct
    public void init() {
        try {
            list = book_inf_dao.buildEvents(authors_dao.buildAuthorsMap());
        } catch (Exception ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BookInformationDao getBook_inf_dao() {
        return book_inf_dao;
    }

    public AuthorsDao getAuthors_dao() {
        return authors_dao;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBooktitleEn() {
        return booktitleEn;
    }

    public void setBooktitleEn(String booktitleEn) {
        this.booktitleEn = booktitleEn;
    }

    public String getBooktitleAr() {
        return booktitleAr;
    }

    public void setBooktitleAr(String booktitleAr) {
        this.booktitleAr = booktitleAr;
    }

    public String getAuthorsnameEn() {
        return authorsnameEn;
    }

    public void setAuthorsnameEn(String authorsnameEn) {
        this.authorsnameEn = authorsnameEn;
    }

    public String getAuthorsnameAr() {
        return authorsnameAr;
    }

    public void setAuthorsnameAr(String authorsnameAr) {
        this.authorsnameAr = authorsnameAr;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPublishyear() {
        return publishyear;
    }

    public void setPublishyear(int publishyear) {
        this.publishyear = publishyear;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getNumofpages() {
        return numofpages;
    }

    public void setNumofpages(int numofpages) {
        this.numofpages = numofpages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPriceday() {
        return priceday;
    }

    public void setPriceday(int priceday) {
        this.priceday = priceday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public Book getSelectedBook() {
        return SelectedBook;
    }

    public void setSelectedBook(Book SelectedBook) {
        this.SelectedBook = SelectedBook;
    }

    public void saveSelectedBookID() {
        sessionBean.setSelectedItemId(SelectedBook.getBookId());
    }

    public ArrayList<Book> getList() {
        return list;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setList(ArrayList<Book> list) { //TO SET IN THE list of type model to save result from database
        this.list = list;
    }

    public Book detail(Book book) {
        this.book = book;
        return book;
    }
   
    /**
     * hamza adda
     */
    public void BuySelectedBook() {
        try {
            book_inf_dao.BuyBook(getSelectedBook());
        } catch (Exception ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrowSelectedBook() {
        try {
            book_inf_dao.borrowBook(getSelectedBook());
        } catch (Exception ex) {
            Logger.getLogger(BookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
