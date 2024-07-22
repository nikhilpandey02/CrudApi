package dev.nikhil.serviceproduct.Services;

import dev.nikhil.serviceproduct.models.Category;

import java.util.List;

public interface CategoryService {
    Category getCategory(String uuid);
    List<String> getProductTitles(List<String> categoryUUIDs);
}
