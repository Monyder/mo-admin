package mon.sof.project.sysLog.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mon.sof.common.orm.ResultObj;
import mon.sof.project.sysLog.entity.SysLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sysLog.service.SysLogService;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-10-15
 */
@RestController
@RequestMapping("/sysLog/sys-log")
public class SysLogController {

    @Autowired
    private SysLogService syslogService;

    /**
     * 查询所有日志
     *
     * @Author zhangxiaomei
     * @Date 2020-08-20 10:45:05
     * @Param
     * @Return
     */
    @PostMapping("/findAll")
    public ResultObj findAll(@RequestParam(defaultValue = "0") int pageNum,
                             @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<SysLog> logQueryWrapper = new QueryWrapper<>();
        logQueryWrapper.orderByDesc("operating_time");
        List<SysLog> list = syslogService.list(logQueryWrapper);
        return ResultObj.resp(new PageInfo<>(list));
    }


    /**
     * 按条件查询日志
     * @Author  zhangxiaomei
     * @Date    2020-08-20 11:27:37
     * @Param
     * @Return
     */
    @PostMapping("/findLogByCondition")
    public ResultObj findLogByCondition(@RequestParam(defaultValue = "0") int pageNum,
                                        @RequestParam(defaultValue = "10") int pageSize,
                                        @RequestParam(defaultValue = "") String name,
                                        @RequestParam(defaultValue = "") String ip,
                                        @RequestParam(defaultValue = "") String func,
                                        @RequestParam(defaultValue = "") String startOperatingTime,
                                        @RequestParam(defaultValue = "") String endOperatingTime) {
        PageHelper.startPage(pageNum, pageSize);
        QueryWrapper<SysLog> logQueryWrapper = new QueryWrapper<>();
        if (StrUtil.isNotEmpty(name)) logQueryWrapper.like("operator", name);
        if (StrUtil.isNotEmpty(ip)) logQueryWrapper.like("ip", ip);
        if (StrUtil.isNotEmpty(func)) logQueryWrapper.eq("func", func);
        if (StrUtil.isNotEmpty(startOperatingTime) || StrUtil.isNotEmpty(endOperatingTime))
            logQueryWrapper.between("operating_time", startOperatingTime, endOperatingTime);
        logQueryWrapper.orderByDesc("operating_time");
        List<SysLog> list = syslogService.list(logQueryWrapper);
        return ResultObj.resp(new PageInfo<>(list));
    }

}

