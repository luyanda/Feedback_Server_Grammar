<%-- 
    Document   : RandomView
    Created on : 18-Oct-2018, 12:07:16
    Author     : epsilon
--%>

<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" language="java"%>
<!DOCTYPE html>
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
        h1 {
            border-left: 6px solid red;
            border-right: 6px solid red;
            border-top: 6px solid red;
            border-bottom: 6px solid red;
            background-color: lightgrey;
        }
        h5 {
            border-bottom: 6px solid red;
            background-color: lightgrey;
        }
    </style>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <title>Random View Page</title>
</head>
    <body>
        <%@include file="SubmissionHeader.jsp"%>
        <div id="result">

            <div class="container-fluid text-center">    
                <div class="row content">
                    <div class="col-sm-2 sidenav">
                        <h3>Refine</h3>
                        <p><a href="Submission.jsp">Results</a></p>
                        <p><a href="PositiveView.jsp">False Positive</a></p>
                        <p><a href="NegativeView.jsp">False Negative</a></p>
                        <p><a href="RandomView.jsp">Randomly</a></p>
                    </div>
                    <div class="col-sm-8 text-left"> 
                        <h1>Random View</h1>
                        <h3>Project Name </h3>
                        <h3>Tool Name</h3>
                        <h5>Submission </h5>
                        <section>
                            <h5>
                                I love python programming.
                            </h5>
                            <h1>
                                I love java programming.
                            </h1>
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
                        <div class="well">
                            <p>ADS</p>
                        </div>
                        <div class="well">
                            <p>ADS</p>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
