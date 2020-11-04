package com.xiaotao.system.controller;


import com.xiaotao.handler.BusinessException;
import com.xiaotao.response.Result;
import com.xiaotao.response.ResultCodeImpl;
import com.xiaotao.system.entity.Department;
import com.xiaotao.system.service.DepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xiaotao
 * @since 2020-10-31
 */
@RestController
@RequestMapping("/department")
@Api(value = "部门模块", tags = "部门人数接口")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation(value = "查询部门及人数",notes = "查询部门及人数")
    @GetMapping("/findDeptAndCount")
    public Result findDeptAndCount() {
        List<Department> deptAndCount = departmentService.findDeptAndCount();
        if(deptAndCount.size() == 0) {
            throw new BusinessException(ResultCodeImpl.DEPT_NOT_FOUND.getCode(),
                    ResultCodeImpl.DEPT_NOT_FOUND.getMessage());
        }else {
            return Result.ok().data("departments", deptAndCount);
        }
    }
}

