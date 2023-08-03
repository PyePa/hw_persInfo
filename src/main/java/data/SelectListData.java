package data;

public enum SelectListData {
    NOT_CHOSE("Не указано"),
    MALE("Мужской"),
    FEMALE("Женский");

    private String name;
    SelectListData(String name){
        this.name=name;
    }
    public String getName() {
        return name;
    }
}