import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class regServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        registeredUser newregisteredUser = new registeredUser();
        newregisteredUser.setEmail(email);
        newregisteredUser.setFullName(fullName);
        newregisteredUser.setPassword(password);
        try {
            DB.createUser(newregisteredUser);
            response.sendRedirect("login.jsp");
        }

catch(SQLException e){
            throw new ServletException ("Error");
    }
}
}