package cn.quguai.restfulcrud;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExepctionHandler {

    @ResponseBody
    @ExceptionHandler()
    public Map<String, Object> handlerException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "User");
        request.setAttribute("key", map);
        return map;
    }
}
