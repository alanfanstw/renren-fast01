package io.renren;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;

public class Alibabaxls {

	@Test
	public void noModelMultipleSheet() throws Exception {
		
		long start = System.currentTimeMillis();
		
		File file = new File("D:\\pd\\item\\aaa.xls");
        InputStream inputStream = FileUtils.openInputStream(file);
        try {
            ExcelReader reader = new ExcelReader(inputStream, ExcelTypeEnum.XLS, null,
                new AnalysisEventListener<List<String>>() {
                    @Override
                    public void invoke(List<String> object, AnalysisContext context) {
                        System.out.println(
                            "当前sheet:" + context.getCurrentSheet().getSheetNo() + " 当前行：" + context.getCurrentRowNum()
                                + " data:" + object);
                    }
                    @Override
                    public void doAfterAllAnalysed(AnalysisContext context) {

                    }
                });
//            26442
            reader.read();
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        System.out.println(System.currentTimeMillis()-start);
    }
}
