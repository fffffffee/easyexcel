package util;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserExcelListener extends AnalysisEventListener<User> {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserExcelListener.class);

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 2;
    List<User> list = new ArrayList<User>(BATCH_COUNT);


    public void invoke(User user , AnalysisContext analysisContext) {
        LOGGER.info("解析到一条数据:{}" , JSON.toJSONString(user));
        list.add(user);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！" , list.size());
        LOGGER.info("存储数据库成功！");
    }

}
