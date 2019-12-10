package com.mogo.main;

import com.mogo.main.model.Personal;
import com.mogo.main.service.Calcu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@Controller
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/getData")
    @ResponseBody
    public void getData(List<Personal> personalList) {
        try {
            log.info(personalList.toString());
            if (personalList.size() > 0) {
                //TODO    返回类型基础数据
                //List<String, List<String,String>>() a= new ArrayList<String,List<String,String>>();

            }
        } catch (Exception e) {
            log.error("send e:" + e.getMessage());
        }
    }

    @RequestMapping("/getResult")
    @ResponseBody
    public Map<String,Object> getResult(String str) {
        try {
            if(Utils.isBlank(str)){
                str ="1213";
            }
            log.info(str);
            if (Utils.isNotBlank(str)) {
                //TODO    返回类型结果
                Map<String,Object> resultMap = new HashMap<String,Object>();
                resultMap.put("resultCode","0000");
                resultMap.put("resultMap",new Calcu().calResult(str));
                return resultMap;
            }

        } catch (Exception e) {
            log.error("send e:" + e.getMessage());
        }
        return new HashMap<>();
    }
}
