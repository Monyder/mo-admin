package mon.sof.project.sys.sysInfoItem.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sys.sysInfoItem.service.SysInfoItemService;

/**
 * <p>
 * 信息项表 前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-12-17
 */
@RestController
@RequestMapping("/sysInfoItem/sys-info-item")
public class SysInfoItemController {

    @Autowired
    private SysInfoItemService sysinfoitemService;

}

