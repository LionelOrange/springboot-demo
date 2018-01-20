package com.cc.service.responsibilitychain;

import com.cc.model.responsibilitychain.Request;
import com.cc.model.responsibilitychain.Response;

/**
 * @author chencheng
 * @date 2018-01-20
 */
public class SensitiveFilter implements Filter{
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //过滤敏感字眼的处理
        request.setRequestStr(request.getRequestStr().replace("恐怖","**")+"--SensitiveFilter()");
        chain.doFilter(request,response,chain);
        response.setResponseStr(response.getResponseStr()+"---SensitiveFilter()");
    }
}
