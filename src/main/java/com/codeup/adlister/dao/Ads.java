package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get a list of all of a users ads with user's id
    List<Ad> user(int user_id);
    // get one add with ad's id
    Ad one(int ad_id);

    void deleteAd(int id);

    void updateAd(int id, String default_title, String ad_description);
}
