package ua.ithillel.hw7.enums;

public enum EnumFlowerCategory {

    PION(0),
    ROSA(1),
    ROMASHKA(2),
    OTHER_CATEGORY(3);

    private int index;

    EnumFlowerCategory(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }


    public static String getNameCategory(EnumFlowerCategory nc) {
        String nameCategory = "Не определена";

        switch (nc) {
            case PION:
                nameCategory = "Пион";
                break;
            case ROSA:
                nameCategory = "Роза";
                break;
            case ROMASHKA:
                nameCategory = "Ромашка";
                break;
            case OTHER_CATEGORY:
                nameCategory = "Другие цветы";
                break;
            default:
        }

        return nameCategory;
    }

}
