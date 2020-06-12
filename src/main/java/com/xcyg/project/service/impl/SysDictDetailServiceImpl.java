package com.xcyg.project.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xcyg.project.mapper.SysDictDetailMapper;
import com.xcyg.project.entity.SysDictDetailEntity;
import com.xcyg.project.service.SysDictDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service("sysDictDetailService")
public class SysDictDetailServiceImpl extends ServiceImpl<SysDictDetailMapper, SysDictDetailEntity> implements SysDictDetailService {

    @Autowired
    private SysDictDetailMapper sysDictDetailMapper;

    @Override
    public IPage<SysDictDetailEntity> listByPage(Page page, String dictId) {
        return sysDictDetailMapper.listByPage(page, dictId);
    }
}