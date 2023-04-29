package com.renchao.es;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;

import java.io.IOException;

public class HighlightTest {
    /**
     * 高亮查询
     */
    @Test
    public void testHighlight() throws IOException {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        FuzzyQueryBuilder fuzzyQuery = QueryBuilders.fuzzyQuery("name", "zhangsan");
        sourceBuilder.query(fuzzyQuery);

        //设置高亮构建对象
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<font color='red'>"); //设置前缀
        highlightBuilder.postTags("</font>");   //设置后缀
        highlightBuilder.field("name"); //设置高亮字段
        sourceBuilder.highlighter(highlightBuilder);

        SearchResponse response = SearchTest.requestAndOutput(sourceBuilder);

        // 打印高亮结果
        System.out.println("==========下面是打印的高亮===========");
        for (SearchHit hit : response.getHits()) {
            System.out.println( hit.getHighlightFields());
        }
    }
}
