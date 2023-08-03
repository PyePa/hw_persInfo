package data;

import components.DropDownList;

public enum DropDownListData {
    COUNTRY("country"),
    CITY("city"),
    ENGLISH_LEVEL("english_level"),
    CONTACT_FIRST("contact-0-service"),
    CONTACT_SECOND("contact-1-service");
    private String name = "";

    DropDownListData(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }
}