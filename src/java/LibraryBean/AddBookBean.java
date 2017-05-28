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
import LibraryModel.Authors;
import beans.SessionBean;
import LibraryDao.BookInformationDao;
import javax.faces.view.ViewScoped;

/**
 *
 * @author tarekashi
 */

@Named(value = "addbookBean")
@ViewScoped
public class AddBookBean implements Serializable {

    private ArrayList <Authors> authors;
    private final AuthorsDao authorsDao = new AuthorsDao ();
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
    
    @Inject
    private SessionBean sessionBean;
    
    public AddBookBean (){
        
    }
    
    @PostConstruct
    public void init()
    {
        try{
            bookId = sessionBean.getSelectedItemId();
            authors = authorsDao.buildEvents();
            
            if (bookId > 0){
                Book book = bookinformationDao.getBook(bookId);
                booktitleEn = book.getBooktitleEn();
                booktitleAr= book.getBooktitleAr();
                genre = book.getGenre();
                publishyear = book.getPublishyear();
                version = book.getVersion();
                numofpages = book.getNumofpages();
                price = book.getPrice();
                priceday = book.getPriceday();
                status = book.getStatus();
                ownername = book.getOwnername();
                authorId = book.getAuthor().getAuthorId();
            }
        } catch (Exception ex){
            Logger.getLogger(AddBookBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList <Authors> getAuthors()  
    {
         return authors;
    }
    
    public int getAuthorId()
    {
        return authorId;
    }
    
    public void setAuthorId(int AuthorId) {
        this.authorId = AuthorId;
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
    
    public void saveBook()
    {
        try{
        Book book = new Book();
        Authors author = authors.get(authorId - 1);
        book.setBookId(bookId);
        book.setAuthor(author);
        book.setBooktitleAr(booktitleAr);
        book.setBooktitleEn(booktitleEn);
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

































