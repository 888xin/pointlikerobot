package com.lifeix.robot.mongo;

import com.lifeix.robot.vo.AccountContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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


    public void save(String dashboardId, String accountId) {
        AccountContentVO accountContentVO = new AccountContentVO();
        accountContentVO.setAccountId(accountId);
        accountContentVO.setDashboardId(dashboardId);
        accountContentVO.setStatus(false);
        accountContentVO.setCreateTime(new Date());
        mongoTemplate.insert(accountContentVO,"accountcontent");
    }


    public List<AccountContentVO> get(boolean status) {
        return mongoTemplate.find(new Query(Criteria.where("status").is(status)), AccountContentVO.class, "accountcontent");
    }
}
