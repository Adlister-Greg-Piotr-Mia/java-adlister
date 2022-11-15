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

@WebServlet(name = "controllers.InfoServlet", urlPatterns = "/ads/info")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int adId = Integer.parseInt(request.getParameter("id"));
        Ad ad = DaoFactory.getAdsDao().one(adId);
        User user = DaoFactory.getUsersDao().findById((int)ad.getUserId());

        request.setAttribute("ad", ad);
        request.setAttribute("user", user);

        request.getRequestDispatcher("/WEB-INF/ads/info.jsp")
                .forward(request, response);
    }
}
