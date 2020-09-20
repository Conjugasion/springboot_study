package com.example.springaopdemo.Controller;

import com.example.springaopdemo.Entity.Person;
import com.example.springaopdemo.Service.AsyncTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author Lucas
 * @date 2020/9/19 16:19
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    // private Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    AsyncTaskService asyncTaskService;

    @Value("${book.title}")
    private String title;

    @Value("${book.price}")
    private String price;

    @RequestMapping("/book")
    public String getBook() {
        log.info(title + ":" + price);
        return title + ":" + price;
    }

    @RequestMapping("/liveload")
    public String liveload() {
        log.info("liveload");
        return "liveload";
    }

    @RequestMapping("/converter")
    public String converter() {
        log.info("自定义消息转换器--防止出现乱码");
        return "自定义消息转换器--防止出现乱码";
    }

    @RequestMapping("/jsonTool")
    public Object jsonTool() {
        log.info("不采用springboot默认json转换器，使用fastjson");
        Person p = new Person();
        p.setName("Lucas");
        p.setAge(26);
        p.setBirthday(new Date());
        log.info(String.valueOf(p.getBirthday().getTime()));
        return p;
    }

    @RequestMapping("/exception")
    public Object exception() {
        log.info("全局异常处理器");
        int i = 1/0;
        return i;
    }

    @RequestMapping("/asyncTask")
    public String asyncTask() throws Exception{
        log.info("异步调用task");
        long start = System.currentTimeMillis();
        Future<String> t1 = asyncTaskService.taskOne();
        Future<String> t2 = asyncTaskService.taskTwo();
        Future<String> t3 = asyncTaskService.taskThree();
        while (!t1.isDone() || !t2.isDone() || !t3.isDone()) {
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        long time = end-start;
        log.info("三个异步任务全部执行完成，总耗时: " + time + "毫秒");
        return "三个异步任务全部执行完成，总耗时: " + time + "毫秒";
    }
}