package service;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import helper.DatabaseHelper;
import org.apache.poi.ss.usermodel.IndexedColors;
import pojo.BudgetItem4read;
import pojo.BudgetItem4write;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 定额内容写入Excel，生成工程数量表
 *
 */
public class BudgetItemWrite {

    public static void main(String[] args) {
        WriteExcel();
    }
    public static void WriteExcel() {
        //设置表头格式
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        //设置表头背景透明
        //headWriteCellStyle.setFillForegroundColor(IndexedColors);
        //设置表头字体
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setBold(true);                           //字体加粗
        headWriteFont.setFontName("宋体");                     //字体
        headWriteFont.setFontHeightInPoints((short)10.5);     //字号小五
        headWriteCellStyle.setWriteFont(headWriteFont);

        //设置内容格式
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        WriteFont contentWriteFont = new WriteFont();
        contentWriteFont.setFontName("宋体");
        contentWriteFont.setFontHeightInPoints((short)10.5);
        contentWriteCellStyle.setWriteFont(contentWriteFont);

        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

        // String fileName = TestFileUtil.getPath() + "工程数量表" + System.currentTimeMillis() + ".xlsx";
        String fileName = System.getProperty("user.dir") + File.separator + "工程数量表" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        EasyExcel.write(fileName, BudgetItem4write.class).head(head()).registerWriteHandler(horizontalCellStyleStrategy).sheet().doWrite(getBudgetItemList());
        //EasyExcel.write(fileName, BudgetItem4read.class).sheet().doWrite(getBudgetItemList());
    }

    /**
     * 表头内容
     */
    private static List<List<String>> head() {
        List<List<String>> list = new ArrayList<List<String>>();
        List<String> head0 = new ArrayList<>();
        head0.add("序列号");
        List<String> head1 = new ArrayList<>();
        head1.add("工程项目名称");
        List<String> head2 = new ArrayList<>();
        head2.add("单位");
        List<String> head3 = new ArrayList<>();
        head3.add("数量");
        List<String> head4 = new ArrayList<>();
        head4.add("备注");
        list.add(head0);
        list.add(head1);
        list.add(head2);
        list.add(head3);
        list.add(head4);
        return list;
    }
    /**
     * 读取数据库数据
     */
    public static List<BudgetItem4write> getBudgetItemList() {
        String sql = "SELECT * FROM budgetItem4read";
        return DatabaseHelper.queryEnityList(BudgetItem4write.class, sql);
    }
}

