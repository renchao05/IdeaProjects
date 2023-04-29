package com.renchao.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GroupTest {
    /**
     * 最大年龄
     */
    @Test
    public void testGroup() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.aggregation(AggregationBuilders.max("maxAge").field("age"));
        SearchResponse response = SearchTest.requestAndOutput(sourceBuilder);
        System.out.println(response);
    }

    /**
     * 分组统计
     */
    @Test
    public void testGroupStatistics() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.aggregation(AggregationBuilders.terms("ageGroupBy").field("age"));
        SearchResponse response = SearchTest.requestAndOutput(sourceBuilder);
        System.out.println(response);
    }
}
