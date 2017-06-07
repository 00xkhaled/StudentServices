/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.library;

/**
 *
 * @author tarekashi
 */
import java.io.Serializable;
import java.sql.Timestamp;

public class Book implements Serializable {

    private int bookId;
    private String booktitleEn;
    private String booktitleAr;
    private String genre;
    private int publishyear;
    private String version;
    private int numofpages;
    private int price;
    private int priceday;
    private String status;
    private String ownername;
    private Authors authorEn;
    private Authors authorAr;
    private Authors author;
    private Timestamp returnDate;

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

    public Authors getAuthorEn() {
        return authorEn;
    }

    public void setAuthorEn(Authors authorEn) {
        this.authorEn = authorEn;
    }

    public Authors getAuthorAr() {
        return authorAr;
    }

    public void setAuthorAr(Authors authorAr) {
        this.authorAr = authorAr;
    }

    public Authors getAuthor() {
        return author;
    }

    public void setAuthor(Authors author) {
        this.author = author;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

}
