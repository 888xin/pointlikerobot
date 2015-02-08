package com.lifeix.robot.mongo;

import com.lifeix.robot.vo.AccountContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by lhx on 15-2-6 下午8:11
 *
 * @project point-like-robot
 * @package com.lifeix.robot.service.impl
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
@Service
public class PointLikeAccountMongoService {

    @Autowired
    private MongoTemplate mongoTemplate ;

    /**
     * 插入数据
     * @param dashboardId
     * @param accountId
     * @param createTime
     */
    public void insert(long dashboardId, long accountId, Date createTime) {
        AccountContentVO accountContentVO = new AccountContentVO();
        accountContentVO.setAccountId(accountId);
        accountContentVO.setDashboardId(dashboardId);
        accountContentVO.setStatus(false);
        accountContentVO.setCreateTime(createTime);
        mongoTemplate.insert(accountContentVO,"accountcontent");
    }

    /**
     * 根据状态获取数据
     * @param status true表示处理过的，false表示未处理过
     * @return AccountContentVO集合
     */
    public List<AccountContentVO> get(boolean status) {
        return mongoTemplate.find(new Query(Criteria.where("status").is(status)), AccountContentVO.class, "accountcontent");
    }

    /**
     * 获取minutes内新插入的数据
     * @param minutes minutes分钟内
     * @return AccountContentVO集合
     */
    public List<AccountContentVO> getByTime(int minutes){
        //现在的时间
        Date currentTime = new Date();
        //minutes分钟前
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, -minutes);
        Date end = cal.getTime();
        Query query = new Query();
        Criteria criteria = Criteria.where("createTime").gte(end).lte(currentTime);
        query.addCriteria(criteria);
        return mongoTemplate.find(query, AccountContentVO.class, "accountcontent");
    }

    public List<AccountContentVO> getByNumbers(boolean status, int numbers){
        return mongoTemplate.find(new Query(Criteria.where("status").is(status)).limit(numbers), AccountContentVO.class, "accountcontent");
    }

    /**
     * 根据文章号更新状态，false变为true
     * @param dashboardId 文章ID
     */
    public void update(long dashboardId){
        mongoTemplate.upsert(new Query(Criteria.where("dashboardId").is(dashboardId)), Update.update("status", true), "accountcontent");
    }
}
