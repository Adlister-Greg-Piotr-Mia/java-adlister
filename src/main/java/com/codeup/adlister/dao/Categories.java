package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import java.util.List;

public interface Categories {
    // get a list of all the categories
    List<Category> all();
    // insert a new category and return the new category's id
    Long insert(Category category);
    // get one category with category's id
    Category one(int category_id);
}
