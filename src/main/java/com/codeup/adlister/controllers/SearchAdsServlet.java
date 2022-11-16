package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchAdsServlet", urlPatterns = "/ads/search")
public class SearchAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


//        if (request.getSession().getAttribute("user") == null) {
//            // Intended Redirect after login
//            request.getSession().setAttribute("redirect", "/ads/create");
//            request.getRequestDispatcher("/login").forward(request, response);
//            return;
//        }
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Pass user input and store in a variable
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        // validate input
        boolean inputHasErrors = title.isEmpty() || description.isEmpty();

        // Alert user if input is empty
        if (inputHasErrors) {
            request.setAttribute("error", "Can not have empty fields");
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ads/create.jsp");
            rd.forward(request, response);
            return;
        } else {
            User user = (User) request.getSession().getAttribute("user");
            Ad ad = new Ad(
                    user.getId(),
                    request.getParameter("title"),
                    request.getParameter("description")
            );
            DaoFactory.getAdsDao().insert(ad);
            response.sendRedirect("/ads");
        }
    }
}
