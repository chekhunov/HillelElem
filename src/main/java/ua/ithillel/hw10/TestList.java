package ua.ithillel.hw10;

public class TestList {

    public static void main(String[] args) {

        String[] coolStringArray = new String[]{"Java", "Scala", "Groovy"};

        List<String> list = new List<>();

        list.addArrayToList(coolStringArray);
        System.out.println(list);
        list.addLast("PHP");
        list.addLast("PHP");
        System.out.println(list.size());
        System.out.println(list);
        list.addFirst("JS");
        System.out.println(list);
        list.addByIndex("ХЕ-XE", 3);
        System.out.println(list);
        list.removeIndex(3);
        System.out.println(list);
        list.remove("JS");
        System.out.println(list);
        list.isEmpty();
        list.reversByIndex(1, 3);
        System.out.println(list);
    }
}
