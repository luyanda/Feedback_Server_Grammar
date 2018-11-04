<%-- 
    Document   : SubmissionHeader
    Created on : 09-Oct-2018, 17:54:46
    Author     : epsilon
--%>

<%@page import="ava.Testcase"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@page import="ava.User"%>
<%@page import="ava.ANTLR"%>
<%@page import="ava.Student"%>
<%@page import="ava.Operations"%>
<%@page import="ava.Submissions"%>
<%@page import="ava.DbAccess"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
        h2{
            color: #4169E1;
            font-size: x-large;
        }
        ul{
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
        .navbar {
            overflow: hidden;
            background-color: #333;
            position: fixed;
            top: 0;
            width: 100%;
        }
        .navbar a {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }
        .navbar a:hover {
            background: #ddd;
            color: black;
        }
    </style>
</head>
<div>

    <div>
        <%
            Student student = new Student();
            ANTLR antlr = new ANTLR();
            User user = new User();
            Submissions submission = new Submissions();
            Submissions subObj = new Submissions();
            Testcase testcase = new Testcase();
            ArrayList<String> missmatch = new ArrayList();
            ArrayList<String> missLetter = new ArrayList();
            ArrayList<String> noViable = new ArrayList();
            ArrayList<String> extraneous = new ArrayList();
            ArrayList<File> failedFiles = new ArrayList();
            ArrayList<File> PosfailedFiles = new ArrayList();
            ArrayList<File> NegfailedFiles = new ArrayList();
            FileReader fileReader;
            BufferedReader bufferedReader;
            String trace = new String();
            Operations oper = new Operations();

            if (request.getAttribute("LoggedIn") != null) {
                user = (User) request.getAttribute("LoggedIn");
                request.setAttribute("LoggedIn", user);
                System.out.println("\n\n\n\trequest Aparantly user is logged :" + user.getUserId());
            }
            if (request.getAttribute("project") != null) {
                antlr = (ANTLR) request.getAttribute("project");
                request.setAttribute("project", antlr);
                System.out.println("\n\n\trequest Project Object available :" + antlr.getToolName());
            }
            if (request.getAttribute("submissionId") != null) {
                System.out.println("\n\n\t Submisison id avaible");
                submission = (Submissions) request.getAttribute("submissionId");
                request.setAttribute("submissionId", submission);
            }
            if (request.getAttribute("failedFiles") != null) {
                System.out.println("\n\n\t failedFiles id avaible");
                failedFiles = (ArrayList) request.getAttribute("failedFiles");
                request.setAttribute("failedFiles", failedFiles);
            }
            if (request.getAttribute("missmatch") != null) {
                System.out.println("\n\n\t Missmatched error messages loaded");
                missmatch = (ArrayList) request.getAttribute("missmatch");
                request.setAttribute("missmatch", missmatch);
                System.out.println("new Size: " + missmatch.size());
            }
            if (request.getAttribute("extraneous") != null) {
                System.out.println("\n\n\t extraneous error messages loaded");
                extraneous = (ArrayList) request.getAttribute("extraneous");
                request.setAttribute("extraneous", extraneous);
                System.out.println("Extraneous size: " + extraneous.size());
            }
            if (request.getAttribute("missLetter") != null) {
                System.out.println("\n\n\t missLetter error messages loaded");
                missLetter = (ArrayList) request.getAttribute("missLetter");
                request.setAttribute("missLetter", missLetter);
                System.out.println("miss letter size:" + missLetter.size());
            }
            if (request.getAttribute("noVaiable") != null) {
                System.out.println("\n\n\t noViable error messages loaded");
                noViable = (ArrayList) request.getAttribute("noVaiable");
                request.setAttribute("noVaiable", noViable);
                System.out.println("no viable size" + noViable.size());
            }
            if (request.getAttribute("tracer") != null) {
                System.out.println("\n\n\t tracer loaded");
                trace = (String) request.getAttribute("tracer");
            }
            if (request.getAttribute("subObj") != null) {
                System.out.println("\n\n\t SubObj available");
                subObj = (Submissions) request.getAttribute("subObj");
                request.setAttribute("subObj", subObj);
            }

            DbAccess access = new DbAccess();

            try {
                for(File file : failedFiles){
                    if(file.getParent().contains("negative"))
                        NegfailedFiles.add(file);
                    else if(file.getParent().contains("positive"))
                        PosfailedFiles.add(file);
                }
                submission = access.GetSubmissionId(user, antlr, trace);
                session.setAttribute("submission", submission);
            } finally {
                
                if (missmatch.size() > 0) {
                    access.insertBulkErrorMessages(submission, missmatch, "Missmatched Input");
                }
                if (missLetter.size() > 0) {
                    access.insertBulkErrorMessages(submission, missLetter, "Missing a Letter");
                }
                if (extraneous.size() > 0) {
                    access.insertBulkErrorMessages(submission, extraneous, "Extraneous Input");
                }
                if (noViable.size() > 0) {
                    access.insertBulkErrorMessages(submission, noViable, "No Viable Alternative");
                }
            }

        %>
    </div>
</div>
