<%@page import="java.util.HashMap"%>
<%@page import="ava.User"%>
<%@page import="java.util.ArrayList" %>
<%@ page import="ava.DbAccess" %>
<%@ page import="ava.ANTLR" %>
<%@ page import="ava.UserInterface" %>
<%@ page import="ava.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: epsilon
  Date: 9/2/18
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        header {
            padding: 1em;
            color: #4169E1;
            background-color: lightgrey;
            clear: left;
            text-align: center;
            font-size: xx-large;
        }
        sty{
            color: orange;
            font-size: x-large;
        }
        h2
        {
            color: #4169E1;
            font-size: x-large;
        }

        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #4169E1;
        }

        li {
            float: left;
            border-right:1px solid #bbb;
        }

        li:last-child {
            border-right: none;
        }

        li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        li a:hover:not(.active) {
            background-color: orange;
        }

        .active {
            background-color: #4CAF50;
        }
    </style>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<div>
    <header>
        Welcome to Grammar Web App
    </header>
    <div>
        <ul>
            <li><a href="chooseProject.jsp">Lists</a></li>
        </ul>
    </div>
</div>
<body>
            <!--%@include file="Header.jsp"%-->
                    <%
                        int num = 0;
                        User user = null;//
                        Student student = null;
                        String username = null;
                        int userId = 0;
                        if (session.getAttribute("checker") == null)
                          {
                            response.sendRedirect("index.jsp");
                          } else
                          {
                            student = (Student)session.getAttribute("LoggedIn");
                          }

                        String userName = null;
                        String sessionID = null;
                        Cookie[] cookies = request.getCookies();
                        if (cookies != null)
                          {
                            for (Cookie cookie : cookies)
                              {
                                if (cookie.getName().equals("username"))
                                  {
                                    sessionID = cookie.getValue();
                                  }
                              }
                          }
            %>
<h1 align="center">Select your Project Bellow <%=student.getUserId()%></h1>

        <table align="center" border="15">
            <tbody border="5">
                <thead>
                    <th> ID - </th>
                    <th> Name </th>
                    <th> Close </th>
                    <th> Tool </th>
                </thead>
                <%
                    ArrayList<ANTLR> list = new ArrayList();
                    UserInterface projecet = new DbAccess();
                    
                    list = projecet.ProjectList(student);
                    for(ANTLR antlr : list){
                %>
                <tr>
                    <td><%= antlr.getId()%></td>
                    <td><a href="fileUpload.jsp?id=<%=antlr.getName()%>"><%=antlr.getName()%></a></td>
                            <%
                                    session.setAttribute(antlr.getName(),antlr);
                            %>
                    <td><%= antlr.getClose()%></td>
                    <td><%= antlr.getToolName()%></td>
                </tr>
                <%
                   
                    }
                %>
            </tbody>
        </table>
                
<%@include file="foot.jsp" %>
</body>
</html>
