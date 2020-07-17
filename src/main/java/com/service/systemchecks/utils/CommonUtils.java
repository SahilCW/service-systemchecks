package com.service.systemchecks.utils;

import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;


public class CommonUtils {

	public static final String EMPTY_STRING = "";
	public final static String GENERIC_ERROR_MSG = "Something goes wrong while processing you request. Please try again after sometime.";
	public static final String SERVER_ERROR = "Internal Server Error. Please try again after sometime.!!";
	public static final String INSUFFICIANT_DATA_ERROR = "Data not sufficiant for bureau report. Please Enter Correct Details.";
	public static final String EXPERIAN_SERVICE_NOT_AVAILABLE = "Experian service is not available.";
	public static final String SUCCESS = "Success";
	public static final String SSL = "SSL";
	public static final String B4L_RE_ASYNC_EXECUTOR = "b4lREAsyncExecutor";
	public static final String B4L_RE_ASYNC_EXECUTOR_THREAD_PREFIX = "B4LREThread-";
	public static final String B4L_BRIDGE_ASYNC_EXECUTOR = "b4lBridgeAsyncExecutor";
	public static final String B4L_BRIDGE_ASYNC_EXECUTOR_THREAD_PREFIX = "b4lBridgeThread-";
	public static final String ZEROSTR = "0";
	public static final String VERSION = "1.0.0";
	public static final String NO_VALUE = "NO_VALUE";
	public static final String NO_PRODUCTS = "No Products Available for this type of application";
	public static final String INELIGIBLE_MSG = "Application Does not Fullfill the Product Criteria";
	public static final String ORG_ID = "SBI";
	public static final String MATCHED = "MATCHED";
	private static final String CHAR_LIST_DEFAULT = "123456789";
	
	private static Random random = null;;
    
    static {
        random = new Random();
    }

	public String getEmptyString() {
		return EMPTY_STRING;
	}
	
	public static boolean isListNullOrEmpty(Collection<?> data) {
		return (data == null || data.isEmpty());
	}
	
	private static int generateOtp(String charList) {
		if (charList == null || charList.isEmpty() || "".equals(charList)) {
            charList = CHAR_LIST_DEFAULT;
		}
		int randomInt = 0;
		randomInt = random.nextInt(charList.length());
		if (randomInt - 1 == -1) {
			return randomInt;
		} else {
			return randomInt - 1;
		}
	}
	
	/**
	 * generate OTP based on passed string by user and digit length.
	 * @param digitLength OTP length
	 * @param charList from String it will generate OTP
	 * @return
	 */
	public static String generateOTP(int digitLength,String charList)
    {
       StringBuilder randStr = new StringBuilder();
        for(int i=0; i < digitLength; i++){
            int number = generateOtp(charList);
            char ch = charList.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
	
	/**
     * generate OTP based on passed string by user and digit length.
     * @param digitLength OTP length with default Character List
     * @return
     */
    public static String generateOTP(int digitLength)
    {
    	StringBuilder randStr = new StringBuilder();
        for(int i=0; i < digitLength; i++){
            int number = generateOtp(CHAR_LIST_DEFAULT);
            char ch = CHAR_LIST_DEFAULT.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }
    
	
	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}
	
	public static String getCurrentTimeStamp() {
		return getTimeStamp(new Date());
	}
	
	public static String getTimeStamp(Date dateToConvert) {
		return dateToConvert.toInstant().truncatedTo(ChronoUnit.MILLIS).toString();
	}
	
	public static boolean isObjectNull(Object value) {
		return (value == null
				|| (value instanceof String
						? (((String) value).isEmpty() || "".equals(((String) value).trim()) || "null".equals(value)
								|| "undefined".equals(value))
						: false));
	}
	public static boolean isObjectListNull(Object... args) {
		for (Object object : args) {
			boolean flag = false;
			if (object instanceof List) {
				flag = isListNullOrEmpty((List<?>) object);
				if (flag)
					return true;
				else
					continue;
			}
			flag = isObjectNull(object);
			if (flag)
				return true;
		}
		return false;
	}
	
	public static final class ContentType {
		private ContentType(){ /* Do nothing because of X and Y.*/ }

		public static final String XML = "XML";
		public static final String JSON = "JSON";
		public static final String FILE = "FILE";
	}
	
	public static Map<String,String> getAAHeader(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("client_api_key", "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6ImZpbnByb2JhbmsiLCJ0eXBlIjoiRklVIiwiaWF0IjoxNTg2ODQ2NzMxLCJleHAiOjE2NDk5MTg3MzF9.A-VX3lgu6T_r2FWIp2bsDAQK9vll6p4uQC_D5LwXmdo");
		return map;
	}
}
