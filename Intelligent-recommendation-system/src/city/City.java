package city;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.management.Query;
import java.util.*;




//º½°à
public class City{
	
	public String Flight;
	public String DepartureTime;
	public String DepartureStation;
	public String ArrivalTime;
	public String ArrivalStation;
	public String Price;
	
	
	public String Flight() {
		return Flight;
	}
	public void setFlight(String Flight) {
		this.Flight = Flight;
	}
	
	public String DepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(String DepartureTime) {
		this.DepartureTime = DepartureTime;
	}
	
	public String DepartureStation() {
		return DepartureStation;
	}
	public void setDepartureStation(String DepartureStation) {
		this.DepartureStation = DepartureStation;
	}
	
	public String ArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(String ArrivalTime) {
		this.ArrivalTime = ArrivalTime;
	}
	
	public String ArrivalStation() {
		return ArrivalStation;
	}
	public void setArrivalStation(String ArrivalStation) {
		this.ArrivalStation = ArrivalStation;
	}
	
	public String Price() {
		return Price;
	}
	public void setPrice(String Price) {
		this.Price = Price;
	}
}





