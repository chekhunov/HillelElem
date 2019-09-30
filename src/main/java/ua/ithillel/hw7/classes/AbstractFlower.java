package ua.ithillel.hw7.classes;

import ua.ithillel.hw7.enums.EnumFlowerCategory;
import ua.ithillel.hw7.interfaces.InterfaceFlower;

public abstract class AbstractFlower implements InterfaceFlower {
    int flowerID;
    String flowerName;
    String flowerCategoryName;

    EnumFlowerCategory flowerCategory;

    public AbstractFlower(){}

    public AbstractFlower(int flowerID, String flowerName, EnumFlowerCategory flowerCategory) {
        flowerID = flowerID;
        this.flowerName = flowerName;
        this.flowerCategory = flowerCategory;
    }

    public AbstractFlower(int flowerID, String flowerName, String flowerCategoryName, EnumFlowerCategory flowerCategory) {
        flowerID = flowerID;
        this.flowerName = flowerName;
        this.flowerCategoryName = flowerCategoryName;
        this.flowerCategory = flowerCategory;
    }

    public int getFlowerID() {
        return flowerID;
    }

    public void setFlowerID(int flowerID) {
        flowerID = flowerID;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }

    public EnumFlowerCategory getFlowerCategory() {
        return flowerCategory;
    }

    public void setFlowerCategory(EnumFlowerCategory flowerCategory) {
        this.flowerCategory = flowerCategory;
    }

    public String getFlowerCategoryName() {
        return flowerCategoryName;
    }

    public void setFlowerCategoryName(String flowerCategoryName) {
        if(this.flowerCategoryName == null || this.flowerCategoryName.isEmpty())
            this.flowerCategoryName = getFlowerNameCategory(this.flowerCategory);
        else this.flowerCategoryName = flowerCategoryName;
    }

    public String getFlowerCategoryName(EnumFlowerCategory nc) {
        return EnumFlowerCategory.getNameCategory(nc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbstractFlower)) return false;

        AbstractFlower aFlower = (AbstractFlower) obj;

        if (flowerID != aFlower.flowerID) return false;
        if (flowerCategory != aFlower.flowerCategory) return false;
        if (!flowerCategoryName.equals(aFlower.flowerCategoryName)) return false;
        if (!flowerName.equals(aFlower.flowerName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = flowerID;
        result = 31 * result + flowerName.hashCode();
        result = 31 * result + flowerCategory.hashCode();
        result = 31 * result + flowerCategoryName.hashCode();
        return result;
    }
}
