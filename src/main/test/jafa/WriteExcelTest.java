package jafa;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import pojo.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WriteExcelTest {
    @Test
    public void writeExcel() {

        String fileName = System.getProperty("user.dir") + File.separator + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        System.out.println(System.getProperty("user.dir"));
        for (User user :
                data()) {
            System.out.println(JSON.toJSONString(user));
        }
        EasyExcel.write(fileName , User.class).sheet("模板").doWrite(data());
    }

    private List<User> data() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setAge(i);
            user.setBirth("1999年1月" + i +"日");
            user.setGender(1);
            user.setName("");
            list.add(user);
        }
        return list;
    }
}
