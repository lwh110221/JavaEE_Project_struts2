<%--
  Created by IntelliJ IDEA.
  Author : luowenhao221
  Date: 2024/5/7
  Time: 下午5:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>图书查询结果</title>
    <meta charset="UTF-8">
</head>
<body>
<h1>图书查询结果</h1>

<!-- 查询表单和按钮 -->
<s:form action="bookSearch">
    <s:textfield name="searchQuery" label="搜索图书" />
    <s:submit value="查询" />
</s:form>

<s:if test="books.size() > 0">
    <table>
        <tr>
            <th>ID</th>
            <th>书名</th>
            <th>价格</th>
            <th>操作</th>
        </tr>
        <s:iterator value="books">
            <tr>
                <td><s:property value="bookid"/></td>
                <td><s:property value="bookname"/></td>
                <td><s:property value="bookprice"/></td>
                <td>
                <%--   删除--%>
                    <s:url var="deleteURL" action="bookDelete">
                        <s:param name="bookid" value="%{bookid}"/>
                    </s:url>
                    <s:a href="%{deleteURL}">删除</s:a>
                </td>
            </tr>
        </s:iterator>
    </table>
</s:if>
<s:else>
    <p>没有查询结果</p>
</s:else>
</body>
</html>
