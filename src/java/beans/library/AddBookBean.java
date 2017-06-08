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
import models.library.Authors;
import beans.SessionBean;
import daos.library.BookInformationDao;
import java.sql.Timestamp;
import java.util.Date;
import javax.faces.view.ViewScoped;

/**
 *
 * @author tarekashi
 */
@Named(value = "addbookBean")
@ViewScoped
public class AddBookBean implements Serializable {

    private ArrayList<Authors> authors;
    private final AuthorsDao authorsDao = new AuthorsDao();
    private final BookInformationDao bookinformationDao = new BookInformationDao();
    private int bookId;
    private String booktitleEn;
    private String booktitleAr;
    private int authorId;
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
    private Date returnDate;

    @Inject
    private SessionBean sessionBean;

    public AddBookBean() {

    }

    @PostConstruct
    public void init() {
        try {
            setBookId(sessionBean.getSelectedItemId());
            authors = authorsDao.buildAuthors();

            if (getBookId() > 0) {
                Book book = bookinformationDao.getBook(getBookId());
                setBooktitleEn(book.getBooktitleEn());
                setBooktitleAr(book.getBooktitleAr());
                genre = book.getGenre();
                publishyear = book.getPublishyear();
                version = book.getVersion();
                numofpages = book.getNumofpages();
                price = book.getPrice();
                priceday = book.getPriceday();
                status = book.getStatus();
                ownername = book.getOwnername();
                authorId = book.getAuthor().getAuthorId();
                returnDate = book.getReturnDate();
            }
        } catch (Exception ex) {
            Logger.getLogger(AddBookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Authors> getAuthors() {
        return authors;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int AuthorId) {
        this.authorId = AuthorId;
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

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getreturnDate() {
        return returnDate;
    }

    public void setreturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    //  Hamza ( buy & borrow ).
    public void saveBuyBook() {
        try {

            Book book = new Book();

            book.setStatus("Sold");
            book.setOwnername(ownername);

            if (sessionBean.getSelectedItemId() > 0) {
                bookinformationDao.BuyBook(book);
            } else {
                bookinformationDao.insertBook(book);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddBookBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("library");
    }

    public void saveBorrowBook() {
        try {

            Book book = new Book();

            book.setStatus("Rented");
            book.setReturnDate(new Timestamp(returnDate.getTime()));

            if (sessionBean.getSelectedItemId() > 0) {
                bookinformationDao.borrowBook(book);
            } else {
                bookinformationDao.insertBook(book);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddBookBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("library");
    }

//  Hamza ( buy & borrow ).    
    public void saveBook() {
        try {

            Book book = new Book();
            Authors author = authors.get(authorId - 1);
            book.setBookId(getBookId());
            book.setAuthor(author);
            book.setBooktitleAr(getBooktitleAr());
            book.setBooktitleEn(getBooktitleEn());
            book.setGenre(genre);
            book.setNumofpages(numofpages);
            book.setPrice(price);
            book.setPriceday(priceday);
            book.setPublishyear(publishyear);
            book.setStatus(status);
            book.setVersion(version);
            book.setOwnername(ownername);

            if (sessionBean.getSelectedItemId() > 0) {
                bookinformationDao.insertBook(book);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddBookBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessionBean.navigate("library");
    }

}
