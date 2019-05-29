package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;
import java.util.HashMap;

import java.util.LinkedHashSet;

import java.util.Map;

import java.util.ArrayList;

import java.util.LinkedHashSet;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



class DataBuilder {
	public static List<Station> line1 = new ArrayList<Station>();//1号线
	public static List<Station> line2 = new ArrayList<Station>();//2号线
	//public static List<Station> line3 = new ArrayList<Station>();//3号线
	//public static List<Station> line10 = new ArrayList<Station>();//10号线
	//public static List<Station> lineS1 = new ArrayList<Station>();//s1号线
	//public static List<Station> lineS8 = new ArrayList<Station>();//s8号线
	public static Set<List<Station>> lineSet = new HashSet<List<Station>>();//所有线集合
	public static int totalStaion = 0;//总的站点数量

	static {		

		//1号线
		String line1Str = "苹果园站、古站、八角游乐园站、八宝山站、玉泉路站、五棵松站、万寿路站、公主坟站、军事博物馆站、木樨地站、南礼士路站、复兴门站、西单站、天安门西站、天安门东站、王府井站、东单站、建国门站、永安里站、国贸站、大望路站、四惠站、四惠东站";
		String[] line1Arr = line1Str.split("、");
		for(String s : line1Arr){
			line1.add(new Station(s,"1"));
		}
		for(int i =0;i<line1.size();i++){
			if(i<line1.size()-1){
				line1.get(i).next = line1.get(i+1);
				line1.get(i+1).prev = line1.get(i);
			}
		}

		/*******************************************************************************/
		//2号线
		String line2Str = "车公庄站、阜成门站、复兴门站、长椿街站、宣武门站、和平门站、前门站、崇文门站、北京站、建国门站、朝阳门站、东四十条站、东直门站、雍和宫站、安定门站、鼓楼大街站、积水潭站、钟灵街站、西直门站";

		String[] line2Arr = line2Str.split("、");
		for(String s : line2Arr){
			line2.add(new Station(s,"2"));
		}

		for(int i =0;i<line2.size();i++){
			if(i<line2.size()-1){
				line2.get(i).next = line2.get(i+1);
				line2.get(i+1).prev = line2.get(i);
			}
		}
		/*******************************************************************************/
		/*3号线
		String line3Str = "林场站、星火路站、东大成贤学院站、泰冯路站、天润城站、柳洲东路站、上元门站、五塘广场站、小市站、南京站、南京林业大学·新庄站、鸡鸣寺站、浮桥站、大行宫站、常府街站、夫子庙站、武定门站、雨花门站、卡子门站、大明路站、明发广场站、南京南站、宏运大道站、胜太西路站、天元西路站、九龙湖站、诚信大道站、东大九龙湖校区站、秣周东路站";

		String[] line3Arr = line3Str.split("、");
		for(String s : line3Arr){
			line3.add(new Station(s,"3"));
		}

		for(int i =0;i<line3.size();i++){
			if(i<line3.size()-1){
				line3.get(i).next = line3.get(i+1);
				line3.get(i+1).prev = line3.get(i);
			}
		}
        /*******************************************************************************/		
		//10号线

		/*String line10Str = "雨山路站、文德路站、龙华路站、南京工业大学站、浦口万汇城站、临江站、江心洲站、绿博园站、梦都大街站、奥体中心站、元通站、中胜站、小行站、安德门站";
		String[] line10Arr = line10Str.split("、");
		for(String s : line10Arr){
			line10.add(new Station(s,"10"));
		}

		for(int i =0;i<line10.size();i++){
			if(i<line10.size()-1){
				line10.get(i).next = line10.get(i+1);
				line10.get(i+1).prev = line10.get(i);
			}
		}

		/*******************************************************************************/		
		//s1号线

		/*String lineS1Str = "南京南站、翠屏山站、河海大学·佛城西路站、吉印大道站、正方中路站、翔宇路北站、翔宇路南站、禄口机场站";
		String[] lineS1Arr = lineS1Str.split("、");
		for(String s : lineS1Arr){
			lineS1.add(new Station(s,"s1"));
		}
		for(int i =0;i<lineS1.size();i++){
			if(i<lineS1.size()-1){
				lineS1.get(i).next = lineS1.get(i+1);
				lineS1.get(i+1).prev = lineS1.get(i);
			}
		}

		/*******************************************************************************/		

		//s8号线
		/*String lineS8Str = "泰山新村站、泰冯路站、高新开发区站、信息工程大学站、卸甲甸站、大厂站、葛塘站、长芦站、化工园站、六合开发区站、龙池站、雄州站、凤凰山公园站、方州广场站、沈桥站、八百桥站、金牛湖站";

		String[] lineS8Arr = lineS8Str.split("、");
		for(String s : lineS8Arr){
			lineS8.add(new Station(s,"s8"));
		}
		for(int i =0;i<lineS8.size();i++){
			if(i<lineS8.size()-1){
				lineS8.get(i).next = lineS8.get(i+1);
				lineS8.get(i+1).prev = lineS8.get(i);
			}
		}*/
		lineSet.add(line1);
		lineSet.add(line2);
		//lineSet.add(line3);
		//lineSet.add(line10);
		//lineSet.add(lineS1);
		//lineSet.add(lineS8);
		totalStaion  = line1.size() + line2.size() ;
		System.out.println("总的站点数量："+totalStaion);
	}
}

