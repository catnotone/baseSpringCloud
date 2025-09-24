package org.huangge.userservice.config;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class HeaderOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {  //解析请求头
        String origin = httpServletRequest.getHeader("origin");
        if(StringUtils.isEmpty(origin)) {
            return "blank";
        }
        return origin;
    }
}

