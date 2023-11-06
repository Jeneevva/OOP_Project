package project.models;

public class Student {
    private String name;
    private String tel_number;
    private String address;
    private String link;
    private int uni_id;

    public Student(){

    }

    public Student(String name, String tel_number, String address, String link, int uni_id) {
        this.name = name;
        this.tel_number = tel_number;
        this.address = address;
        this.link = link;
        this.uni_id = uni_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getUni_id() {
        return uni_id;
    }

    public void setUni_id(int uni_id) {
        this.uni_id = uni_id;
    }
}
