<%-- 
    Document   : signup
    Created on : 12-Oct-2017, 00:16:17
    Author     : CS_admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
        <style>
            * {
                box-sizing: border-box;
            }
            body {
                background-color: #f1f1f1;
            }
            #regForm {
                background-color: #ffffff;
                margin: 100px auto;
                font-family: Raleway;
                padding: 40px;
                width: 40%;
                min-width: 300px;
                border: 1px solid #888;
            }
            h1 {
                text-align: center;  
            }
            input {
                padding: 10px;
                width: 100%;
                font-size: 17px;
                font-family: Raleway;
                border: 1px solid #aaaaaa;
            }
            /* Mark input boxes that gets an error on validation: */
            input.invalid {
                background-color: #ffdddd;
            }
            /* Hide all steps by default: */
            .tab {
                display: none;
                color: orange;
            }
            button {
                background-color: #4CAF50;
                color: orange;
                border: none;
                padding: 10px 20px;
                font-size: 17px;
                font-family: Raleway;
                cursor: pointer;
            }
            button:hover {
                opacity: 0.8;
            }
            label, h1, h2,h3
            {
                color: orange;
            }
            #prevBtn {
                background-color: #bbbbbb;
            }
            /* Make circles that indicate the steps of the form: */
            .step {
                height: 15px;
                width: 15px;
                margin: 0 2px;
                background-color: #bbbbbb;
                border: none;  
                border-radius: 50%;
                display: inline-block;
                opacity: 0.5;
            }
            .step.active {
                opacity: 1;
            }
            /* Mark the steps that are finished and valid: */
            .step.finish {
                background-color: #4CAF50;
            }
        </style>
    </head>
    <body>
        <%@include file="Header.jsp" %>
        <form id="regForm" method="POST" action="Controller">
            <input type="hidden" name="action" value="SignUp"/>
            <h1>Sign Up: </h1>
            <%
                if (request.getAttribute("error") != null)
                  {
                    ArrayList<String> errors = (ArrayList<String>) request.getAttribute("error");
                    String str = "";
                    for (String e : errors)
                      {
                        str = e.toString();

            %>
            <table>
                <tr><span style="color: chartreuse"><%=str%></span></tr> 
            </table>

            <%        }
                  }%>
            <p style="color: #b5ff5e"><%=request.getAttribute("Successmsg") == null ? "" : request.getAttribute("Successmsg")%></p>
            <!-- One "tab" for each step in the form: -->
            <div class="tab"><strong>Name:</strong>
                <p><input type="text" placeholder="First name..." oninput="this.className = ''" name="f_name" required></p>
                <p><input type="text" placeholder="Last name..." oninput="this.className = ''" name="l_name" required></p>
                <p><input type="number" placeholder="ID Number" oninput="this.className = ''" name="id_number" maxlength="13" minlength="13" required></p>
            </div>
            <div class="tab"><strong>Contact Info:</strong>
                <p><input type="email" placeholder="E-mail..." oninput="this.className = ''" name="email" required></p>
                <p><input type="number" placeholder="+27--------" oninput="this.className = ''" maxlength="13" minlength="10" name="phone" required></p>
            </div>
            <div class="tab"><strong>Learner Details:</strong>
                <p><input type="text" placeholder="Student Number..." oninput="this.className = ''" name="l_number" required></p>
                <p><input type="text" placeholder="Grade No..." oninput="this.className = ''" name="grade" required></p>
                <p><input type="text" placeholder="Class Stream" oninput="this.className = ''" name="stream" required></p>
            </div>
            <div class="tab"><strong>Subjects:</strong>
                <p><input type="text" placeholder="Subject Name Maths" oninput="this.className = ''" name="subject1" required></p>
                <p><input type="text" placeholder="Subject Name Physics" oninput="this.className = ''" name="subject2" required></p>
                <p><input type="text" placeholder="Subject Name Life Science" oninput="this.className = ''" name="subject3" required></p>
                <p><input type="text" placeholder="Subject Name Geography" oninput="this.className = ''" name="subject4" required></p>
                <p><input type="text" placeholder="Subject Name History" oninput="this.className = ''" name="subject5" required></p>
                <p><input type="text" placeholder="Subject Name Computer Studies" oninput="this.className = ''" name="subject6" required></p>
                <p><input type="text" placeholder="Subject Name Business Manag" oninput="this.className = ''" name="subject7" required></p>
            </div>
            <div class="tab"><strong>School Info:</strong>
                <p><input type="text" placeholder="School Name..." oninput="this.className = ''" name="school_name" required></p>
                <p><input type="text" placeholder="City Address..." oninput="this.className = ''" name="school_address" required></p>
                <p><input type="text" placeholder="City Name..." oninput="this.className = ''" name="school_town" required></p>
                <p><select name="school_province" oninput="this.className = ''" required>
                        <option>Western Cape</option>
                        <option>Eastern Cape</option>
                        <option>Northern Cape</option>
                        <option>Kwa Zulu Natal</option>
                        <option>Free State</option>
                        <option>Mpumalanga</option>
                        <option>Gauteng</option>
                        <option>Limpopo</option>
                        <option>North West</option>
                    </select>
                </p>
            </div>
            <div class="tab"><strong>Login Info:</strong>
                <p><input type="text" placeholder="@Username" oninput="this.className = ''" name="username" required></p>
                <p><input type="password" placeholder="Password..." oninput="this.className = ''" name="password" type="password" required></p>
                <p><input type="password" placeholder="Confirm Password..." oninput="this.className = ''" name="confirm_password" type="password" required></p>
            </div>
            <div style="overflow:auto;">
                <div style="float:right;">
                    <button type="button" id="prevBtn" onclick="nextPrev(-1)">Previous</button>
                    <button type="button" id="nextBtn" onclick="nextPrev(1)">Next</button>
                </div>
            </div>
            <!-- Circles which indicates the steps of the form: -->
            <div style="text-align:center;margin-top:40px;">
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
                <span class="step"></span>
            </div>
        </form>

        <script>
            var currentTab = 0; // Current tab is set to be the first tab (0)
            showTab(currentTab); // Display the crurrent tab

            function showTab(n) {
                // This function will display the specified tab of the form...
                var x = document.getElementsByClassName("tab");
                x[n].style.display = "block";
                //... and fix the Previous/Next buttons:
                if (n == 0) {
                    document.getElementById("prevBtn").style.display = "none";
                } else {
                    document.getElementById("prevBtn").style.display = "inline";
                }
                if (n == (x.length - 1)) {
                    document.getElementById("nextBtn").innerHTML = "Submit";
                } else {
                    document.getElementById("nextBtn").innerHTML = "Next";
                }
                //... and run a function that will display the correct step indicator:
                fixStepIndicator(n)
            }

            function nextPrev(n) {
                // This function will figure out which tab to display
                var x = document.getElementsByClassName("tab");
                // Exit the function if any field in the current tab is invalid:
                if (n == 1 && !validateForm())
                    return false;
                // Hide the current tab:
                x[currentTab].style.display = "none";
                // Increase or decrease the current tab by 1:
                currentTab = currentTab + n;
                // if you have reached the end of the form...
                if (currentTab >= x.length) {
                    // ... the form gets submitted:
                    document.getElementById("regForm").submit();
                    return false;
                }
                // Otherwise, display the correct tab:
                showTab(currentTab);
            }

            function validateForm() {
                // This function deals with validation of the form fields
                var x, y, i, valid = true;
                x = document.getElementsByClassName("tab");
                y = x[currentTab].getElementsByTagName("input");
                // A loop that checks every input field in the current tab:
                for (i = 0; i < y.length; i++) {
                    // If a field is empty...
                    if (y[i].value == "") {
                        // add an "invalid" class to the field:
                        y[i].className += " invalid";
                        // and set the current valid status to false
                        valid = false;
                    }
                }
                // If the valid status is true, mark the step as finished and valid:
                if (valid) {
                    document.getElementsByClassName("step")[currentTab].className += " finish";
                }
                return valid; // return the valid status
            }

            function fixStepIndicator(n) {
                // This function removes the "active" class of all steps...
                var i, x = document.getElementsByClassName("step");
                for (i = 0; i < x.length; i++) {
                    x[i].className = x[i].className.replace(" active", "");
                }
                //... and adds the "active" class on the current step:
                x[n].className += " active";
            }
        </script>
        <%@include file="Foot.jsp" %>
    </body>
</html>
