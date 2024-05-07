package stu.lwhao.action;

import com.opensymphony.xwork2.ActionSupport;
import stu.lwhao.bean.Book;
import stu.lwhao.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author : Luowenhao221
 * @date : 2024/5/7 下午8:13
 * @Project : JavaEE_Project_struts2
 */

/**
 * action类，用于处理图书删除请求
 */
public class BookDeleteAction extends ActionSupport{
    private Integer bookid;// 要删除的图书id
    private List<Book> books;// 查询到的图书列表

    public String execute() {
        books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 通过JDBC连接数据库，查询图书信息
        try {
            connection = JDBCUtil.getConnection();
            String sql = "DELETE FROM t_book WHERE bookid = ?";// 删除图书
            statement = connection.prepareStatement(sql);
            statement.setInt(1, bookid);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

    }
    return SUCCESS;
}
    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}


