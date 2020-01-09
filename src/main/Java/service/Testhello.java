package service;

import pojo.User;

import java.io.File;

public class Testhello {
    public static void main(String[] arg) {

        String fileName = Testhello.class.getResource("/").getPath() + "excel" + File.separator + "demo.xlsx";
        System.out.println(fileName);
        System.out.println(System.getProperty("user.dir"));
        System.out.println();
    }

}
