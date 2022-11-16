package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Ads_Categories {
    // get a list of category id's of an ad using the ad's id
    List<Ad> adsInCategory(int category_id);
    // get a list of ad id's of a category using the category's id
    List<Category> categoriesInAd(int ad_id);
}
