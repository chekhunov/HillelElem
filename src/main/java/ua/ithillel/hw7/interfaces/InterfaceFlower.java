package ua.ithillel.hw7.interfaces;

import ua.ithillel.hw7.enums.EnumFlowerCategory;

public interface InterfaceFlower {
    int FlowerID = 0;
    String flowerName = "";

    EnumFlowerCategory flowerCategory = EnumFlowerCategory.OTHER_CATEGORY;

    String flowerCategoryName = "";

    public String getFlowerCategoryName();

    public void setFlowerCategoryName(String flowerCategoryName);

    public String getFlowerNameCategory(EnumFlowerCategory nc);

}
