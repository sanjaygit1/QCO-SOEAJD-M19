package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to read data from properties_file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getKeyAndValuePair(String key) throws Throwable {
		// step1:- get the file path connection
	//	FileInputStream fis = new FileInputStream("C:\\Users\\Shobha\\Downloads\\Properties_Data7am.properties");
		FileInputStream fis = new FileInputStream(IPathConstant.filePath);
		
		// step2:- load all the keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:- read key value
		String Value = pro.getProperty(key);
		return Value;
		
	}
}
