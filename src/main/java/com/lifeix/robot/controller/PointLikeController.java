package com.lifeix.robot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
* Created by lhx on 15-2-5 下午2:49
*
* @project point-like-robot
* @package com.lifeix.robot.controller
* @Description
* @blog http://blog.csdn.net/u011439289
* @email 888xin@sina.com
* @github https://github.com/888xin
*/
@Controller
@RequestMapping("/robot")
public class PointLikeController {

//    @Autowired
//    private Determine determine ;
//    @Autowired
//    private AccountCommonAction accountCommonAction ;
//    @Autowired
//    private PointLikeAccountJob pointLikeAccountJob ;
//    @Autowired
//    private PointLikeJob pointLikeJob ;
//
//
    @RequestMapping("/runjob")
    public ModelAndView runJob(String pointedAccountId, String pointedGender){
//        System.out.println(pointedAccountId + "====" + pointedGender);
//        SchedulerQuartz schedulerQuartz = new SchedulerQuartz();
//        try {
//            schedulerQuartz.run(pointedAccountId,pointedGender);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        //未来3-10分钟内触发
//        int minutes = (int)Math.round(Math.random()*7) + 3 ;
//        //3-15的点赞数
//        int repeatcounts = (int)Math.round(Math.random()*15) + 3 ;
//        //点赞间隔intervalSeconds
//        int intervalSeconds = (int)Math.round(Math.random()*60) + 20 ;
//        try {
////            Thread.sleep(1000L * 60 * minutes);
//            System.out.println(minutes);
//            Thread.sleep(1000L * minutes);
//            pointLikeAccountJob.work(pointedAccountId, pointedGender);
//            for (int i = 0; i < repeatcounts; i++) {
//                System.out.println(repeatcounts);
//                System.out.println(intervalSeconds);
//                Thread.sleep(1000L * intervalSeconds);
//                pointLikeAccountJob.work(pointedAccountId, pointedGender);
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return null ;

    }

    /**
     * 跳入service层判断用户发表的内容是否需要点赞
     * @param pointedAccountId
     * @return
     */
    @RequestMapping("/determineaccount")
    public String determineAccount(String pointedAccountId){
//        if (!"".equals(pointedAccountId)){
//            long accountid = Long.valueOf(pointedAccountId);
//            //需要点赞的用户
//            if ( determine.determineAccount(accountid) ){
//                //查找用户文章、性别
////                com.l99.dto.account.Account account = userService.userinfo(accountid);
////                int gender = account.getAccountType();
////                return "redirect:/robot/runjob?pointedGender="+gender + "&pointedAccountId=" + accountid ;
//                String content = accountCommonAction.findAccountProfileById(accountid);
//                String pointedGender = content.substring(content.indexOf("gender") + 8, content.indexOf("gender") + 9);
//                return "redirect:/robot/runjob.do?pointedAccountId=" + accountid + "&pointedGender=" + pointedGender ;
//            } else {
//                System.out.println( accountCommonAction.findAccountProfileById(accountid));
//                return "redirect:/robot/backfalse.do" ;
//            }
//        } else {
//            return "redirect:/robot/backfalse.do" ;
//        }
        return null ;
    }

    @RequestMapping("/backfalse")
    @ResponseBody
    public Map<String,Object> backfalse(){
        Map<String,Object> outmap = new HashMap<String, Object>();
        outmap.put("flag",false);
        return outmap ;
    }
}
