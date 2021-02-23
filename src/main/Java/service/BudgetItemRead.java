package service;

import com.alibaba.excel.EasyExcel;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.BudgetItem4read;
import util.BudgetItemExcelListener;
import util.TestFileUtil;

import java.io.File;

/**
 * 读的常见写法
 *
 * @author dazuo
 */
public class BudgetItemRead {

    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetItemRead.class);

    public static void main(String arg[]) {

        PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "src/main/resources/log4j.properties");
        //String fileName = TestFileUtil.getPath() + "demo" + File.separator + "单项预算.xlsx";
        String fileName = System.getProperty("user.dir") + File.separator + "单项预算.xls";
        System.out.println(fileName);
        System.out.println(TestFileUtil.getPath());
        //先清空数据库
        //Todo
        //DatabaseHelper.executeQuery()
        //这里需要指定读用那个class去读，然后读取第一个sheet，文件流会自动关闭
        EasyExcel.read(fileName, BudgetItem4read.class, new BudgetItemExcelListener()).sheet().headRowNumber(6).doRead();

    }
}
