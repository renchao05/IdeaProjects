package com.renchao.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.junit.Test;

import java.io.IOException;

public class IndexTest {

    /**
     * 创建客户端
     */
    public static RestHighLevelClient getClient() {
        HttpHost http = new HttpHost("192.168.123.205", 9200, "http");
        RestClientBuilder builder = RestClient.builder(http);
        return new RestHighLevelClient(builder);
    }
    /**
     * 创建索引
     */
    @Test
    public void testCreate() throws IOException {
        RestHighLevelClient client = getClient();
        // 获取索引操作客户端
        IndicesClient indices = client.indices();
        // 创建索引的请求对象
        CreateIndexRequest request = new CreateIndexRequest("user");
        // 发送请求，获取响应
        CreateIndexResponse response = indices.create(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
        // 关闭客户端
        client.close();
    }

    /**
     * 查看索引
     */
    @Test
    public void testGet() throws IOException {
        RestHighLevelClient client = getClient();
        IndicesClient indices = client.indices();
        // 查看索引的请求对象
        GetIndexRequest request = new GetIndexRequest("shopping");
        // 发送请求，获取响应
        GetIndexResponse response = indices.get(request, RequestOptions.DEFAULT);
        System.out.println("aliases:"+response.getAliases());
        System.out.println("mappings:"+response.getMappings());
        System.out.println("settings:"+response.getSettings());

        client.close();
    }

    /**
     * 删除索引
     */
    @Test
    public void testDelete() throws IOException {
        RestHighLevelClient client = getClient();
        IndicesClient indices = client.indices();
        // 查看索引的请求对象
        DeleteIndexRequest request = new DeleteIndexRequest("shopping");
        // 发送请求，获取响应
        AcknowledgedResponse response = indices.delete(request, RequestOptions.DEFAULT);
        System.out.println("操作结果 ： " + response.isAcknowledged());

        client.close();
    }
}
