package service;

import com.alibaba.excel.EasyExcel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.User;
import util.UserExcelListener;

import java.io.File;

public class Testhello {
    private static final Logger LOGGER = LoggerFactory.getLogger(Testhello.class);
    public static void main(String[] arg) {
        //String fileName = Testhello.class.getResource("/").getPath() + "excel" + File.separator + "demo.xlsx";
        String fileName = System.getProperty("user.dir") + File.separator + "demo.xlsx";
        System.out.println(fileName);
        EasyExcel.read(fileName , User.class , new UserExcelListener()).sheet("Sheet3").doRead();
    }
}
