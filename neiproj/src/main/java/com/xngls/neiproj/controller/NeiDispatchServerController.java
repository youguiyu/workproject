package com.xngls.neiproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;

@Controller
@RequestMapping(value = "neidsproj")
public class NeiDispatchServerController {

    @ResponseBody
    @RequestMapping(value = "/toDoDispatch", produces = {"application/json;charset=UTF-8"})
    public String toDoDispatch(        HttpServletRequest request,
                                       HttpServletResponse response){
        System.out.println("进入派单接口");

        StringBuffer json = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                System.out.println("line:" + line);
                json.append(line);
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }
        System.out.println(json.toString());
        return "suc";
    }
}
