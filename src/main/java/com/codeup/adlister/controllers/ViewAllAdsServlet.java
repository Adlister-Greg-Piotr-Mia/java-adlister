package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/viewallads")
public class ViewAllAdsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("ads") == null) {
            response.sendRedirect("/ads");
            return;
        }

        User user = (User)request.getSession().getAttribute("user");
        request.setAttribute("ads", DaoFactory.getAdsDao().getUserAds((int)user.getId()));

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
