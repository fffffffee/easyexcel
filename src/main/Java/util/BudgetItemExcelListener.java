package util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import helper.DatabaseHelper;
import mapper.BeanMapConvert;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.BudgetItem;

import java.beans.IntrospectionException;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 概算项目读取类
 *
 * @author dazuo
 * @date 20210214
 * @version 1.0.0
 */
public class BudgetItemExcelListener extends AnalysisEventListener<BudgetItem> {
    private static final Logger LOGGER = LoggerFactory.getLogger(BudgetItemExcelListener.class);

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list，方便内存回收。
     */
    private static final int BATCH_COUNT =5;
    List<BudgetItem> list = new ArrayList<BudgetItem>();

    private BudgetItem budgetItem;
    public BudgetItemExcelListener(){
        budgetItem = new BudgetItem();
    }

    /**
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        LOGGER.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
        System.out.println("解析到一条头数据:" + JSON.toJSONString(headMap));
    }
    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *  one row value. It is same as{@link //Todo}
     */
    @Override
    public void invoke(BudgetItem data, AnalysisContext context) {
        PropertyConfigurator.configure(System.getProperty("user.dir") + File.separator + "src/main/resources/log4j.properties");
        LOGGER.info("解析到一条数据:{}", JSON.toJSONString(data));
        if((data.getSerialnumberofstandard() != null)&&(data.getSerialnumberofstandard().contains("Y")||data.getSerialnumberofstandard().contains("G"))) {
            System.out.println("解析到一条数据：" + JSON.toJSONString(data));
            list.add(data);
        }

        //达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            try {
                saveData();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IntrospectionException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了，都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        //这里也要保存数据，确保最后遗留的数据也存储到数据库
        try {
            saveData();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        LOGGER.info("所有数据解析完成！");
        System.out.println("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        for (BudgetItem budgetItem : list) {
            System.out.println(JSON.toJSON(budgetItem));
            Map budgetItemMap = BeanMapConvert.convertBean(budgetItem);
            DatabaseHelper.insertEntity(BudgetItem.class, budgetItemMap);
        }
        LOGGER.info("{}条数据，开始存储数据库！", list.size());
        LOGGER.info("存储数据库成功！");
        System.out.println(list.size() + "条数据，开始存储数据库！");
        System.out.println("存储数据库成功！");
    }
}
