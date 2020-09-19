package com.dean.filter;

import com.dean.common.auth.entity.Payload;
import com.dean.common.auth.entity.UserInfo;
import com.dean.common.auth.utils.JwtUtils;
import com.dean.common.utils.CookieUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/8/12 21:48
 */
@EnableConfigurationProperties({JwtProperties.class,FilterProperties.class})
public class AuthFilter extends ZuulFilter {

    @Autowired
    private JwtProperties jwtProp;

    @Autowired
    private FilterProperties filterProp;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 过滤类型--在路由之前过滤
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤顺序--优先级
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return FilterConstants.FORM_BODY_WRAPPER_FILTER_ORDER - 1;
    }

    /**
     * 是否过滤--白名单放行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //过滤器白名单列表
        List<String> allowPaths = filterProp.getAllowPaths();
        //获取上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取请求对象
        HttpServletRequest request = ctx.getRequest();
        //获取请求地址
        String requestURI = request.getRequestURI();
        //判断--白名单放行
        for (String allowPath : allowPaths) {
            if (requestURI.startsWith(allowPath)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 过滤器执行的操作
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //获取上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取请求对象
        HttpServletRequest request = ctx.getRequest();
        try {
            //获取Token
            String token = CookieUtils.getCookieValue(request, jwtProp.getUser().getCookieName());
            //解析token
            Payload<UserInfo> payload = JwtUtils.getInfoFromToken(token, jwtProp.getPublicKey(), UserInfo.class);
            //获取用户信息
            UserInfo userInfo = payload.getUserInfo();
            //用户角色信息
            String role = userInfo.getRole();
            //获取资源路径
            String requestURI = request.getRequestURI();
            String method = request.getMethod();
            // TODO 判断用户权限--权限管理
            logger.info("【网关】用户{},角色{},访问服务{} : {}，", userInfo.getUsername(), role, method, requestURI);
        } catch (Exception e) {
            // 校验出现异常，返回403
            logger.error("非法访问，未登录，地址：{}", request.getRemoteHost(), e);
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
        }
        return null;
    }
}
