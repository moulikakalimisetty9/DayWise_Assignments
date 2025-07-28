// Folder: Day6_FeedbackSystem
// File 1: feedback.html (Frontend Form)

<!DOCTYPE html>
<html>
<head>
    <title>Student Feedback Form</title>
</head>
<body>
    <h2>Course Feedback</h2>
    <form action="submit" method="post">
        Name: <input type="text" name="studentName" required><br><br>
        Email: <input type="email" name="email" required><br><br>
        Course: <input type="text" name="course" required><br><br>
        Feedback:<br>
        <textarea name="feedback" rows="4" cols="30" required></textarea><br><br>
        <input type="submit" value="Submit Feedback">
    </form>
</body>
</html>


// File 2: SubmitFeedbackServlet.java (Servlet Backend)

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/submit")
public class SubmitFeedbackServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("studentName");
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String feedback = request.getParameter("feedback");

        HttpSession session = request.getSession();
        if (session.getAttribute("submitted") != null) {
            out.println("<h2>You have already submitted feedback.</h2>");
            return;
        } else {
            session.setAttribute("submitted", true);
        }

        // Display confirmation
        out.println("<h2>Thank You for Your Feedback!</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Course: " + course + "</p>");
        out.println("<p>Feedback: " + feedback + "</p>");

        // Optionally write to file or DB (not shown here)
    }
}
