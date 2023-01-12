package GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFile {

	public static String readDataFromPropertyFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./zoo.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;

	}

}
