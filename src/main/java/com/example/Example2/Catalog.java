package com.example.Example2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Catalog {
    private static final Map<String, CatalogItem> catalogItems = new HashMap<>();

    public static void addItem(CatalogItem catalogItem) {
        catalogItems.put(catalogItem.getSku(), catalogItem);
    }

    public static CatalogItem getItem(String sku) {
        return catalogItems.get(sku);
    }

    public static ArrayList<CatalogItem> getItems() {
        return new ArrayList<>(catalogItems.values());
    }
}
