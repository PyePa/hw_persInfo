package data;

public enum TextFieldData {
    FIRST_NAME("fname"),
    LAST_NAME("lname"),
    FNAME_LAT("fname_latin"),
    LNAME_LAT("lname_latin"),
    BLOG_NAME("blog_name"),
    BIRTH_DATE("date_of_birth"),
    COMPANY("company"),
    WORK("work"),
    CONTACT_FIRST("contact-0-value"),
    CONTACT_SECOND("contact-1-value");
    private String name = "";
    TextFieldData(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}