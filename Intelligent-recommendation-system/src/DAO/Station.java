package DAO;
 
 
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Util.JDBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
  
/**
 * desc：地铁站对象
 * @author chaisson
 * @since 2015-5-31 上午10:22:44
 *
 */
class Station {
     
    private String name; //地铁站名称，假设具备唯一性
     
    public Station prev; //本站在lineNo线上面的前一个站
     
    public Station next; //本站在lineNo线上面的后一个站
     
    //本站到某一个目标站(key)所经过的所有站集合(value)，保持前后顺序
    private Map<Station,LinkedHashSet<Station>> orderSetMap = new HashMap<Station,LinkedHashSet<Station>>();
     
    public Station (String name){
        this.name = name;
    }
  
    public Station  () {
        // TODO Auto-generated constructor stub
    }
 
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
     
    public LinkedHashSet<Station> getAllPassedStations(Station station) {
        if(orderSetMap.get(station) == null){
            LinkedHashSet<Station> set = new LinkedHashSet<Station>(); 
            set.add(this);
            orderSetMap.put(station, set);
        }
        return orderSetMap.get(station);
    }
  
    public Map<Station, LinkedHashSet<Station>> getOrderSetMap() {
        return orderSetMap;
    }
     
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
     
    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }
}
  
/**
 * desc：利用Dijkstra算法，计算地铁站经过路径，以南京地铁为例
 * @author chaisson
 * @since 2015-5-31 上午9:43:38
 *
 */
class Subway {
     
    private List<Station> outList = new ArrayList<Station>();//记录已经分析过的站点
     
    //计算从s1站到s2站的最短经过路径
    public void calculate(Station s1,Station s2){
        if(outList.size() == Subwayline.totalStaion){
            System.out.println("找到目标站点："+s2.getName()+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
            for(Station station : s1.getAllPassedStations(s2)){
                System.out.print(station.getName()+"->");
            }
            return;
        }
        if(!outList.contains(s1)){
            outList.add(s1);
        }
        //如果起点站的OrderSetMap为空，则第一次用起点站的前后站点初始化之
        if(s1.getOrderSetMap().isEmpty()){
            List<Station> Linkedstations = getAllLinkedStations(s1);
            for(Station s : Linkedstations){
                s1.getAllPassedStations(s).add(s);
            }
        }
        Station parent = getShortestPath(s1);//获取距离起点站s1最近的一个站（有多个的话，随意取一个）
        if(parent == s2){
            System.out.println("找到目标站点："+s2+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
            for(Station station : s1.getAllPassedStations(s2)){
                System.out.print(station.getName()+"->");
            }
            return;
        }
        for(Station child : getAllLinkedStations(parent)){
            if(outList.contains(child)){
                continue;
            }
            int shortestPath = (s1.getAllPassedStations(parent).size()-1) + 1;//前面这个1表示计算路径需要去除自身站点，后面这个1表示增加了1站距离
            if(s1.getAllPassedStations(child).contains(child)){
                //如果s1已经计算过到此child的经过距离，那么比较出最小的距离
                if((s1.getAllPassedStations(child).size()-1) > shortestPath){
                    //重置S1到周围各站的最小路径
                    s1.getAllPassedStations(child).clear();
                    s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                    s1.getAllPassedStations(child).add(child);
                }
            } else {
                //如果s1还没有计算过到此child的经过距离
                s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                s1.getAllPassedStations(child).add(child);
            }
        }
        outList.add(parent);
        calculate(s1,s2);//重复计算，往外面站点扩展
    }
     
    //取参数station到各个站的最短距离，相隔1站，距离为1，依次类推
    private Station getShortestPath(Station station){
        int minPatn = Integer.MAX_VALUE;
        Station rets = null;
        for(Station s :station.getOrderSetMap().keySet()){
            if(outList.contains(s)){
                continue;
            }
            LinkedHashSet<Station> set  = station.getAllPassedStations(s);//参数station到s所经过的所有站点的集合
            if(set.size() < minPatn){
                minPatn = set.size();
                rets = s;
            }
        }
        return rets;
    }
     
    //获取参数station直接相连的所有站，包括交叉线上面的站
    private List<Station> getAllLinkedStations(Station station){
        List<Station> linkedStaions = new ArrayList<Station>();
        for(List<Station> line : Subwayline.lineSet){
            if(line.contains(station)){//如果某一条线包含了此站，注意由于重写了hashcode方法，只有name相同，即认为是同一个对象
                Station s = line.get(line.indexOf(station));
                if(s.prev != null){
                    linkedStaions.add(s.prev);
                }
                if(s.next != null){
                    linkedStaions.add(s.next);
                }
            }
        }
        return linkedStaions;
    }
  
    /**
     * desc: How to use the method
     * author chaisson
     * since 2015-5-31
     * version 1.0
     */
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        Subway sw = new Subway();
        sw.calculate(new Station("北海山"), new Station("北豆"));
        long t2 = System.currentTimeMillis();
        System.out.println();
        System.out.println("耗时："+(t2-t1)+"ms");
    }
}



 
class Subwayline {
    public static List<Station> line1 = new ArrayList<Station>();//1号线
    public static List<Station> line2 = new ArrayList<Station>();//2号线
    public static List<Station> line3 = new ArrayList<Station>();//3号线
    public static List<Station> line4 = new ArrayList<Station>();//10号线
    public static List<Station> line5 = new ArrayList<Station>();//s1号线
    public static List<Station> line6 = new ArrayList<Station>();//s8号线
    public static Set<List<Station>> lineSet = new HashSet<List<Station>>();//所有线集合
    public static int totalStaion = 0;//总的站点数量
    static Connection conn;
    static PreparedStatement ps = null;
    static ResultSet rs;
    static String sql = "select * from line1";
    //1号线
     
