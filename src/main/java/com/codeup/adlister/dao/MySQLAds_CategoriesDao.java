package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAds_CategoriesDao implements Ads_Categories{
    private Connection connection = null;

    public MySQLAds_CategoriesDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the ad_category database!", e);
        }
    }


    @Override
    public List<Ad> adsInCategory(int category_id) {
        String query = "SELECT * FROM ad_category WHERE category_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, category_id);
            return createAdsFromResults(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category by id", e);
        }
    }

    @Override
    public List<Category> categoriesInAd(int ad_id) {
        String query = "SELECT * FROM ad_category WHERE ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, ad_id);
            return createCategoriesFromResults(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a category by id", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return DaoFactory.getAdsDao().one(rs.getInt("ad_id"));
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    private Category extractCategories(ResultSet rs) throws SQLException {
        return DaoFactory.getCategoriesDao().one(rs.getInt("category_id"));
    }
    private List<Category> createCategoriesFromResults(ResultSet rs) throws SQLException {
        List<Category> categories = new ArrayList<>();
        while (rs.next()) {
            categories.add(extractCategories(rs));
        }
        return categories;
    }


}
