package service;

import com.alibaba.excel.EasyExcel;
import helper.DatabaseHelper;
import pojo.BudgetItem4read;

import java.io.File;
import java.util.List;

/**
 * 定额内容写入Excel，生成工程数量表
 *
 */
public class BudgetItemWrite {

    public static void main(String[] args) {

        // String fileName = TestFileUtil.getPath() + "工程数量表" + System.currentTimeMillis() + ".xlsx";
        String fileName = System.getProperty("user.dir") + File.separator + "工程数量表" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        EasyExcel.write(fileName, BudgetItem4read.class).sheet().doWrite(getBudgetItemList());
    }


    /**
     * 读取数据库数据
     */
    public static List<BudgetItem4read> getBudgetItemList() {
        String sql = "SELECT * FROM budgetItem";
        return DatabaseHelper.queryEnityList(BudgetItem4read.class, sql);
    }
}

