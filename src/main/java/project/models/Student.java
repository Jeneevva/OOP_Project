package project.models;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class Student {
    //с помощью аннотаций прямо на самих полях устанавливаем валидации ввода
    @NotEmpty(message = "ФИО не должно быть пустым")
    @Size(min = 3, message = "Введите более 3 букв")
    private String name;

    @Size(min=11, max=12, message = "Номер должен состоять из 11 символов или 12(+7)")
    private String tel_number;

    @NotEmpty(message = "Адрес не должен быть пустым")
    private String address;

    //Эта аннотация принимает один обязательный параметр, который представляет собой регулярное выражение
    //таким образом, \\w+/$ в регулярном выражении означает, что строка должна
    // начинаться с одного или более символов, представляющих собой букву,
    // цифру или символ подчеркивания, и заканчиваться символом /.
    @Pattern(regexp = "^https://www.instagram.com/\\w+/$", message = "Ссылка на Instagram аккаунт должна начинаться с https://www.instagram.com/ и содержать только буквы, цифры и символ подчеркивания")
    @NotEmpty(message = "Сслыка не должна быть пустой")
    private String link;

    @Positive(message = "ID не может быть отрицательным")
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
