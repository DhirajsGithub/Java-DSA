package greedyAlgo;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;


public class ActivitySelection {
		
	static void activitySelection(ArrayList<Activity>  activityList) {
		Comparator<Activity> finishTimeComparator = new Comparator<Activity>() {

			@Override
			public int compare(Activity o1, Activity o2) {
				return o1.getEndTime() - o2.getEndTime();
			};
			
		};
		
		Collections.sort(activityList, finishTimeComparator);
		Activity prvActivity = activityList.get(0);
		
		System.out.println("\n\n Recommended Schedule : \n"+ activityList.get(0));
		
		for(int i=1; i<activityList.size(); i++) {
			Activity activity = activityList.get(i);
			if(activity.getStartTime()>= prvActivity.getEndTime()) {
				System.out.println(activity);
				prvActivity = activity;
			}
		}
	}

}
