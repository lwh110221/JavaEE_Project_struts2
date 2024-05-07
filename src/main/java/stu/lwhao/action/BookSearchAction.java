package stu.lwhao.action;

import stu.lwhao.bean.Book;
import stu.lwhao.util.JDBCUtil;
import com.opensymphony.xwork2.ActionSupport;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author : Luowenhao221
 * @date : 2024/5/7 下午7:35
 * @Project : JavaEE_Project_struts2
 */

/**
 * action类，用于处理图书搜索请求
 */
public class BookSearchAction extends ActionSupport {
    private String searchQuery;// 搜索关键字
    private List<Book> books;// 查询到的图书列表

    public String execute() {
        books = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        // 通过JDBC连接数据库，查询图书信息
        try {
            connection = JDBCUtil.getConnection();
            String sql = "SELECT * FROM t_book WHERE bookname LIKE ?";// 模糊查询
            statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + searchQuery + "%");
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Book book = new Book();
                book.setBookid(resultSet.getInt("bookid"));
                book.setBookname(resultSet.getString("bookname"));
                book.setBookprice(resultSet.getDouble("bookprice"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(connection);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return SUCCESS;// 返回成功
    }



    public String getSearchQuery() {
        return searchQuery;// 获取搜索关键字
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;// 设置搜索关键字
    }

    public List<Book> getBooks() {
        return books;// 获取查询到的图书列表
    }
}
