//package ny.qingyi.test.contorller;
//
//import ny.qingyi.test.aware.MyTestAware;
//import ny.qingyi.test.pojo.Person;
//import ny.qingyi.test.service.PlayService;
//import com.qytp.common.config.QytpProterties;
//import com.qytp.core.thread.QytpExecutor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.Map;
//import java.util.concurrent.LinkedBlockingDeque;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author wenan.ren
// * @date 2022/8/31 17:21
// * @Description
// */
//@RestController
//public class TestContorller {
//
//    @Autowired
//    private PlayService playService;
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Autowired
//    private Map<String,PlayService> map;
//
//    @Autowired
//    private QytpExecutor qingyiTestThreadPool;
//
//    @Autowired
//    private QytpExecutor threadPoolTest01;
//
//    @Resource
//    private QytpProterties qingyiTPProterties;
//
////    @Value("${qingyi.tp.test}")
////    private String testString;
//
//    @RequestMapping("/testPrimary")
//    private String test01(){
//        playService.play();
//        return "success";
//    }
//
//    @RequestMapping("/testAware")
//    private String testAware(){
//
//        new ThreadPoolExecutor(10, 20, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread();
//            }
//        });
//
//        PlayService dogPlayServiceImpl = map.get("dogPlayServiceImpl");
//        dogPlayServiceImpl.play();
//        PlayService dogPlayService = applicationContext.getBean("dogPlayServiceImpl", PlayService.class);
//        Person beanByClass = MyTestAware.getBean(Person.class);
//        PlayService playService = MyTestAware.getBean(PlayService.class);
//        return "success";
//    }
//}