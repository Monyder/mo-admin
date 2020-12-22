package mon.sof.project.sys.sysDataType.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mon.sof.common.orm.Resp;
import mon.sof.project.sys.sysDataType.entity.SysDataType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sys.sysDataType.service.SysDataTypeService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
@RestController
@RequestMapping("/sysDataType/sys-data-type")
public class SysDataTypeController {

    @Autowired
    private SysDataTypeService sysdatatypeService;


    /**
     * 获取所有数据类型
     *
     * @Author zhangxiaomei
     * @Date 2020-12-22 10:25:05
     * @Param []
     * @Return mon.sof.common.orm.Resp
     */
    @GetMapping("/findDataType")
    public Resp findDataType() {
        return Resp.ok(sysdatatypeService.list(new QueryWrapper<SysDataType>().orderByAsc("sort")));
    }

}

