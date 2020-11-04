package com.xiaotao.system.service.impl;

import com.xiaotao.system.entity.Department;
import com.xiaotao.system.mapper.DepartmentMapper;
import com.xiaotao.system.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xiaotao
 * @since 2020-10-31
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public List<Department> findDeptAndCount() {
        return departmentMapper.findDeptAndCount();
    }
}
