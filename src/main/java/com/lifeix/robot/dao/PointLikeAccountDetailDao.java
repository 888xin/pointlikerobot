package com.lifeix.robot.dao;

import com.lifeix.robot.model.PointLikeAccountDetail;

import java.util.List;

/**
 * Created by lhx on 15-2-4 下午5:08
 *
 * @project point-like-robot
 * @package com.lifeix.robot.dao
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public interface PointLikeAccountDetailDao {

    /**
     * 添加数据
     */
    public int insertPointLikeAccountDetail(PointLikeAccountDetail pointLikeAccount);

    /**
     * 获取数据
     */
    public List<PointLikeAccountDetail> getPointLikeAccountDetails(Integer sex);
}
