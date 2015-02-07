package com.lifeix.robot.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lhx on 15-2-6 下午6:49
 *
 * @project point-like-robot
 * @package com.lifeix.robot.vo
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class AccountContentVO implements Serializable {

    private long dashboardId ;
    private long accountId ;
    private int pointedGender ;
    private Date createTime ;
    private boolean status ;

    public long getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(long dashboardId) {
        this.dashboardId = dashboardId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getPointedGender() {
        return pointedGender;
    }

    public void setPointedGender(int pointedGender) {
        this.pointedGender = pointedGender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
