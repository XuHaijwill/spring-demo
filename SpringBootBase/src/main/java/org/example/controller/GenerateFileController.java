package org.example.controller;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.util.PoitlIOUtils;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * @ClassName GenerateFileController
 * @Description //TODO https://blog.csdn.net/SongZhengxing_/article/details/139149531
 * @Author XuHaijwill
 * @Date 2024/7/11 8:47
 * @Version 1.0
 **/
@Api(tags = "模板管理")
@RestController
@RequestMapping("/word")
public class GenerateFileController {

    @GetMapping("getWord")
    public void getWord(String name, Integer age, HttpServletResponse response) {
        // 定义模板对应的数据
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", name);
        data.put("age", age);

        // 加载本地模板文件
        InputStream inputStream = getClass().getResourceAsStream("/演示模板1.docx");

        // 渲染模板
        XWPFTemplate template = XWPFTemplate.compile(inputStream).render(data);

        // 设置响应头，指定文件类型和内容长度
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=output.docx");

        try {
            // 返回网络流
            ServletOutputStream out = response.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(out);
            template.write(bos);
            bos.flush();
            out.flush();
            // 关闭流
            PoitlIOUtils.closeQuietlyMulti(template, bos, out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
