#### **header.jsp**

==========

<%@ page language="java" contentType="text/html; charset=UTF-8"

&nbsp;   pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

<h1 style="color:green;">College Feedback System</h1>

<hr>

</body>

</html>



#### **footer.jsp**

==========

<%@ page language="java" contentType="text/html; charset=UTF-8"

&nbsp;   pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

<hr/>

<p>\&copy; 2025 Department of Computer Science</p>

</body>

</html>



#### **Feedback.java**

=============

package model;



public class Feedback {

&nbsp;   private String username;

&nbsp;   private String\[] facilities;

&nbsp;   private String comments;



&nbsp;   public Feedback(String username, String\[] facilities, String comments) {

&nbsp;       this.username = username;

&nbsp;       this.facilities = facilities;

&nbsp;       this.comments = comments;

&nbsp;   }



&nbsp;   public String getUsername() {

&nbsp;       return username;

&nbsp;   }



&nbsp;   public String\[] getFacilities() {

&nbsp;       return facilities;

&nbsp;   }



&nbsp;   public String getComments() {

&nbsp;       return comments;

&nbsp;   }

}



#### **index.jsp**

=========

<%@ page language="java" contentType="text/html; charset=UTF-8"

&nbsp;   pageEncoding="UTF-8"%>    

<%@ include file="header.jsp"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

<h2>Welcome to the Feedback Portal</h2>

<a href="feedbackForm.jsp">Start Feedback</a></body>

</html>

<%@ include file="footer.jsp"%>



#### **feedbackForm.jsp**

================

<%@ include file="header.jsp" %>

<h2>Provide Your Feedback</h2>

<form action="feedbackSummary.jsp" method="post">

&nbsp;   Name: <input type="text" name="username" required /><br/><br/>



&nbsp;   Facilities:<br/>

&nbsp;   <input type="checkbox" name="facility" value="Library" /> Library<br/>

&nbsp;   <input type="checkbox" name="facility" value="Cafeteria" /> Cafeteria<br/>

&nbsp;   <input type="checkbox" name="facility" value="Lab" /> Lab<br/><br/>



&nbsp;   Comments:<br/>

&nbsp;   <textarea name="comments" rows="4" cols="40"></textarea><br/><br/>



&nbsp;   <input type="submit" value="Submit Feedback" />

</form>

<%@ include file="footer.jsp" %>



#### **feedbackSummary.jsp**

===================

<%@ page import="model.Feedback" %>

<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="header.jsp" %>



<%

&nbsp;   String username = request.getParameter("username");

&nbsp;   String\[] facilities = request.getParameterValues("facility");

&nbsp;   String comments = request.getParameter("comments");



&nbsp;   Feedback fb = new Feedback(username, facilities, comments);

&nbsp;   request.setAttribute("fb", fb);

%>



<h2>Feedback Summary</h2>

<p>Hello, ${fb.username}!</p>



<c:choose>

&nbsp;   <c:when test="${empty fb.facilities}">

&nbsp;       <p><strong>No feedback submitted.</strong></p>

&nbsp;   </c:when>

&nbsp;   <c:otherwise>

&nbsp;       <ul>

&nbsp;           <c:forEach var="f" items="${fb.facilities}">

&nbsp;               <li>${f}</li>

&nbsp;           </c:forEach>

&nbsp;       </ul>

&nbsp;   </c:otherwise>

</c:choose>



<p><strong>Your Comments:</strong> ${fb.comments}</p>



<a href="thankyou.jsp?username=${fb.username}">Finish</a>

<%@ include file="footer.jsp" %>



#### **thankyou.jsp**

============

<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>

<%@ include file="header.jsp"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Insert title here</title>

</head>

<body>

<h2>Thank You!</h2>

<p>Thanks ${param.username}, your feedback has been recorded.</p>

</html>

<%@ include file="footer.jsp"%>





