package com.lifeix.robot.util;

import java.io.*;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by lhx on 15-1-5 下午1:44
 *
 * @project anti
 * @package com.lifeix.anti.common.util
 * @Description 读文件操作类
 * @blog http://blog.csdn.net/u011439289
 * @email 888xin@sina.com
 * @github https://github.com/888xin
 */
public class ReadFile {

    public static String[] readTxtByLine(File file){
        try {
            //字符流
            FileReader reader = new FileReader(file) ;
            BufferedReader br = new BufferedReader(reader);
            String line = "" ;
            StringBuilder buffer = new StringBuilder();
            while ((line = br.readLine()) != null){
                buffer.append(line).append("-----");
            }
            int n = buffer.lastIndexOf("-----") ;
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            String[] arrs = buffer.toString().split("-----");
            br.close();
            reader.close();
            return arrs ;
        } catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

    public static String[] readTxtByLine(File file, String encode){
        try {
            //字节流
            FileInputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in,encode);
            BufferedReader br = new BufferedReader(isr);
            String line = "" ;
            StringBuilder buffer = new StringBuilder();
            while ((line = br.readLine()) != null){
                buffer.append(line).append("-----");
            }
            int n = buffer.lastIndexOf("-----") ;
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            buffer.deleteCharAt(n);
            String[] arrs = buffer.toString().split("-----");
            br.close();
            isr.close();
            in.close();
            return arrs ;
        } catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

    public static String readTxt(File file, String encode){
        try {
            //字节流
            FileInputStream in = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(in,encode);
            BufferedReader br = new BufferedReader(isr);
            String line = "" ;
            StringBuilder buffer = new StringBuilder();
//            buffer.append(file.getAbsolutePath());
            while ((line = br.readLine()) != null){
                buffer.append(line);
            }
            br.close();
            isr.close();
            in.close();
            return buffer.toString() ;
        } catch (Exception e){
            e.printStackTrace();
            return null ;
        }
    }

    public static Set<String> ReadTxtInDirectory(String strPath){
        File path = new File(strPath);
        if (!path.exists() || !path.isDirectory()){
            return null ;
        } else {
            String[] files = path.list();
            Set<String> set = new HashSet<String>();
            for (String file : files) {
                if (file != null && !"".equals(file) && file.endsWith(".txt")){
                    String string = readTxt(new File(strPath + File.separator + file), "UTF-8");
                    set.add(string);
                }
            }
            return set ;
        }
    }

    public static void main(String[] args) throws IOException, SQLException {




//        File file = new File("C:\\Users\\Lifeix\\Desktop\\文档中含有敏感词汇\\新建文本文档.txt");
//        String[] strs = readTxtByLine(file,"gbk");
//        StringBuilder stringBuilder1 = new StringBuilder();
//        List<String> list = new ArrayList<String>();
//        for (String str : strs) {
//            str = str.trim();
//            if (!"".equals(str) && str != null && str.length()>2){
//                String str1 = SplitSentence.splitWordBySpace(str) ;
//                str1 = MyStringUtil.deleteChineseCharacter(str1);
//                str1 = MyStringUtil.formatChinese(str1).trim();
//                if (!"".equals(str1)){
//                    System.out.println(str1);
//                    stringBuilder1.append(str).append(":::::").append(str1).append("======");
//                } else {
//                    list.add(str);
//                }
//            }
//        }
//        String[] strs1 = stringBuilder1.toString().split("======");
//        WriteLines writeLines = new WriteLines(new File("C:\\Users\\Lifeix\\Desktop\\all\\新建文件夹\\01.txt"));
//        writeLines.WriteLineByEncode(strs1,"gbk");
//        int length = list.size();
//        String[] strs2 = new String[length];
//        for (int i = 0; i < length; i++) {
//            strs2[i] = list.get(i);
//        }
//        WriteLines writeLines2 = new WriteLines(new File("C:\\Users\\Lifeix\\Desktop\\all\\新建文件夹\\02.txt"));
//        writeLines2.WriteLineByEncode(strs2,"gbk");









//        //读入整个文件夹里面的txt文档
//        String pref = "13" ;
//        String strPath = "C:\\Users\\Lifeix\\Desktop\\all\\new_dir\\" + pref ;
//        File path = new File(strPath);
//        Map<String,String> map = new HashMap<String, String>();
//        if (!path.exists() || !path.isDirectory()){
//            System.out.println("");
//        } else {
//            String[] files = path.list();
//            for (String file : files) {
//                if (file != null && !"".equals(file) && file.endsWith(".txt")){
//                    //读入文档内容
//                    String string = readTxt(new File(strPath + File.separator + file), "UTF-8");
//                    map.put(file, string);
//                }
//            }
//        }
//        StringBuilder stringBuilder1 = new StringBuilder();
//        List<String> list = new ArrayList<String>();
//            for (String key : map.keySet()) {
//                String str = map.get(key);
//                str = str.trim();
//                if (!"".equals(str)){
//                    str = SplitSentence.splitWordBySpace(str) ;
//                    str = MyStringUtil.deleteChineseCharacter(str);
//                    str = MyStringUtil.formatChinese(str).trim();
//                    if (!"".equals(str)){
//                        System.out.println(str);
//                        stringBuilder1.append(key).append(":::::").append(str).append("======");
//                    } else {
//                        list.add(key);
//                    }
//                }
//
//            }
//        String[] strs1 = stringBuilder1.toString().split("======");
//        //生成文件夹
//        String createPath = "C:\\Users\\Lifeix\\Desktop\\文档中含有敏感词汇\\" + pref ;
//        File createfile = new File(createPath);
//        if (!createfile .exists()){
//            createfile.mkdir();
//        }
//        WriteLines writeLines = new WriteLines(new File(createPath + "\\有敏感词.txt"));
//        writeLines.WriteLineByEncode(strs1,"gbk");
//        int length = list.size();
//        String[] strs2 = new String[length];
//        for (int i = 0; i < length; i++) {
//            strs2[i] = list.get(i);
//        }
//        WriteLines writeLines2 = new WriteLines(new File(createPath + "\\无敏感词.txt"));
//        writeLines2.WriteLineByEncode(strs2,"gbk");




        //数据库插入数据
//        File file = new File("C:\\Users\\Lifeix\\Desktop\\all\\新建文件夹\\去重后.txt");
//        String[] strs = readTxtByLine(file,"gbk");
//        Connection connection = JdbcUtils.getConnection("jdbc:mysql://192.168.2.3:3306/anti_center","skst","TestDBSkst$@");
//        String sql = "INSERT into illegal_user_info(id,illegal_user_register_info,status,remarks) VALUES(?,?,?,?)";
//        PreparedStatement prest = connection.prepareStatement(sql);
//        long n = 1 ;
//        for (String str : strs) {
//            prest.setLong(1, n);
//            prest.setString(2, str.trim());
//            prest.setBoolean(3, true);
//            prest.setString(4, "非法账户名");
//            n ++ ;
//            prest.execute();
//        }
//        JdbcUtils.free(null, null, connection);



        String str = "";
        str = str.replaceAll(" ","\t") ;
        System.out.println(str);


//        File file = new File("C:\\Users\\Lifeix\\Desktop\\敏感词库\\我\\立方敏感内容.txt");
//        String[] strs = readTxtByLine(file,"gbk");
//        List<String> list = new ArrayList<String>();
//        for (String str : strs) {
//            String[] sss = str.split(",");
//            for (String ss : sss) {
//                list.add(ss);
//            }
//        }
//        String[] ss2 = new String[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ss2[i] = list.get(i);
//        }
//        WriteLines writeLines = new WriteLines(new File("C:\\Users\\Lifeix\\Desktop\\敏感词库\\我\\分开敏感词2.txt"));
//        writeLines.WriteLineByEncode(ss2,"gbk");

//        File file = new File("C:\\Users\\Lifeix\\Desktop\\3.txt");
//        String[] strs = readTxtByLine(file,"gbk");
//        Connection connection = JdbcUtils2.getConnection("jdbc:mysql://192.168.2.3:3306/anti_center?characterEncoding=UTF8",
//                "skst", "TestDBSkst$@") ;
//        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
//        Map<String, Object> map = null ;
//        for (int i = 0; i < strs.length; i++) {
//            map = new HashMap<String, Object>();
//            map.put("serviceKind", "10,11,12");
//            map.put("sensitive_word", strs[i]);
//            mapList.add(map);
//        }
//        JdbcUtils2.update(connection, "sensitive_word", mapList, "serviceKind", "sensitive_word");
//
//        //用完数据库，释放连接
//        JdbcUtils2.free(null,null,connection);





//        Connection connection = JdbcUtils2.getConnection("jdbc:mysql://localhost:3306/song?characterEncoding=UTF8",
//                "root", "465864") ;
//        for (int i = 1; i < 81; i++) {
//            File file = new File("C:\\Users\\Lifeix\\Desktop\\歌词\\" + i + ".txt");
//            String[] strs = readTxtByLine(file,"utf-8");
//
//            String sql1 = "insert into track(tid, trackname, singername) values (?,?,?)" ;
//            JdbcUtils2.insert(connection, sql1, i+"" ,strs[0], strs[1] + strs[2]);
//
//            String sql2 = "insert into lyrics(tid, lrc) values (?,?)" ;
//            StringBuilder s = new StringBuilder();
//            for (int j = 3; j < strs.length; j++) {
//                s.append(strs[j]);
//            }
//            JdbcUtils2.insert(connection, sql2, i+"" ,s.toString());
//        }
//
//
//        //用完数据库，释放连接
//        JdbcUtils2.free(null,null,connection);
    }
}
