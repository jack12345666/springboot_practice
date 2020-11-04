package com.xiaotao.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaotao.handler.BusinessException;
import com.xiaotao.response.Result;
import com.xiaotao.response.ResultCodeImpl;
import com.xiaotao.system.dto.UserSearchDto;
import com.xiaotao.system.entity.User;
import com.xiaotao.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xiaoge
 * @since 2020-10-29
 */
@RestController
@RequestMapping("/user")
@Api(value = "系统用户模块", tags = "系统用户接口")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    @ApiOperation(value = "用户列表", notes = "查询所有用户")
    public Result findUsers(@RequestParam(required = true,defaultValue = "1") Integer currentPage,
                            @RequestParam(required = true,defaultValue = "10") Integer pageSize) {
        Page<User> page = new Page<>(currentPage, pageSize);
        Page<User> userPage = userService.page(page);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        boolean b = userPage.hasNext();
        long current = userPage.getCurrent();
        long pages = userPage.getPages();
        return Result.ok().data("total",total).
                data("hasMore", b).data("currentPage",current).
                data("pages",pages).data("pageSize",pageSize).data("users",records);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "用户信息", notes = "通过id查询用户信息")
    public Result getUserById(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if (user != null) {
            return Result.ok().data("user", user);
        } else {
            throw new BusinessException(ResultCodeImpl.USER_NOT_FOUND.getCode(), ResultCodeImpl.USER_NOT_FOUND.getMessage());
        }
    }

    @PostMapping("/findUserPage")
    @ApiOperation(value = "查询用户-条件", notes = "查询所有用户")
    public Result findUserPage(@RequestParam(required = true,defaultValue = "1") Integer currentPage,
                               @RequestParam(required = true,defaultValue = "10") Integer pageSize,
                               @RequestBody  UserSearchDto userSearchDto) {
        Page<User> page = new Page<>(currentPage, pageSize);
        QueryWrapper<User> wrapper = getWrapper(userSearchDto);
        IPage<User> userPage = userService.findUserPage(page, wrapper);
        long total = userPage.getTotal();
        List<User> records = userPage.getRecords();
        long current = userPage.getCurrent();
        long pages = userPage.getPages();
        return Result.ok().data("total",total)
                .data("currentPage",current).
                data("pages",pages).data("pageSize",pageSize).data("users",records);
    }


    private QueryWrapper<User> getWrapper(UserSearchDto userSearchDto) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(userSearchDto != null) {
            if(!StringUtils.isEmpty(userSearchDto.getDepartmentId())) {
                queryWrapper.eq("department_id", userSearchDto.getDepartmentId());
            }
            if(!StringUtils.isEmpty(userSearchDto.getEmail())) {
                queryWrapper.eq("email", userSearchDto.getEmail());
            }
            if(!StringUtils.isEmpty(userSearchDto.getNickname())) {
                queryWrapper.eq("nickname", userSearchDto.getNickname());
            }
            if(!StringUtils.isEmpty(userSearchDto.getSex())) {
                queryWrapper.eq("sex", userSearchDto.getSex());
            }
            if(!StringUtils.isEmpty(userSearchDto.getUsername())) {
                queryWrapper.eq("username", userSearchDto.getUsername());
            }
        }
        return queryWrapper;
    }
}

