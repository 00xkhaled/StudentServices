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
import daos.library.BookInformationDao;
import models.library.Authors;
import javax.faces.view.ViewScoped;
import daos.library.BookDetailDao;

/**
 *
 * @author tarekashi
 */
@Named(value = "BookDetailBean")
@ViewScoped
public class BookDetailBean implements Serializable {

    private int bookId;
    private String booktitleEn;
    private String booktitleAr;
    private String authorsnameEn;
    private String authorsnameAr;
    private String genre;
    private int publishyear;
    private int authorId;
    private String version;
    private int numofpages;
    private int price;
    private int priceday;
    private String status;
    private String ownername;
    private Book SelectedBook;//model object to save the selected book;
    private Book book;
    private final BookDetailDao book_inf_dao = new BookDetailDao();
    private final AuthorsDao authors_dao = new AuthorsDao();
    private ArrayList<Book> list;
    private ArrayList<Authors> authors;

    @Inject

    private SessionBean sessionBean;

    public BookDetailBean() {
        // init();
    }

    @PostConstruct
    public void init() {
        try {
            bookId = sessionBean.getSelectedItemId();
            authors = authors_dao.buildAuthors();

            if (bookId > 0) {
                Book boook = book_inf_dao.getBook(bookId);
                booktitleEn = boook.getBooktitleEn();
                booktitleAr = boook.getBooktitleAr();
                genre = boook.getGenre();
                publishyear = boook.getPublishyear();
                version = boook.getVersion();
                numofpages = boook.getNumofpages();
                price = boook.getPrice();
                priceday = boook.getPriceday();
                status = boook.getStatus();
                ownername = boook.getOwnername();
                authorId = boook.getAuthor().getAuthorId();
            }
        } catch (Exception ex) {
            Logger.getLogger(BookDetailBean.class.getName()).log(Level.SEVERE, null, ex);
        }
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
}
