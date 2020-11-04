package com.xiaotao.system.service.impl;

import com.xiaotao.system.entity.Log;
import com.xiaotao.system.mapper.LogMapper;
import com.xiaotao.system.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志表 服务实现类
 * </p>
 *
 * @author xiaotao
 * @since 2020-10-31
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

}
