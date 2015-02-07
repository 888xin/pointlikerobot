package com.lifeix.robot.model;

import java.io.Serializable;

/**
 * Created by lhx on 15-2-4 下午2:28
 *
 * @project point-like-robot
 * @package com.lifeix.robot.dao
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class PointLikeAccount implements Serializable {

    private int id ;
    private int pointAccountId ;
    private int pointGender ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointAccountId() {
        return pointAccountId;
    }

    public void setPointAccountId(int pointAccountId) {
        this.pointAccountId = pointAccountId;
    }

    public int getPointGender() {
        return pointGender;
    }

    public void setPointGender(int pointGender) {
        this.pointGender = pointGender;
    }
}
