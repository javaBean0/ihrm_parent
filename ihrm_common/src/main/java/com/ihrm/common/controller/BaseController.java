package com.ihrm.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

    public HttpServletRequest request;
    public HttpServletResponse response;
    public String companyId;

    public void setRespAndReq(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        //TODO
        //暂时不处理
        this.companyId = "1";

    }


}
