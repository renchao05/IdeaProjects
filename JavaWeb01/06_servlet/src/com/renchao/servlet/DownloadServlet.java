package com.renchao.servlet;

//import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = "222.jpg";    //文件名
        String file = "file/" + fileName;   //文件路径
        ServletContext context = getServletContext();   //获取ServletContext对象
        String mimeType = context.getMimeType(file);    //获取文件类型
        resp.setContentType(mimeType);  //告诉客户端返回的数据类型
        resp.setHeader("Content-Disposition","attachment;filename=" + fileName);    //告诉客户端文件用于下载
        InputStream inputStream = context.getResourceAsStream(file);    //通过ServletContext对象创建输入流
        ServletOutputStream outputStream = resp.getOutputStream();  //获取输出流
//        IOUtils.copy(inputStream, outputStream);    //把输入流拷贝到输出流
    }
}
