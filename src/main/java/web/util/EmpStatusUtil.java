package web.util;

import java.util.HashMap;
import java.util.Map;

public class EmpStatusUtil {
	public static final Map<String, String> STATUS_MAP = new HashMap<>();

	static {
		STATUS_MAP.put("0", "離職");
		STATUS_MAP.put("1", "在職");
		
	}
	

	public static String convertStatus(String status) {
		return STATUS_MAP.getOrDefault(status, status);

	}

}
