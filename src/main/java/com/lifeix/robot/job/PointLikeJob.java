package com.lifeix.robot.job;


import com.lifeix.robot.dao.PointLikeAccountDao;
import com.lifeix.robot.dao.PointLikeAccountDetailDao;
import com.lifeix.robot.model.PointLikeAccount;
import com.lifeix.robot.model.PointLikeAccountDetail;
import com.lifeix.robot.mongo.PointLikeAccountMongoService;
import com.lifeix.robot.vo.AccountContentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by xin on 15-2-7 上午10:32
 *
 * @project praiseRobot
 * @package com.lifeix.robot.task
 * @Description
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
@Service
public class PointLikeJob {

    @Autowired
    private PointLikeAccountDao pointLikeAccountDao ;
    @Autowired
    private PointLikeAccountDetailDao pointLikeAccountDetailDao ;
    @Autowired
    private PointLikeAccountMongoService pointLikeAccountMongoService;


    public void work(){
        System.out.println("work");
        //获取需要判断的用户列表
        List<AccountContentVO> accountContentVOList = pointLikeAccountMongoService.get(false);
        if (accountContentVOList == null || accountContentVOList.size()==0){
            System.out.println("work is over!");
        } else {
            //现在的时间
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String startdate = formatter.format(currentTime);
            //一个月前
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.MONTH, -1);
            String enddate = formatter.format(cal.getTime());
            for (AccountContentVO accountContentVO : accountContentVOList) {
                //更新mongodb数据，把状态设为true
                pointLikeAccountMongoService.update(accountContentVO.getDashboardId());
                //循环判断是否需要点赞
                //int n = commentServiceClient.getAccountLikeNOByTime(Long.valueOf(pointedAccountId), false, startdate, enddate);
                int n = 13 ;
                if (n < 15) {
                    //获取点赞人，分男女
                    List<PointLikeAccount> listboy = pointLikeAccountDao.getpointLikeAccounts(1);
                    List<PointLikeAccount> listgirl = pointLikeAccountDao.getpointLikeAccounts(0);
                    //被点赞人性别
                    int pointedGender = accountContentVO.getPointedGender();
                    //被点赞人accountID
                    long pointedAccountId = accountContentVO.getAccountId();
                    //被点赞人文章ID
                    long dashboardId = accountContentVO.getDashboardId();
                    //3-15的点赞数
                    int repeatcounts = (int)Math.round(Math.random()*15) + 3 ;
                    for (int i = 0; i < repeatcounts; i++) {
                        //主键生成
                        //Long gobalKey = IdentityUtil.getLocalCacheId(CommonConstant.APPLICATION_CONTENT_CENTER,RobotModuleEnums.POINT_LIKE_ROBOT.getName(), RobotTableEnums.POINT_LIKE_ACCOUNT_DETAIL.getName());
                        Long gobalKey = (long)Math.round(Math.random()*1000000000);
                        //点赞人随机性别 一方占70%，另一方占30%
                        int sexrandom = (int)Math.round(Math.random()*10) ;
                        //与被点赞人性别相反
                        if (sexrandom < 8){
                            if (pointedGender == 1){
                                //女性点赞人
                                savelike(listgirl, pointedGender, pointedAccountId, dashboardId, gobalKey);
                            } else {
                                //男性点赞人
                                savelike(listboy, pointedGender, pointedAccountId, dashboardId, gobalKey);
                            }
                        } else {
                            if (pointedGender == 1){
                                //男性点赞人
                                savelike(listboy, pointedGender, pointedAccountId, dashboardId, gobalKey);
                            } else {
                                //女性点赞人
                                savelike(listgirl, pointedGender, pointedAccountId, dashboardId, gobalKey);
                            }
                        }
                    }
                } else {

                }
            }
        }
    }

    private void savelike(List<PointLikeAccount> list, int pointedGender, long pointedAccountId, long dashboardId, Long gobalKey) {
        //获取点赞人
        int pointrandom = (int)Math.round(Math.random()*(list.size())) ;
        PointLikeAccount pointLikeAccount = list.get(pointrandom);
        //去掉使用的点赞人，防止重复。
        list.remove(pointrandom);
        PointLikeAccountDetail pointLikeAccountDetail = new PointLikeAccountDetail();
        pointLikeAccountDetail.setId(gobalKey);
        //被点赞人性别
        pointLikeAccountDetail.setPointedGender(pointedGender);
        //被点赞人accountID
        pointLikeAccountDetail.setPointedAccountId(pointedAccountId);
        //点赞人性别
        pointLikeAccountDetail.setPointGender(0);
        //点赞人的accountID
        pointLikeAccountDetail.setPointAccountId(pointLikeAccount.getPointAccountId());
        //点赞时间
        pointLikeAccountDetail.setPointTime(new Date());
        //被点赞文章ID
        pointLikeAccountDetail.setDashboardId(dashboardId);
        //点赞表情，五个随机中获取
        int likeExpression = (int)Math.round(Math.random()*5) ;
        pointLikeAccountDetail.setLikeExpression(likeExpression);
        pointLikeAccountDetailDao.insertPointLikeAccountDetail(pointLikeAccountDetail);
        //点赞间隔intervalSeconds
        int intervalSeconds = (int)Math.round(Math.random()*60) + 20 ;
        try {
            Thread.sleep(1000L*intervalSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