        public static List<Station> load1(){
            conn=JDBUtil.getConn();
            ps=null;
            ResultSet rs=null;
            String id;
            sql="select name from line1 ";
//          sql="select * from station where Id between ? and ? order by Id";
            List<Station> users=new ArrayList<Station>();
            Station user=null;
            try {
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()) {
                    user=new Station();
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                     if(ps!=null)ps.close();
                     if(conn!=null)conn.close();
                 }catch(Exception e2) {
                     e2.printStackTrace();
                 }
            }
            return users;
        }
         
        public static List<Station> load2(){
            conn=JDBUtil.getConn();
            ps=null;
            ResultSet rs=null;
            String id;
            sql="select name from line2 ";
//          sql="select * from station where Id between ? and ? order by Id";
            List<Station> users=new ArrayList<Station>();
            Station user=null;
            try {
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()) {
                    user=new Station();
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                     if(ps!=null)ps.close();
                     if(conn!=null)conn.close();
                 }catch(Exception e2) {
                     e2.printStackTrace();
                 }
            }
            return users;
        }
         
        public static List<Station> load3(){
            conn=JDBUtil.getConn();
            ps=null;
            ResultSet rs=null;
            String id;
            sql="select name from line3 ";
//          sql="select * from station where Id between ? and ? order by Id";
            List<Station> users=new ArrayList<Station>();
            Station user=null;
            try {
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()) {
                    user=new Station();
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                     if(ps!=null)ps.close();
                     if(conn!=null)conn.close();
                 }catch(Exception e2) {
                     e2.printStackTrace();
                 }
            }
            return users;
        }
         
        public static List<Station> load4(){
            conn=JDBUtil.getConn();
            ps=null;
            ResultSet rs=null;
            String id;
            sql="select name from line4 ";
//          sql="select * from station where Id between ? and ? order by Id";
            List<Station> users=new ArrayList<Station>();
            Station user=null;
            try {
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()) {
                    user=new Station();
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                     if(ps!=null)ps.close();
                     if(conn!=null)conn.close();
                 }catch(Exception e2) {
                     e2.printStackTrace();
                 }
            }
            return users;
        }
         
        public static List<Station> load5(){
            conn=JDBUtil.getConn();
            ps=null;
            ResultSet rs=null;
            String id;
            sql="select name from line5 ";
//          sql="select * from station where Id between ? and ? order by Id";
            List<Station> users=new ArrayList<Station>();
            Station user=null;
            try {
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()) {
                    user=new Station();
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                     if(ps!=null)ps.close();
                     if(conn!=null)conn.close();
                 }catch(Exception e2) {
                     e2.printStackTrace();
                 }
            }
            return users;
        }
         
        public static List<Station> load6(){
            conn=JDBUtil.getConn();
            ps=null;
            ResultSet rs=null;
            String id;
            sql="select name from line6 ";
//          sql="select * from station where Id between ? and ? order by Id";
            List<Station> users=new ArrayList<Station>();
            Station user=null;
            try {
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()) {
                    user=new Station();
                    user.setName(rs.getString("name"));
                    users.add(user);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                     if(ps!=null)ps.close();
                     if(conn!=null)conn.close();
                 }catch(Exception e2) {
                     e2.printStackTrace();
                 }
            }
            return users;
        }
         
         
         
        static {
     
            line1=load1();
            line2=load2();
            line3=load3();
            line4=load4();
            line5=load5();
            line6=load6();
        lineSet.add(line1);
        lineSet.add(line2);
        lineSet.add(line3);
        lineSet.add(line4);
        lineSet.add(line5);
        lineSet.add(line6);
        totalStaion  = line1.size() + line2.size() + line3.size() + line4.size() + line5.size() + line6.size();
        System.out.println("总的站点数量："+totalStaion);
    //}
        }
}
