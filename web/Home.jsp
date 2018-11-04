<%-- 
    Document   : home
    Created on : 10-Oct-2017, 20:32:03
    Author     : CS_admin
--%>

<%@page import="RMI.Programmes"%>
<%@page import="java.rmi.ConnectException"%>
<%@page import="RMI.IRemoteProgrammes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.rmi.Naming"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SAPTU Career Guidance App</title>
        <style>
            * {
                box-sizing: border-box;
            }
            hbody {margin:0;}
            .hnavbar {
                overflow: hidden;
                background-color: #333;
                width: 100%;
            }
            .hnavbar a {
                float: left;
                display: block;
                color: orange;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }.main {
                padding: 16px;
                margin-top: 30px;
                height: 1500px; /* Used in this example to enable scrolling */
            }body {
                margin: 0;
                font-size: 15px;
            }
            .header {
                background-color: whitesmoke;
                padding: 30px;
                color: orange;
            }
            #navbar {
                margin-top: 0px;
                overflow: hidden;
                background-color: #4169E1;
            }#navbar a {
                float: left;
                display: block;
                color: #f2f2f2;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
                font-size: 17px;
            }#navbar a:hover {
                background-color: #ddd;
                color: black;
            }#navbar a.active {
                background-color: #4CAF50;
                color: white;
            }.content {
                padding: 16px;
            }.sticky {
                position: fixed;
                top: 0;
                width: 100%
            }.sticky + .content {
                padding-top: 60px;
            }

            table {
                border-collapse: collapse;
                width: 100%;
            }

            th, td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even){background-color: #f2f2f2}

            th {
                background-color: orange;
                color: white;
            }

            .button {
                background-color: #4CAF50; /* Green */
                border: none;
                color: orange;
                padding: 15px 32px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 16px;
                margin: 4px 2px;
                cursor: pointer;
                -webkit-transition-duration: 0.4s; /* Safari */
                transition-duration: 0.4s;
            }

            .button1 {
                box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
            }

            .button2:hover {
                box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
            }

            .footer {
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: black;
                color: orange;
                text-align: center;
            }
            p.seven {
                border-style: solid;
                border-width: 2px 10px 4px 20px;
            }
            all{
                border: 2px solid red;
            }
        </style>
    
    </head>
    <body onscroll="myFunction()">
        <%@include file="Header.jsp"%>
        <div class="header">
            <br>

            <h2><center>Welcome to a South Africa Public Traditional Universities (SAPTU) Career Guidance Web Application</center></h2>
            <hr>
            <p class="seven"><a rel="nofollow" href="#home">Careers</a>. <br>
                SAPTU CGWA is a standardised career guidance solution for secondary school learners about to pursued university academics. CGWA serves as an online career guidance service, which has fascinating features for learners to exploit on, Sign Up and get helpful material to attain excellent matric results. </p>
            THE FOLLOWING FIELDS OF STUDY, ARE SAPTU STANDARDISED TO MEET THE STANDARD OF CGWA SYSTEM. EACH OF THE INSTITUTIONS PRESENTED HERE HAVE THEIR OWN PRESENTATION OF FIELDS/FACULTIES OF STUDY. Refer to institution website.<br/>
            <br/>
            <strong>
                Programme  : University Study Programme<br/>
                Title      : University Programme title(Degree or Diploma)<br/>
                APS        : Minimum Admission Score Point<br/>
                Institution: Higher Institutions of Learning<br/>
                Required   : Required Subject for Qualification<br/>
                Duration   : Programme Duration<br/>
                Careers    : Study Programme Careers<br/></strong>
            <p class="seven">UCT = University of Cape Town; UFH = University of Fort Hare; UFH = University of Free State; NWU = North West University; UP = University of Pretoria; RU = Rhodes University; UWC =University of Western Cape; Wits = University of Witwatersrand; Stellie = University of Stellenbosch;   <p/>
        </div>
        <div id="navbar">
            <a class="active" href="javascript:void(0)">Standard Programs of Study</a>
            <button type="submit"  form="SPSformOne" class="button button1">SCIENCE</button>
            <button type="submit"  form="SPSformTwo" class="button button1">HUMANITIES</button>
            <button type="submit"  form="SPSformThree" class="button button1">HEALTH SCIENCE</button>
            <button type="submit"  form="SPSformFour" class="button button1">MILITARY</button>
            <button type="submit"  form="SPSformFive" class="button button1">LAW & COMMERCE</button>
            <button type="submit"  form="SPSformSix" class="button button1">ENGINEERING</button>
        </div>

        <div>
            <form method="POST" action="Controller" id="SPSformOne">
                <input type="hidden" name="action" value="GetSPSData"/>
                <input type="hidden" name="SPSCourse" value="science">
            </form>
            <form method="POST" action="Controller" id="SPSformTwo">
                <input type="hidden" name="action" value="GetSPSData"/>
                <input type="hidden" name="SPSCourse" value="humanities"> 
            </form>
            <form method="POST" action="Controller" id="SPSformThree">
                <input type="hidden" name="action" value="GetSPSData"/>
                <input type="hidden" name="SPSCourse" value="health">
            </form>
            <form method="POST" action="Controller" id="SPSformFour">
                <input type="hidden" name="action" value="GetSPSData"/>
                <input type="hidden" name="SPSCourse" value="military">
            </form>
            <form method="POST" action="Controller" id="SPSformFive">
                <input type="hidden" name="action" value="GetSPSData"/>
                <input type="hidden" name="SPSCourse" value="lawCommerce">
            </form>
            <form method="POST" action="Controller" id="SPSformSix">
                <input type="hidden" name="action" value="GetSPSData"/>
                <input type="hidden" name="SPSCourse" value="engineering">
            </form>
            <table id="t01" border="1" style="width: 100%" cellspacing="1" align="center">
                <tbody>
                    <%
                        if (request.getAttribute("SPScourse") != null)
                          {
                    %>
                <thead>
                    <tr>
                        <th>Programme</th>
                        <th>Title</th>
                        <th>APS</th>
                        <th>Institution</th>
                        <th>Required</th>
                        <th>Duration</th>
                        <th>Careers</th>
                    </tr>
                </thead>
                <%
                    ArrayList<Programmes> list = (ArrayList<Programmes>) request.getAttribute("SPScourse");
                    for (Programmes p : list)
                      {
                %>
                <tr>
                    <td><%= p.getName()%></td>
                    <td><%= p.getTitle()%></td>
                    <td><%= p.getAps()%></td>
                    <td><%= p.getInstitution()%></td>
                    <td><%= p.getSubjects()%></td>
                    <td><%= p.getDuration()%></td>
                    <td><%= p.getCarees()%></td>
                </tr> 
                <%
                          }
                      }
                %>
                </tbody>
            </table>
        </div>
        <br>
        <div id="navbar">
            <a class="active" href="javascript:void(0)"><strong>Extra Programs of Study...</strong></a>
            <button type="submit"  form="ESPformOne" class="button button1">SCIENCE</button>
            <button type="submit"  form="ESPformTwo" class="button button2">HUMANITIES</button>
            <button type="submit"  form="ESPformThree" class="button button2">HEALTH SCIENCE</button>
            <!--button type="submit"  form="ESPformFour" class="button button2">MILITARY</button-->
            <button type="submit"  form="ESPformFive" class="button button2">LAW & COMMERCE</button>
            <button type="submit"  form="ESPformSix" class="button button2">ENGINEERING</button>
        </div>
        <br>
        <div>
            <div></div>
            <table id="t01" border="1" style="width: 100%" cellspacing="1" align="center">
                <form method="POST" action="Controller" id="ESPformOne">
                    <input type="hidden" name="action" value="GetESPData"/>
                    <input type="hidden" name="ESPCourse" value="science">
                </form>
                <form method="POST" action="Controller" id="ESPformTwo">
                    <input type="hidden" name="action" value="GetESPData"/>
                    <input type="hidden" name="ESPCourse" value="humanities">
                </form>
                <form method="POST" action="Controller" id="ESPformThree">
                    <input type="hidden" name="action" value="GetESPData"/>
                    <input type="hidden" name="ESPCourse" value="health">
                </form>
                <!--form method="POST" action="Controller" id="ESPformFour">
                    <input type="hidden" name="action" value="GetESPData"/>
                    <input type="hidden" name="ESPCourse" value="military">
                </form-->
                <form method="POST" action="Controller" id="ESPformFive">
                    <input type="hidden" name="action" value="GetESPData"/>
                    <input type="hidden" name="ESPCourse" value="lawCommerce">
                </form>
                <form method="POST" action="Controller" id="ESPformSix">
                    <input type="hidden" name="action" value="GetESPData"/>
                    <input type="hidden" name="ESPCourse" value="engineering">
                </form>
                <tbody>
                    <%
                        if (request.getAttribute("ESPcourse") != null)
                          {
                    %>
                <thead>
                    <tr>
                        <th>Programme</th>
                        <th>Title</th>
                        <th>APS</th>
                        <th>Institution</th>
                        <th>Required</th>
                        <th>Duration</th>
                        <th>Careers</th>
                    </tr>
                </thead>
                <%
                    ArrayList<Programmes> list = (ArrayList<Programmes>) request.getAttribute("ESPcourse");
                    for (Programmes p : list)
                      {
                %>
                <tr>
                    <td><%= p.getName()%></td>
                    <td><%= p.getTitle()%></td>
                    <td><%= p.getAps()%></td>
                    <td><%= p.getInstitution()%></td>
                    <td><%= p.getSubjects()%></td>
                    <td><%= p.getDuration()%></td>
                    <td><%= p.getCarees()%></td>
                </tr> 
                <%
                          }
                      }
                %>
                </tbody>
            </table>
        </div>
    </div> 
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <script>
        var navbar = document.getElementById("navbar");
        var sticky = navbar.offsetTop;

        function myFunction() {
            if (window.pageYOffset >= sticky) {
                navbar.classList.add("sticky")
            } else {
                navbar.classList.remove("sticky");
            }
        }
    </script>
    <script>
        var slideIndex = 1;
        showSlides(slideIndex);

        function plusSlides(n) {
            showSlides(slideIndex += n);
        }

        function currentSlide(n) {
            showSlides(slideIndex = n);
        }

        function showSlides(n) {
            var i;
            var slides = document.getElementsByClassName("mySlides");
            var dots = document.getElementsByClassName("dot");
            if (n > slides.length) {
                slideIndex = 1
            }
            if (n < 1) {
                slideIndex = slides.length
            }
            for (i = 0; i < slides.length; i++) {
                slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
                dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
        }
    </script>
    <%@include file="Foot.jsp" %>
</body>
</html>
