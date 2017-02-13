package com.fireway.testproject.utils;

import org.apache.sling.api.SlingHttpServletRequest;
import org.pac4j.core.context.Cookie;
import org.pac4j.core.context.WebContext;

import java.util.*;

/**
 * @author Alexander Mikheev
 *         Date: 13.02.17
 */
public class TestContext implements WebContext {

    private SlingHttpServletRequest request;

    public TestContext(SlingHttpServletRequest request) {
        this.request = request;
    }

    @Override
    public String getRequestParameter(String s) {
        return request.getParameter(s);
    }

    @Override
    public Map<String, String[]> getRequestParameters() {
        return request.getParameterMap();
    }

    @Override
    public Object getRequestAttribute(String s) {
        return request.getAttribute(s);
    }

    @Override
    public void setRequestAttribute(String s, Object o) {

    }

    @Override
    public String getRequestHeader(String s) {
        return request.getHeader(s);
    }

    @Override
    public void setSessionAttribute(String s, Object o) {

    }

    @Override
    public Object getSessionAttribute(String s) {
        return null;
    }

    @Override
    public Object getSessionIdentifier() {
        return request.getRequestedSessionId();
    }

    @Override
    public String getRequestMethod() {
        return request.getMethod();
    }

    @Override
    public String getRemoteAddr() {
        return request.getRemoteAddr();
    }

    @Override
    public void writeResponseContent(String s) {

    }

    @Override
    public void setResponseStatus(int i) {

    }

    @Override
    public void setResponseHeader(String s, String s1) {

    }

    @Override
    public void setResponseContentType(String s) {

    }

    @Override
    public String getServerName() {
        return request.getServerName();
    }

    @Override
    public int getServerPort() {
        return request.getServerPort();
    }

    @Override
    public String getScheme() {
        return request.getScheme();
    }

    @Override
    public boolean isSecure() {
        return request.isSecure();
    }

    @Override
    public String getFullRequestURL() {
        return request.getRequestURL().toString();
    }

    @Override
    public Collection<Cookie> getRequestCookies() {
        javax.servlet.http.Cookie[] cookies = request.getCookies();
        Collection<Cookie> pac4jCookies = new LinkedList<>();
        for (javax.servlet.http.Cookie c : cookies) {
            pac4jCookies.add(new Cookie(c.getName(), c.getValue()));
        }
        return pac4jCookies;
    }

    @Override
    public void addResponseCookie(Cookie cookie) {

    }

    @Override
    public String getPath() {
        return request.getPathInfo();
    }
}
