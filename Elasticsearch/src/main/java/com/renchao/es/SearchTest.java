package com.renchao.es;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.renchao.es.entity.Account;
import org.apache.logging.log4j.core.util.JsonUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.Avg;
import org.elasticsearch.search.aggregations.metrics.AvgAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SearchTest {

    /**
     * 请求和输出，通用方法，其他测试都会使用这个方法
     */
    public static SearchResponse requestAndOutput(SearchSourceBuilder sourceBuilder) throws IOException {
        // 获取客户端
        RestHighLevelClient client = IndexTest.getClient();
        // 搜索请求对象
        SearchRequest request = new SearchRequest("student");

        // 发送请求，并且输出请求结果
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println("took:" + response.getTook());
        System.out.println("timeout:" + response.isTimedOut());
        System.out.println("total:" + hits.getTotalHits());
        System.out.println("MaxScore:" + hits.getMaxScore());
        System.out.println("hits========>>");
        for (SearchHit hit : hits) {
            //输出每条查询的结果信息
            System.out.println(hit.getSourceAsString());
        }
        System.out.println("<<========");

        // 关闭客户端
        client.close();
        return response;
    }
    /**
     * 请求体查询
     */
    @Test
    public void testBody() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        requestAndOutput(sourceBuilder);
    }

    /**
     * term 查询，查询条件为关键字
     */
    @Test
    public void testTerm() throws IOException {
        // 构建查询的请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("age","30"));
        requestAndOutput(sourceBuilder);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPagingQuery() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        // 配置分页查询
        sourceBuilder.from(0);
        sourceBuilder.size(3);
        requestAndOutput(sourceBuilder);
    }

    /**
     * 数据排序
     */
    @Test
    public void testSort() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        // 设置排序
        sourceBuilder.sort("age", SortOrder.DESC);
        requestAndOutput(sourceBuilder);
    }

    /**
     * 过滤字段
     */
    @Test
    public void testExcludes() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchAllQuery());
        // 配置查询字段过滤
        String[] includes = {"name", "age"};
        String[] excludes = {};
        sourceBuilder.fetchSource(includes, excludes);
        requestAndOutput(sourceBuilder);
    }

    /**
     * Bool 查询
     */
    @Test
    public void testBool() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 构建Bool
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        // 必须包含
        boolQuery.must(QueryBuilders.matchQuery("age", "30"));
        // 一定不含
        boolQuery.mustNot(QueryBuilders.matchQuery("name", "zhangsan"));
        // 可能包含
        boolQuery.should(QueryBuilders.matchQuery("sex", "男"));
        // Bool导入请求体
        sourceBuilder.query(boolQuery);
        requestAndOutput(sourceBuilder);
    }

    /**
     * 范围查询
     */
    @Test
    public void testRange() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
        rangeQuery.gte(30);
        rangeQuery.lte(40);

        sourceBuilder.query(rangeQuery);
        requestAndOutput(sourceBuilder);
    }

    /**
     * 模糊查询
     */
    @Test
    public void testFuzzy() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("name", "zhangsan");
        fuzzyQuery.fuzziness(Fuzziness.ONE);
        sourceBuilder.query(fuzzyQuery);
        requestAndOutput(sourceBuilder);
    }

    /**
     * 复杂检索
     */
    @Test
    public void testComplexity() throws IOException {
        RestHighLevelClient client = IndexTest.getClient();

        // 创建检索请求,并指定索引
        SearchRequest request = new SearchRequest("bank");

        // 创建DSL，类似请求体
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询所有
        MatchAllQueryBuilder allQuery = QueryBuilders.matchAllQuery();
        sourceBuilder.query(allQuery);

        // 计算平均薪资
        AvgAggregationBuilder avgSalary = AggregationBuilders.avg("avgSalary").field("balance");
        sourceBuilder.aggregation(avgSalary);

        // 按年龄分布
        TermsAggregationBuilder builder = AggregationBuilders.terms("ageDistribution").field("age").size(10);
        // 按性别分布
        TermsAggregationBuilder distribution = AggregationBuilders.terms("genderDistribution").field("gender.keyword");

        // 不同性别平均薪资【三级】【嵌套】
        distribution.subAggregation(avgSalary);
        // 不同年龄段的性别分布情况【二级】【嵌套】
        builder.subAggregation(distribution);
        // 按年龄分布情况进行聚合【一级】
        sourceBuilder.aggregation(builder);

        // 输出查询条件
        System.out.println(sourceBuilder);

        // 构建请求
        request.source(sourceBuilder);

        // 发送请求并且获得结果
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        // 输出查询的信息
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits) {
            Account account = JSON.parseObject(hit.getSourceAsString(), Account.class);
            System.out.println(account);
        }

        Aggregations aggregations = response.getAggregations();
        Avg avgAgg = aggregations.get("avgSalary");
        System.out.println("=======整体平均薪资==========");
        System.out.println(avgAgg.getValue());

        System.out.println("=======按年龄分布情况==========");
        Terms ageDis = aggregations.get("ageDistribution");
        List<? extends Terms.Bucket> buckets = ageDis.getBuckets();
        buckets.forEach(bucket -> {
            System.out.println("======" + bucket.getKey() + "岁==========>");
            System.out.println(bucket.getDocCount() + "人");
            Terms gender = bucket.getAggregations().get("genderDistribution");
            gender.getBuckets().forEach(g->{
                System.out.println("  " + (g.getKey().equals("M")?"男":"女") + "===");
                System.out.println("  " + g.getDocCount() + " 人");
                Avg avg = g.getAggregations().get("avgSalary");
                System.out.println("  平均薪资：" + avg.getValue());
            });
        });
        client.close();
    }

}
