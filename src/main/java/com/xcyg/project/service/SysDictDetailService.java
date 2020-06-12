package com.xcyg.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xcyg.project.entity.SysDictDetailEntity;

/**
 * 数据字典详情
 *
 * @author manager
 * @email *****@mail.com
 * @date 2020-04-30 15:13:16
 */
public interface SysDictDetailService extends IService<SysDictDetailEntity> {

    IPage<SysDictDetailEntity> listByPage(Page page, String dictId);
}

