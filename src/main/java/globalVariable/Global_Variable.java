package globalVariable;

import java.util.HashMap;

public class Global_Variable {

	//Object name
	public static ThreadLocal<String> objName=new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return new String();
		}
	};
	public static void setObjName(String temp) {
		objName.set(temp);
	}
	public static String getObjName() {
		return objName.get().toString();
	}

	//Test
	public static ThreadLocal<String> test=new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return new String();
		}
	};

	public static void setTest(String temp) {
		test.set(temp);
	}

	public static String getTest() {
		return test.get().toString();
	}

	//HashMap
	public static ThreadLocal<HashMap<String,String >> testDataHashMap=new ThreadLocal<HashMap<String,String >>() {
		@Override
		protected HashMap<String,String> initialValue() {
			return new HashMap<String,String >();
		}
	};

	public static void setTestData(HashMap<String, String> testHM) {
		testDataHashMap.set(testHM);
	}

	public static String getTestData(String key) {
		return testDataHashMap.get().get(key).toString();
	}


}
