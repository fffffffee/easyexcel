package pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import mapper.GenderConverter;

public class User {
    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private Integer age;

    //@ExcelProperty(index = 2 , converter = GenderConverter.class)
    @ExcelProperty(index = 2)
    private Integer gender;

    @ExcelProperty(index = 3)
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    private String birth;

    public  User(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Integer getGender() {
        return gender;
    }

    public String getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name = " + name + '\'' +
                "age = " + age + '\'' +
                '}';
    }
}
