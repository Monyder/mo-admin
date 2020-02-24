package mon.sof.common.config.ErrorPages;

import mon.sof.common.web.base.ResultObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorPageAction {
    @RequestMapping(value = "/error400Page")
    public ResultObj error400Page() {
        ResultObj resultObj = new ResultObj();
        resultObj.setResult("400");
        resultObj.setData("服务器内部错误，请联系管理人员！");
        return resultObj;
    }
    @RequestMapping(value = "/error401Page")
    public ResultObj error401Page() {
        ResultObj resultObj = new ResultObj();
        resultObj.setResult("401");
        resultObj.setData("服务器内部错误，请联系管理人员！");
        return resultObj;
    }
    @RequestMapping(value = "/error404Page")
    public ResultObj error404Page() {
        ResultObj resultObj = new ResultObj();
        resultObj.setResult("404");
        resultObj.setData("找不到页面，页面飞走了！");
        return resultObj;
    }
    @RequestMapping(value = "/error500Page")
    public ResultObj error500Page(){
        ResultObj resultObj = new ResultObj();
        resultObj.setResult("500");
        resultObj.setData("服务器内部错误，请联系管理人员！");
        return resultObj;
    }
}
