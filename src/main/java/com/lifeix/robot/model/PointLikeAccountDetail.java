package com.lifeix.robot.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lhx on 15-2-4 下午5:02
 *
 * @project point-like-robot
 * @package com.lifeix.robot.model
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class PointLikeAccountDetail implements Serializable {

    private Long id ;
    private Long pointAccountId ;
    private Integer pointGender ;
    private Long pointedAccountId ;
    private Integer pointedGender ;
    private Date pointTime ;
    private String remark ;
    private Long dashboardId ;
    private Integer likeExpression; //点赞表情

    public Integer getLikeExpression() {
        return likeExpression;
    }

    public void setLikeExpression(Integer likeExpression) {
        this.likeExpression = likeExpression;
    }

    public Long getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(Long dashboardId) {
        this.dashboardId = dashboardId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPointAccountId() {
        return pointAccountId;
    }

    public void setPointAccountId(Long pointAccountId) {
        this.pointAccountId = pointAccountId;
    }

    public Integer getPointGender() {
        return pointGender;
    }

    public void setPointGender(Integer pointGender) {
        this.pointGender = pointGender;
    }

    public Long getPointedAccountId() {
        return pointedAccountId;
    }

    public void setPointedAccountId(Long pointedAccountId) {
        this.pointedAccountId = pointedAccountId;
    }

    public Integer getPointedGender() {
        return pointedGender;
    }

    public void setPointedGender(Integer pointedGender) {
        this.pointedGender = pointedGender;
    }

    public Date getPointTime() {
        return pointTime;
    }

    public void setPointTime(Date pointTime) {
        this.pointTime = pointTime;
    }
}
