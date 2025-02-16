package greedyAlgo;
import java.util.*;

public class Activity {
	private String name;
	private int startTime;
	private int endTime;
	
	public Activity(String name, int startTime, int endTime) {
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getStartTime() {
		return this.startTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	public int getEndTime() {
		return this.endTime;
	}
	
	@Override
	public String toString() {
		return "Activity : " + this.name + " , startTime= " + this.startTime + " endTime= "+this.endTime;
	}
	
}
