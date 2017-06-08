package models.tutoring;


import java.io.Serializable;
import java.util.ArrayList;
/**
 *
 * @author Abdalla
 */
public class School implements Serializable {
    private int schoolId;
    private String nameEn;
    private String nameAr;
    private ArrayList <Major> majors;
    
    public School(){}  /** constructor 1*/
    
    
    public School(int schoolId, String nameEn, String nameAr) { /**constructor 2*/
        this.schoolId = schoolId;
        this.nameEn = nameEn;
        this.nameAr = nameAr;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public ArrayList<Major> getMajors() {
        return majors;
    }

    public void setMajors(ArrayList<Major> majors) {
        this.majors = majors;
    }

}
