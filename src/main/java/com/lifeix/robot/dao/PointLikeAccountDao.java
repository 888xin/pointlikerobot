package com.lifeix.robot.dao;

import com.lifeix.robot.model.PointLikeAccount;

import java.util.List;

/**
 * Created by lhx on 15-2-4 下午2:30
 *
 * @project point-like-robot
 * @package com.lifeix.robot.dao
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public interface PointLikeAccountDao {

    /**
     * 添加数据
     */
    public int insertpointLikeAccount(PointLikeAccount pointLikeAccount);

    public List<PointLikeAccount> getpointLikeAccounts(int sex);
}
