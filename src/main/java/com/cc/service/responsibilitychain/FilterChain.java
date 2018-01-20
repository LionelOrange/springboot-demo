package com.cc.service.responsibilitychain;

import com.cc.model.responsibilitychain.Request;
import com.cc.model.responsibilitychain.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chencheng
 * @date 2018-01-20
 */
public class FilterChain implements Filter {
    private List<Filter> filterList =new ArrayList<>();

    int index = 0;

    public FilterChain addFilter(Filter f){
        filterList.add(f);
        return this;
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        if (index==filterList.size()){
            return;
        }
        Filter filter = filterList.get(index);
        index++;
        filter.doFilter(request,response,chain);
    }
}
