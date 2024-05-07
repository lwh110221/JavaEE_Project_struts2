package stu.lwhao.javaee_project_strtus2;

/**
 * @author : Luowenhao221
 * @date : 2024/5/7 下午5:38
 * @Project : JavaEE_Project_strtus2
 */
import com.opensymphony.xwork2.ActionSupport;

public class HelloAction extends ActionSupport {
    private String message;

    public String execute() {
        message = "Hello Struts";
        return SUCCESS;
    }

    public String getMessage() {
        return message;
    }
}
