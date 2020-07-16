package mon.sof.project.legalDate.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import mon.sof.common.orm.ResultObj;
import mon.sof.project.legalDate.entity.LegalDate;
import mon.sof.project.legalDate.service.LegalDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zxm
 * @since 2020-03-17
 */
@RestController
@RequestMapping("/legalDate/legal-date")
public class LegalDateController {

    @Autowired
    private LegalDateService legalDateService;

    @GetMapping("/addNongli")
    public ResultObj addNongli(){
        String s[] = {"元旦节","春节","清明节","劳动节","端午节","中秋节","国庆节"};
        for (int i = 0; i < 20; i++) {
            LegalDate legalDate = new LegalDate();
            for (int j = 0; j < s.length; j++) {
                legalDate.setLegalName(s[j]);
                legalDateService.save(legalDate);
            }
        }
        return ResultObj.resp();
    }

    @GetMapping("/addNongLiDate")
    public ResultObj addNongLiDate(){
        QueryWrapper<LegalDate> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.isNull("date");
        List<LegalDate> list = legalDateService.list(objectQueryWrapper);
        int dateyuandan = 2031;
        int datewuyi = 2031;
        int dateshiyi = 2031;
        String yuandan = "-01-01";
        String wuyi = "-05-01";
        String shiyi = "-10-01";
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getLegalName().equals("元旦节")){
                if(list.get(i).getDate() == null){
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(dateyuandan).append(yuandan);
                    DateTime parse = DateUtil.parse(stringBuffer.toString(), "yyyy-MM-dd");
                    list.get(i).setDate(parse);
                    legalDateService.updateById(list.get(i));
                }
                dateyuandan++;
            }
            if(list.get(i).getLegalName().equals("劳动节")){
                if(list.get(i).getDate() == null){
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(datewuyi).append(wuyi);
                    DateTime parse = DateUtil.parse(stringBuffer.toString(), "yyyy-MM-dd");
                    list.get(i).setDate(parse);
                    legalDateService.updateById(list.get(i));
                }
                datewuyi++;
            }
            if(list.get(i).getLegalName().equals("国庆节")){
                if(list.get(i).getDate() == null){
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(dateshiyi).append(shiyi);
                    DateTime parse = DateUtil.parse(stringBuffer.toString(), "yyyy-MM-dd");
                    list.get(i).setDate(parse);
                    legalDateService.updateById(list.get(i));
                }
                dateshiyi++;
            }

        }

        return ResultObj.resp();
    }

    public static void main(String[] args) throws Exception {

        // 创建接收端
        DatagramSocket ds = new DatagramSocket(9003);

        /**
         * 接收数据包
         * receive(DatagramPacket p)
         * 从这个套接字接收数据报包。
         */
        byte[] data = new byte[1024];
        while (true){
            DatagramPacket dp = new DatagramPacket(data, data.length);
            ds.receive(dp);

            // 获取接受到的信息
            String str = new String(data, 0, dp.getLength());
            System.out.println(str);
        }

    }


}

