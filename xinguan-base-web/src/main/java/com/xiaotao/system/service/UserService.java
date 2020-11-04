package com.xiaotao.system.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaotao.system.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xiaoge
 * @since 2020-10-29
 */
public interface UserService extends IService<User> {
    IPage<User> findUserPage(Page<User> page, QueryWrapper<User> wrapper);
}
