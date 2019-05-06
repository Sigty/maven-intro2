package by.itacademy.servlet;

import by.itacademy.service.service.UserService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user-list")
public class UserListServlet extends HttpServlet {

    private UserService userService = UserService.getInstance();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("userList", userService.findAll());

        getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/user-list.jsp")
                .forward(req, resp);
    }

}

