package util;
import com.alibaba.excel.context.AnalysisContext;
public class ExcelListener extends AnalysisEventListener {
    private List<Object> datas = new ArrayList<Object>();

    public void invoke(Object o , AnalysisContext analysisContext) {
        datas.add(o);
    }

}
