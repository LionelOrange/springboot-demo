package com.cc.service.responsibilitychain;

import com.cc.model.responsibilitychain.Request;
import com.cc.model.responsibilitychain.Response;

/**
 * @author chencheng
 * @date 2018-01-20
 */
public class HTMLFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        String requestStr = request.getRequestStr();
        //将字符串中出现的"<>"符号替换成"[]"
        request.setRequestStr(requestStr.replace('<', '[').replace('>', ']') + "----HTMLFilter()");
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr() + "--HTMLFilter()");
    }
}
