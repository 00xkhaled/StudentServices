/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryModel;

/**
 *
 * @author tarekashi
 */
import java.io.Serializable;
public class Book implements Serializable {
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
}
