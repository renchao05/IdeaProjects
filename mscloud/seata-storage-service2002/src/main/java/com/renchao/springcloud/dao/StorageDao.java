package com.renchao.springcloud.dao;

import com.renchao.springcloud.domain.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {

    void updateStorage(@Param("productId") Long productId, @Param("count") Integer count);
}
