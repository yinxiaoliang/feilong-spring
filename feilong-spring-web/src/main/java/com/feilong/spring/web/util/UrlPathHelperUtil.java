/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.spring.web.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.util.UrlPathHelper;

/**
 * UrlPathHelper.
 * 
 * @author <a href="http://feitianbenyue.iteye.com/">feilong</a>
 * @since 1.0.4
 */
public class UrlPathHelperUtil{

    /** Don't let anyone instantiate this class. */
    private UrlPathHelperUtil(){
        //AssertionError不是必须的. 但它可以避免不小心在类的内部调用构造器. 保证该类在任何情况下都不会被实例化.
        //see 《Effective Java》 2nd
        throw new AssertionError("No " + getClass().getName() + " instances for you!");
    }

    /**
     * 显示 属性 一般 debug 使用 看看
     * 
     * <pre class="code">
     * 示例 _search-filter-search.jsp为 被 jspinclude 的 页面
     * 
     * http//www.feilong.com8888/converse/s/c-m-c-s-k-s-o.htm?keyword=%E9%9E%8B
     * urlPathHelper.getContextPath(request)/converse
     * urlPathHelper.getOriginatingContextPath(request)/converse
     * urlPathHelper.getOriginatingQueryString(request)keyword=%E9%9E%8B
     * urlPathHelper.getOriginatingRequestUri(request)/converse/s/c-m-c-s-k-s-o.htm
     * urlPathHelper.getPathWithinApplication(request)/product/_search-filter-search.jsp
     * urlPathHelper.getPathWithinServletMapping(request)
     * urlPathHelper.getRequestUri(request)/converse/product/_search-filter-search.jsp
     * urlPathHelper.getServletPath(request)/product/_search-filter-search.jsp
     * </pre>
     * 
     * <pre class="code">
     * http//www.feilong.com8888/s/c-m-c-s-k-s-o.htm?keyword=%E9%9E%8B
     * urlPathHelper.getContextPath(request)
     * urlPathHelper.getOriginatingContextPath(request)
     * urlPathHelper.getOriginatingQueryString(request)keyword=%E9%9E%8B
     * urlPathHelper.getOriginatingRequestUri(request)/s/c-m-c-s-k-s-o.htm
     * urlPathHelper.getPathWithinApplication(request)/product/_search-filter-search.jsp
     * urlPathHelper.getPathWithinServletMapping(request)
     * urlPathHelper.getRequestUri(request)/product/_search-filter-search.jsp
     * urlPathHelper.getServletPath(request)/product/_search-filter-search.jsp
     * </pre>
     * 
     * @param request
     *            the request
     * @return the url path helper map for log
     */
    public static Map<String, Object> getUrlPathHelperMapForLog(HttpServletRequest request){
        Map<String, Object> map = new LinkedHashMap<>();

        UrlPathHelper urlPathHelper = new UrlPathHelper();

        map.put("urlPathHelper.getContextPath(request)", urlPathHelper.getContextPath(request));
        map.put("urlPathHelper.getLookupPathForRequest(request)", urlPathHelper.getLookupPathForRequest(request));
        map.put("urlPathHelper.getOriginatingContextPath(request)", urlPathHelper.getOriginatingContextPath(request));
        map.put("urlPathHelper.getOriginatingQueryString(request)", urlPathHelper.getOriginatingQueryString(request));
        map.put("urlPathHelper.getOriginatingRequestUri(request)", urlPathHelper.getOriginatingRequestUri(request));

        // 3.1.0
        map.put("urlPathHelper.getOriginatingServletPath(request)", urlPathHelper.getOriginatingServletPath(request));

        map.put("urlPathHelper.getPathWithinApplication(request)", urlPathHelper.getPathWithinApplication(request));
        map.put("urlPathHelper.getPathWithinServletMapping(request)", urlPathHelper.getPathWithinServletMapping(request));
        map.put("urlPathHelper.getRequestUri(request)", urlPathHelper.getRequestUri(request));
        map.put("urlPathHelper.getServletPath(request)", urlPathHelper.getServletPath(request));

        return map;
    }
}
