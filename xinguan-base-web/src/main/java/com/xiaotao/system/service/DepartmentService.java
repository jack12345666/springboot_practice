package com.xiaotao.system.service;

import com.xiaotao.system.entity.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xiaotao
 * @since 2020-10-31
 */
public interface DepartmentService extends IService<Department> {
    List<Department> findDeptAndCount();
}
