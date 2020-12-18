package mon.sof.project.sys.sysDataType.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import mon.sof.project.sys.sysDataType.service.SysDataTypeService;

/**
 * <p>
 *  前端控制器
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

}

