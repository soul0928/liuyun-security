package com.liuyun.utils.result;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName liuyun-security
 * @ClassName ResponseUtils
 * @Description
 * @Author WangDong
 * @Date 2019/10/29 14:27
 * @Version 2.1.3
 **/
@Slf4j
public class ResponseUtils {

    /**
     *  使用response输出JSON
     * @param response
     * @param result
     */
    public static void out(HttpServletResponse response, Result result){

        ServletOutputStream out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            out = response.getOutputStream();
            out.write(new Gson().toJson(result).getBytes());
        } catch (Exception e) {
            log.error(e + "输出JSON出错");
        } finally{
            if(out!=null){
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
