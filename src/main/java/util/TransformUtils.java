package util;

import java.sql.Timestamp;

public class TransformUtils {

	public static Timestamp stringToTimestamp(String time) {
		time=time+" 00:00:00.000000000";
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
		return Timestamp.valueOf(time);
	}

}