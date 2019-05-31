package city;

import java.sql.*;
import java.util.*;
import city.CityDao;

public class Query {
	public String tableName;
	public String querysql;

	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	public String getTableName(){
		return tableName;
	}
	public void setQuerysql(String querysql){
		this.querysql = querysql;
	}
	public String getQuerysql(){
		return querysql;
	}
	
	public ArrayList QueryFlight(){
		Query query = new Query();
		CityDao citydao = new CityDao();
		String dataSource = "project";
		String tableName = "北京到上海航班";
		query.setQuerysql("SELECT 航班 FROM  北京到上海航班   WHERE 出发时 > '9:00:00';");
		citydao.setDatasourceName(dataSource);
		citydao.setTableName(tableName);
		citydao.setSQL(query.getQuerysql());
		return citydao.inputQueryFlight();
	}
	
}


