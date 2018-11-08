<%-- 
    Document   : fileUpload
    Created on : 04 Sep 2018, 11:03:58 PM
    Author     : lmiuon
--%>

<%@page import="ava.Student"%>
<%@page import="ava.ANTLR"%>
<%@page import="ava.User"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <% 
            ANTLR project = new ANTLR();
            
            if (session.getAttribute("checker") == null){
                response.sendRedirect("index.jsp");
            }else if(request.getParameter("id") == null){
                response.sendRedirect("chooseProject.jsp");
            }
            
            Student student = (Student)session.getAttribute("LoggedIn"); 
            String project_ = request.getParameter("id");
            
            project = (ANTLR) session.getAttribute(project_);
            session.setAttribute("project",project);
        %>
        <h1 align="center">Hello World!<%= student.getUserId() %>,<%=student.getType() %></h1>

            <center>
                <h1>File Upload</h1>
                <h3>For project ID: <%= project.getName() %></h3>
                <form method="post" action="Operation" enctype="multipart/form-data">
                    Select file to upload: <input type="file" name="file" size="60" required/><br />
                    <br /> <input type="submit" value="Upload" />
                </form>
            </center>
      
        <%@include file="foot.jsp" %>
    </body>
</html>
