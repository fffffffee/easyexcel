package pojo;

import com.alibaba.excel.annotation.ExcelProperty;

public class User {
    @ExcelProperty(index = 0)
    private String name;

    @ExcelProperty(index = 1)
    private Integer age;

}
