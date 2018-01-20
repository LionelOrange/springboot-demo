package com.cc.controller.responsibilitychain;

import com.cc.model.responsibilitychain.Request;
import com.cc.model.responsibilitychain.Response;
import com.cc.service.responsibilitychain.FaceFilter;
import com.cc.service.responsibilitychain.FilterChain;
import com.cc.service.responsibilitychain.HTMLFilter;
import com.cc.service.responsibilitychain.SensitiveFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chencheng
 * @date 2018-01-20
 */
@Controller
public class FilterController {
    @RequestMapping("/filter/chain.do")
    public String getHtml(ModelMap modelMap){
        return "responsibilitychain/chain";
    }

    @RequestMapping("/filter/chain.json")
    @ResponseBody
    public Map<String,Object> json(String text){
        Map<String,Object> map=new HashMap<>();
        //创建责任链
        FilterChain chain=new FilterChain();
        //添加过滤器并排定顺序
        chain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        //参数
        Request request=new Request();
        request.setRequestStr(text);
        Response response=new Response();
        //执行过滤
        chain.doFilter(request,response,chain);
        //输出
        map.put("filterText",request.getRequestStr());
        //打印过程
        System.out.println(request.getRequestStr());
        System.out.println(response.getResponseStr());
        return map;
    }
}
