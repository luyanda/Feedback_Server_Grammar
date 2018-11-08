<%-- 
    Document   : subHeader
    Created on : 06-Nov-2018, 15:38:51
    Author     : epsilon
--%>

<<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
</head>
<div>  
    <header>
        Grammar Web for Compiler Class
    </header>
    <div>
        <ul>
            <li><a href="chooseProject.jsp">Lists</a></li>
        </ul>
    </div>
