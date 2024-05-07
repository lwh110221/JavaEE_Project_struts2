package stu.lwhao.bean;

/**
 * @author : Luowenhao221
 * @date : 2024/5/7 下午5:38
 * @Project : JavaEE_Project_strtus2
 */
import com.opensymphony.xwork2.ActionSupport;

public class Book extends ActionSupport {
    private Integer bookid;
    private String bookname;
    private double bookprice;

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public double getBookprice() {
        return bookprice;
    }

    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }
}
