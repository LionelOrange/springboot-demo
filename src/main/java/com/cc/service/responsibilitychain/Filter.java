package com.cc.service.responsibilitychain;

import com.cc.model.responsibilitychain.Request;
import com.cc.model.responsibilitychain.Response;

/**
 * @author chencheng
 * @date 2018-01-20
 */
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
