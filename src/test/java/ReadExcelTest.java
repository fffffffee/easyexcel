package java;

import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import pojo.User;
import util.UserExcelListener;

import java.io.File;
import java.io.FileNotFoundException;

public class ReadExcelTest {
    //private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelTest.class);

    @Test
    public void readExcel() throws FileNotFoundException {
        //String fileName = TestFileUtil.getPath() + "excel" + File.separator + "demo.xlsx"; //得到的是class文件的目录路径
        String fileName = System.getProperty("user.dir") + File.separator + "demo.xlsx";
        System.out.println(fileName);
        EasyExcel.read(fileName , User.class , new UserExcelListener()).sheet().doRead();
    }
}
