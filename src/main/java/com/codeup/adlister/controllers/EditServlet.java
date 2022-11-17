package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ad_id"));
        request.setAttribute("ad", DaoFactory.getAdsDao().one(id));
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("ad_id"));
        String ad_title = request.getParameter("ad_title");
        String ad_description = request.getParameter("ad_description");

        //Default values of Ad if left null
        String default_title = request.getParameter("default_title");
        String default_description = request.getParameter("default_description");

        // Check if there are empty fields
        boolean inputHasErrors = ad_title.isEmpty()
                && ad_description.isEmpty();

        //Redirect to edit page with error message
        if (inputHasErrors) {
            request.setAttribute("error", "Can not have two empty fields");
            request.setAttribute("ad", DaoFactory.getAdsDao().one(id));
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/ads/edit.jsp");
            rd.forward(request, response);
          //Conditionals to fill input with default value if one value is empty
        } else if(ad_title.isEmpty() && ad_description != null) {
            DaoFactory.getAdsDao().updateAd(id, default_title, ad_description);
            response.sendRedirect("/profile");
        } else if (ad_description.isEmpty() && ad_title != null) {
            DaoFactory.getAdsDao().updateAd(id, ad_title, default_description);
            response.sendRedirect("/profile");
        } else {
            DaoFactory.getAdsDao().updateAd(id, ad_title, ad_description);
            response.sendRedirect("/profile");
        }
    }
}
