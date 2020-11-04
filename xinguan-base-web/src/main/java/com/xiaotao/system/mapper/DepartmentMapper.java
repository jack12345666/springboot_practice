package com.xiaotao.system.mapper;

import com.xiaotao.system.entity.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xiaotao
 * @since 2020-10-31
 */
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> findDeptAndCount();
}
