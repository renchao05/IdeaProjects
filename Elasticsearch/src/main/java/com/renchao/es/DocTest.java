package com.renchao.es;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renchao.es.entity.User;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class DocTest {

    /**
     * 新增文档
     */
    @Test
    public void testAdd() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();

        // 新增文档的请求对象,并设置索引
        IndexRequest request = new IndexRequest("user");
        // 设置文档的唯一标识
        request.id("1001");

        // 创建文档对象
        User user = new User("zhangshan", 30, "男");
        ObjectMapper mapper = new ObjectMapper();
        String userJson = mapper.writeValueAsString(user);

        // 向请求对象中添加文档，格式为Json
        request.source(userJson, XContentType.JSON);

        // 客户端发送请求，获取响应对象
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        // 打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());
        client.close();
    }

    /**
     * 修改文档
     */
    @Test
    public void testUpdate() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();
        // 创建修改文档的请求对象
        UpdateRequest request = new UpdateRequest("user", "1001");
        // 设置请求体
        request.doc(XContentType.JSON, "sex", "女55");
        // 发送请求
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);

        System.out.println("_index:" + response.getIndex());
        System.out.println("_id:" + response.getId());
        System.out.println("_result:" + response.getResult());

        client.close();
    }

    /**
     * 查询文档
     */
    @Test
    public void testGet() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();
        GetRequest request = new GetRequest("user","1001");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);

        // 打印结果信息
        System.out.println("_index:" + response.getIndex());
        System.out.println("_type:" + response.getType());
        System.out.println("_id:" + response.getId());
        System.out.println("source:" + response.getSourceAsString());
    }

    /**
     * 删除文档
     */
    @Test
    public void testDelete() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();
        DeleteRequest request = new DeleteRequest("user", "1001");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
    }

    /**
     * 批量新增
     */
    @Test
    public void testBulk() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("user").id("1001").source(XContentType.JSON, "name", "张三"));
        request.add(new IndexRequest("user").id("1002").source(XContentType.JSON, "name", "李四"));
        request.add(new IndexRequest("user").id("1003").source(XContentType.JSON, "name", "王五"));
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println("took:" + responses.getTook());
        System.out.println("items:" + Arrays.toString(responses.getItems()));
    }

    /**
     * 批量删除
     */
    @Test
    public void testBulkDelete() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest("user", "1001"));
        request.add(new DeleteRequest("user", "1002"));
        request.add(new DeleteRequest("user", "1003"));
        BulkResponse responses = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println("took:" + responses.getTook());
    }
}
