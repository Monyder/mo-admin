package mon.sof.common.web;


import mon.sof.common.util.ExcelUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/web")
public class WebController {

    /**
     * 下载excel
     *
     * @Title: downloadExcel
     * @Description:
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/download/excel")
    public void downloadExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ExcelUtils.downloadFile(request, response);
    }

}
