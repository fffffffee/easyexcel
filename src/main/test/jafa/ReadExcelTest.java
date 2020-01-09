package jafa;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.User;
import util.TestFileUtil;
import util.UserExcelListener;

import java.io.File;

public class ReadExcelTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTest.class);

    @Test
    public void readExcel() {
        //String fileName = TestFileUtil.getPath() + "excel" + File.separator + "demo.xlsx"; //得到的是class文件的目录路径
        String fileName = System.getProperty("user.dir") + File.separator + "demo.xlsx";
        System.out.println(fileName);
        EasyExcel.read(fileName , User.class , new UserExcelListener()).sheet().doRead();


    }
}
