package com.chaoren.datasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chaoren.datasource.bean.Product;
import com.chaoren.datasource.mapper.ProductMapper;
import com.chaoren.datasource.service.ProductService;
import org.springframework.stereotype.Service;

@DS("slave_1")//指定所操作的数据源
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
