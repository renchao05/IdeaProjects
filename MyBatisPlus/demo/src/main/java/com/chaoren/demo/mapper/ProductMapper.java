package com.chaoren.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chaoren.demo.bean.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper extends BaseMapper<Product> {
}