/**
 * desc：地铁站对象
 */

class Station {
	private String name; //地铁站名称，假设具备唯一性
	public Station prev; //本站在lineNo线上面的前一个站
	public Station next; //本站在lineNo线上面的后一个站

	private String num; 

	//本站到某一个目标站(key)所经过的所有站集合(value)，保持前后顺序

	private Map<Station,LinkedHashSet<Station>> orderSetMap = new HashMap<Station,LinkedHashSet<Station>>();
	public Station (String name){
		this.name = name;

	}
	public Station (String name,String num){
		this.name = name;
		this.num = num;
	}
	public Station (){
	}
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
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

public class Subway {

	private List<Station> outList = new ArrayList<Station>();//记录已经分析过的站点
	Station startStation,endStation; 
	String startRoute[] = new String[30];
	String endRoute[]   = new String[30];
	String Route[]      = new String[30];
	String RouteNum[]   = new String[30];
	int i=0,k=0;
	//计算从s1站到s2站的最短经过路径
	public void calculate(Station s1,Station s2){
		if(outList.size() == DataBuilder.totalStaion){
			//System.out.println("找到目标站点："+s2.getName()+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
			startStation = s1;
			endStation = s1;
			startRoute[i] = startStation.getName();

			for(Station station : s1.getAllPassedStations(s2)){
				Route[k] = station.getName();
				RouteNum[k] = station.getNum();
				if(k == 1){
					RouteNum[k-1] = station.getNum();
				}
				k++;
				//System.out.print(station.getNum()+station.getName()+"->");
				
				if((station.getNum() != endStation.getNum()) && (endStation.getNum()!= "")){
					i++;
					startStation = station;
					startRoute[i] = endStation.getName();
					endRoute[i-1] = endStation.getName();
					endStation = station;
				}
				else{
					endStation = station;
				}
			}
			
			
			//System.out.println();
			endRoute[i] = s2.getName();
			
			for(int j = 0;j<=i;j++){
				//System.out.print("j:  "+j+"  ");
				//System.out.println("startRoute:"+startRoute[j]+"endRoute:"+endRoute[j]);
			}
			for(int j = 0;j<k;j++){
				//System.out.print(RouteNum[j]+"号线"+Route[j]+"->");
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
			//System.out.println("找到目标站点："+s2+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
			for(Station station : s1.getAllPassedStations(s2)){
				//System.out.print(station.getName()+"->");
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

		for(List<Station> line : DataBuilder.lineSet){

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

		
		Station startStation1 = new Station("南京站","");
		Station endStation1 = new Station("安德门站","");
		
		
		//sw.calculate(new Station("南京站"), new Station("小行站"));
		sw.calculate(startStation1, endStation1);
		long t2 = System.currentTimeMillis();
		//System.out.println();
		//System.out.println("耗时："+(t2-t1)+"ms");
		
		

	}
}

