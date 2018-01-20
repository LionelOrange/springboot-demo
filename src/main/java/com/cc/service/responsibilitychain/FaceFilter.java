package com.cc.service.responsibilitychain;

import com.cc.model.responsibilitychain.Request;
import com.cc.model.responsibilitychain.Response;

/**
 * @author chencheng
 * @date 2018-01-20
 */
public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        //将字符串中出现的":):"转换成"^V^";
        request.setRequestStr(request.getRequestStr().replace(":):", "^V^") + "----FaceFilter()");
        chain.doFilter(request, response, chain);
        response.setResponseStr(response.getResponseStr() + "---FaceFilter()");
    }
}
