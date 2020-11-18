package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoTestController {

    private final ObjectProvider<MyLogger> myLogger;
    private final LogDemoTestService logDemoTestService;

    @RequestMapping("log-demo1")
    @ResponseBody
    public String logDemoTest(HttpServletRequest request){
        String url = request.getRequestURL().toString();
        MyLogger logger = this.myLogger.getObject();
        logger.setRequestURL(url);
        logger.log("이것이 로그다");
        logDemoTestService.logic("testID00");

        return "OK";
    }


}
