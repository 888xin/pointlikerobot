package com.lifeix.test;

import com.lifeix.robot.dao.PointLikeAccountDao;
import com.lifeix.robot.dao.PointLikeAccountDetailDao;
import com.lifeix.robot.model.PointLikeAccount;
import com.lifeix.robot.model.PointLikeAccountDetail;
import com.lifeix.robot.vo.AccountContentVO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by xin on 15-2-7 上午10:45
 *
 * @project pointlikerobot
 * @package com.lifeix.test
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */

public class MyTest {

    private PointLikeAccountDao pointLikeAccountDao ;
    private PointLikeAccountDetailDao pointLikeAccountDetailDao ;
    private MongoTemplate mongoTemplate;


    @Before
    public void before(){
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:application.xml"
                ,"classpath:spring-mybatis.xml"});
        pointLikeAccountDao = (PointLikeAccountDao) context.getBean("pointLikeAccountDao");
        pointLikeAccountDetailDao = (PointLikeAccountDetailDao) context.getBean("pointLikeAccountDetailDao");
        mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
    }

    /**
     * ==============================================================
     */

    @Test
    public void testinsertPraiseUser(){
        PointLikeAccount pointLikeAccount = new PointLikeAccount();
        pointLikeAccount.setPointGender(1);
        pointLikeAccount.setPointAccountId(254234);
        System.out.println(pointLikeAccountDao.insertpointLikeAccount(pointLikeAccount));
    }

    @Test
    public void testgetPraiseUser(){
        List<PointLikeAccount> list = pointLikeAccountDao.getpointLikeAccounts(1);
        System.out.println(list);
    }

    /**
     * ==============================================================
     */

    @Test
    public void testinsertPointLikeAccount(){
        PointLikeAccountDetail pointLikeAccountDetail = new PointLikeAccountDetail();
        pointLikeAccountDetail.setId(1L);
        pointLikeAccountDetail.setPointAccountId(2L);
        pointLikeAccountDetail.setPointedAccountId(3L);
        pointLikeAccountDetail.setPointedGender(1);
        pointLikeAccountDetail.setPointGender(0);
        pointLikeAccountDetail.setPointedRoot(34444L);
        pointLikeAccountDetail.setPointTime(new Date());
        pointLikeAccountDetail.setRemark("测试");
        System.out.println(pointLikeAccountDetailDao.insertPointLikeAccountDetail(pointLikeAccountDetail));
    }

    /**
     * =============================
     */

    @Test
    public void testmongoTemplate(){
        AccountContentVO accountContentVO = new AccountContentVO();
        accountContentVO.setAccountId("2");
        accountContentVO.setDashboardId("32");
        accountContentVO.setStatus(false);
        accountContentVO.setCreateTime(new Date());
        mongoTemplate.insert(accountContentVO,"accountcontent");
    }

//    @Test
//    public void testjson(){
//        JSONObject json = JSON.parseObject("{\"dashboardId\":6787578,\"accountId\":1000,\"createTime\":\"2015-12-12 12:35:123\"}");
//        System.out.println(json.get("dashboardId"));
//    }
}
