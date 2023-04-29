//package com.renchao.servlet;
//
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import javax.servlet.ServletException;
//import javax.servlet.ServletInputStream;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.List;
//
//public class UploadServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if (ServletFileUpload.isMultipartContent(req)) {
//            DiskFileItemFactory factory = new DiskFileItemFactory();
//            ServletFileUpload upload = new ServletFileUpload(factory);
//            upload.setHeaderEncoding("utf-8");
//            try {
//                List<FileItem> list = upload.parseRequest(req);
//                for (FileItem fileItem : list) {
//                    if (fileItem.isFormField()) {
//                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
//                        System.out.println("表单项的value属性值：" + fileItem.getString("utf-8"));
//                    } else {
//                        System.out.println("表单项的name属性值：" + fileItem.getFieldName());
//                        System.out.println("上传的文件名：" + fileItem.getName());
//                        fileItem.write(new File("d:\\" + fileItem.getName()));
//                    }
//                }
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
