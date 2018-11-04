<%-- 
    Document   : Submission
    Created on : 05 Sep 2018, 5:00:37 PM
    Author     : lmiuon
--%>

<%@page import="java.util.Collections"%>
<%@page import="ava.DbAccess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ava.Submissions"%>
<%@page import="ava.Student"%>
<%@page import="ava.ANTLR"%>
<%@page import="ava.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"     "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style>
        h1 {
            border-left: 6px solid red;
            border-right: 6px solid red;
            border-top: 6px solid red;
            border-bottom: 6px solid red;
            background-color: lightgrey;
        }
        .main {
            padding: 16px;
            margin-top: 30px;
            height: 50px; /* Used in this example to enable scrolling */
        }
        #myDIV {
            width: 100%;
            padding: 50px 0;
            text-align: left;
            background-color: lightblue;
            margin-top: 20px;
        }
    </style>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>

    <%
        
    %>
  <script>
    $(document).ready(function(){
        $("h6").click(function(){
            $(this).hide();
        });
    });

    function myFunction_One() {
        var x = document.getElementById("myDIV_one");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    function myFunction_Two() {
        var x = document.getElementById("myDIV_two");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    function myFunction_Three() {
        var x = document.getElementById("myDIV_three");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    function myFunction_Four() {
        var x = document.getElementById("myDIV_four");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    function myFunction_Five() {
        var x = document.getElementById("myDIV_five");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    function myFunction_Six() {
        var x = document.getElementById("myDIV_six");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    function myFunction_Seven() {
        var x = document.getElementById("myDIV_seven");
        if (x.style.display === "block") {
            x.style.display = "none";
        } else {
            x.style.display = "block";
        }
    }
    
  </script>
</head>
  
    <%@include file="SubmissionHeader.jsp" %>
    <body>
    <div class="navbar">
        <ul>
            <li><a href="chooseProject.jsp">Re-Submit</a></li>
            <!--li><a>Submission History</a></li-->
            <li><a href="#">Re-Submit</a></li>
            <li><a href="#result">Results</a></li>
            <li><a href="#random">Random View</a></li>
            <li><a href="#negative">False Neg</a></li>
            <li><a href="#positive">False Pos</a></li>
            <li><a href="#detailed">Pos Detail</a></li>
        </ul>
    </div>   
        <div class="main">
            <!--H6>Results Page</H6-->
        </div>
            <div class="container-fluid text-center">    
                <div class="row content">
                <div id="result">

                    <div class="col-sm-2 sidenav">
                        <p><a href="#result">Results</a></p>
                        <p><a href="#random">Random View</a></p>
                        <p><a href="#negative">False Neg</a></p>
                        <p><a href="#positive">False Pos</a></p>
                        <p><a href="#detaile">Pos Detail</a></p>
                    </div>
                    
                    <div class="col-sm-8 text-left"> 
                        <h2>Welcome : <%=user.getUserId() %></h2>
                        <h3>Project Name </h3>
                        <h3>Tool Name</h3>
                        <h5>Submission ID:<%=submission.getId() %></h5>
                        <h5>Feedback: <%=subObj.getFeedback() %> all out of 100</h5>
                        <section>
                        <p>
                            In computing, telecommunication, information theory, 
                            and coding theory, an error correction code, sometimes 
                            error correcting code, (ECC) is used for controlling 
                            errors in data over unreliable or noisy communication 
                            channels.[1][2] The central idea is the sender encodes 
                            the message with a redundant in the form of an ECC. 
                            The American mathematician Richard Hamming pioneered 
                            this field in the 1940s and invented the first error-correcting 
                            code in 1950: the Hamming (7,4) code.[2] The redundancy 
                            allows the receiver to detect a limited number of 
                            errors that may occur anywhere in the message, and 
                            often to correct these errors without retransmission. 
                            ECC gives the receiver the ability to correct errors 
                            without needing a reverse channel to request retransmission 
                            of data, but at the cost of a fixed, higher forward 
                            channel bandwidth. ECC is therefore applied in situations 
                            where retransmissions are costly or impossible, 
                            such as one-way communication links and when transmitting 
                            to multiple receivers in multicast. For example, 
                            in the case of a satellite orbiting around Uranus, 
                            a retransmission because of decoding errors can 
                            create a delay of 5 hours. ECC information is usually 
                            added to mass storage devices to enable recovery of 
                            corrupted data, is widely used in modems, and is used 
                            on systems where the primary memory is ECC memory. 
                        </p>
                        </section><hr>
                        <h3>Test</h3>
                        <p>Lorem ipsum...</p>
                    </div>
                    <div class="col-sm-2 sidenav">
                        <!--div class="well">
                            <p>ADS</p>
                        </div>
                        <div class="well">
                            <p>ADS</p>
                        </div-->
                    </div>
                </div>
                </div>
                <div class="row content">
                    <div id="positive">

                    <div class="col-sm-2 sidenav">
                        <h3>Refine</h3>
                        <p><a href="chooseProject.jsp">Re-Submit</a></p>
                        <p><a href="#PositiveView.jsp">False Positive</a></p>
                        <p><a href="#NegativeView.jsp">False Negative</a></p>
                        <p><a href="#RandomView.jsp">Randomly</a></p>
                    </div>
                    <div>
                    
                    </div>
                    <div class="col-sm-8 text-left"> 
                        
                        <h2>Size for <i>False Positive suites</i>: <%=PosfailedFiles.size() %></h2>
                        <button onclick="myFunction_One()">Show / Hide</button>
                            <div id="myDIV_one" class="main-container collapse">
                                <%
                                    for(int index=0;index<PosfailedFiles.size();index++){
                                        File file = PosfailedFiles.get(index);
                                        testcase.setName(file.getName());
                                        access.UpdateViewedTestCase(subObj, antlr, testcase);
                                        fileReader  = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        String currentline;
                                        while((currentline = bufferedReader.readLine()) != null){
                                            %><h6><% out.println("| Test Case:\t"+currentline);%><br> </h6><%
                                        }
                                        failedFiles.remove(PosfailedFiles.get(index));
                                        PosfailedFiles.remove(index);
                                        
                                    }
                                %>
                              </div>
                        <br><hr>
                        <h3>Test</h3>
                        <p>Lorem ipsum...</p>
                    </div>
                    <div class="col-sm-2 sidenav">
                        <!--div class="well">
                            <p>ADS</p>
                        </div>
                        <div class="well">
                            <p>ADS</p>
                        </div-->
                    </div>
            </div>        
                </div>
                <div class="row content">
                    <div id="detailed">
                    <div class="col-sm-2 sidenav">
                        <h3>Refine</h3>
                        <p><a href="chooseProject.jsp">Re-Submit</a></p>
                        <p><a href="#PositiveView.jsp">False Positive</a></p>
                        <p><a href="#NegativeView.jsp">False Negative</a></p>
                        <p><a href="#RandomView.jsp">Randomly</a></p>
                    </div>
                    <div>
                    
                    </div>
                    <div class="col-sm-8 text-left"> 
                        
                        <h2>Size for <i>Missmatched Errors</i>: <%=missmatch.size() %></h2>
                        <button onclick="myFunction_Two()">Hid/View Missmatch Errors</button>
                            <div id="myDIV_two" class="main-container collapse">
                                <%
                                    for(int index=0;index<missmatch.size();index++){
                                        String some = missmatch.get(index).replace("\n", "<br>");
                                        some = some.replace("_", " &nbsp;");
                                        %><h6><% out.println(some);%><br> </h6><%
                                    }
                                %>
                              </div>
                        <br>
                        <hr>
                        <h2>Size for <i>MissLetter Errors</i>: <%=missLetter.size() %></h2>
                        <button onclick="myFunction_Three()">Hid/View MissLetter Errors</button>
                            <div id="myDIV_three" class="main-container collapse">
                                <%
                                    for(int index=0;index<missLetter.size();index++){
                                        String some = missLetter.get(index).replace("\n", "<br>");
                                        some = some.replace("_", " &nbsp;");
                                        %><h6><% out.println(some);%><br> </h6><%
                                    }
                                %>
                              </div>
                        <br>
                        <hr>
                        <h2>Size for <i>Extraneous Errors</i>: <%=extraneous.size() %></h2>
                        <button onclick="myFunction_Four()">Hid/View Extraneous Errors</button>
                            <div id="myDIV_four" class="main-container collapse">
                                <%
                                    for(int index=0;index<extraneous.size();index++){
                                        String some = extraneous.get(index).replace("\n", "<br>");
                                        some = some.replace("_", " &nbsp;");
                                        %><h6><% out.println(some);%><br> </h6><%
                                    }
                                %>
                              </div>
                        <br>
                        <hr>
                        <h2>Size for <i>No Viable Errors</i>: <%=noViable.size() %></h2>
                        <button onclick="myFunction_Five()">Hid/View NoViable Errors</button>
                            <div id="myDIV_five" class="main-container collapse">
                                <%
                                    for(int index=0;index<noViable.size();index++){
                                        String some = noViable.get(index).replace("\n", "<br>");
                                        some = some.replace("_", " &nbsp;");
                                        %><h6><% out.println(some);%><br> </h6><%
                                    }
                                %>
                              </div>
                        <br>
                        <hr>
                              
                        
                        <h3>Test</h3>
                        <p>Lorem ipsum...</p>
                    </div>
                    <div class="col-sm-2 sidenav">
                        <!--div class="well">
                            <p>ADS</p>
                        </div>
                        <div class="well">
                            <p>ADS</p>
                        </div-->
                    </div>
            </div>        
                </div>
                <div class="row content">
                    <div id="random">

                    <div class="col-sm-2 sidenav">
                        <h3>Refine</h3>
                        <p><a href="chooseProject.jsp">Re-Submit</a></p>
                        <p><a href="#PositiveView.jsp">False Positive</a></p>
                        <p><a href="#NegativeView.jsp">False Negative</a></p>
                        <p><a href="#RandomView.jsp">Randomly</a></p>
                    </div>
                    <div>
                    
                    </div>
                    <div class="col-sm-8 text-left"> 
                        
                        <h2>Size for <i>False suites</i>: <%=failedFiles.size() %></h2>
                        <button onclick="myFunction_Six()">Show / Hide</button>
                            <div id="myDIV_six" class="main-container collapse">
                                <%
                                    for(int index=0;index<failedFiles.size();index++){
                                        File file = failedFiles.get(index);
                                        testcase.setName(file.getName());
                                        access.UpdateViewedTestCase(subObj, antlr, testcase);
                                        fileReader  = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        String currentline;
                                        while((currentline = bufferedReader.readLine()) != null){
                                            %><h6><% out.println("| Test Case:\t"+currentline);%><br> </h6><%
                                        }
                                        failedFiles.remove(index);
                                    }
                                %>
                              </div>
                        <br>
                        <hr>
                        
                        <h3>Test</h3>
                        <p>Lorem ipsum...</p>
                    </div>
                    <div class="col-sm-2 sidenav">
                        <!--div class="well">
                            <p>ADS</p>
                        </div>
                        <div class="well">
                            <p>ADS</p>
                        </div-->
                    </div>
            </div>        
                </div>
                <div class="row content">
                    <div id="negative">

                    <div class="col-sm-2 sidenav">
                        <h3>Refine</h3>
                        <p><a href="chooseProject.jsp">Re-Submit</a></p>
                        <p><a href="#PositiveView.jsp">False Positive</a></p>
                        <p><a href="#NegativeView.jsp">False Negative</a></p>
                        <p><a href="#RandomView.jsp">Randomly</a></p>
                    </div>
                    <div>
                    
                    </div>
                    <div class="col-sm-8 text-left"> 
                        
                        <h2>Size for <i>False Negative suites</i>: <%=NegfailedFiles.size() %></h2>
                        <button onclick="myFunction_Seven()">Show / Hide</button>
                            <div id="myDIV_seven" class="main-container collapse in">
                                <%
                                    for(int index=0;index<NegfailedFiles.size();index++){
                                        File file = NegfailedFiles.get(index);
                                        testcase.setName(file.getName());
                                        access.UpdateViewedTestCase(subObj, antlr, testcase);
                                        fileReader  = new FileReader(file);
                                        bufferedReader = new BufferedReader(fileReader);
                                        String currentline;
                                        while((currentline = bufferedReader.readLine()) != null){
                                            %><h6><% out.println("| Test Case:\t"+currentline);%><br> </h6><%
                                        }
                                        failedFiles.remove(NegfailedFiles.get(index));
                                        NegfailedFiles.remove(index);
                                        
                                    }
                                %>
                              </div>
                        <br>
                        <hr>
                        <h3>Test</h3>
                        <p>Lorem ipsum...</p>
                    </div>
                    <div class="col-sm-2 sidenav">
                        <!--div class="well">
                            <p>ADS</p>
                        </div>
                        <div class="well">
                            <p>ADS</p>
                        </div-->
                    </div>
            </div>        
                </div>
        </div>

    </body>
</html>
