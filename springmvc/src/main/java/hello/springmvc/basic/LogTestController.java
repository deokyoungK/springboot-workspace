package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LogTestController {


    @GetMapping("/log-test")
    public String logTest(){
        String name = "Kang";

        log.trace("trace log={}", name);
        log.debug("trace log={}", name);
        log.info("trace log={}", name);
        log.warn("trace log={}", name);
        log.error("trace log={}", name);

        //로그를 사용하지 않아도 a+b계산이 먼저 실행된다. 매우 안좋은 방식.
        log.debug("String concat log="+name);
        return "ok";


    }
}
