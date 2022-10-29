package mainClass;

import java.util.Calendar;

public class BookingClass {
	static Calendar calendar = Calendar.getInstance();

	public  static boolean checkNumberOfService(int sizeOfArrayService, int numberOfService) {
		if (numberOfService >= 1 && numberOfService <= sizeOfArrayService) {
			return true;
		}
		return false;
	}

	public static boolean checkStartTime(int start_time) {
		if ((start_time >= 10 && start_time <= 17)) {
			return true;
		}
		return false;
	}

	public static boolean checkEndTime(int start_time, int timeOfService) {
		if (checkStartTime(start_time)) {
			if ((start_time + timeOfService <= 18))
				return true;
		}
		return false;
	}

	public static boolean checkDay(int day, int month) {
		if (day >= 1 && day <= 31 && month % 2 == 1) {
			return true;
		} else if (day >= 1 && day <= 30 && month % 2 == 0) {
			return true;
		}
		return false;
	}

	public static boolean checkMonth(int month) {
		if (month >= 1 && month <= 12) {
			return true;
		}
		return false;
	}

	public static boolean checkYear(int year) {
		if (year >= calendar.get(Calendar.YEAR) && year <= calendar.get(Calendar.YEAR) + 1) {
			return true;
		}
		return false;
	}

	public static boolean checkDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		if (checkYear(year) && checkMonth(month) && checkDay(day, month)) {
			if ((calendar.get(Calendar.YEAR) == year) && (calendar.get(Calendar.MONTH) == month)
					&& (calendar.get(Calendar.DATE) < day))
				return false;
			else 
				return true;
		}
		return false;
	}

}
