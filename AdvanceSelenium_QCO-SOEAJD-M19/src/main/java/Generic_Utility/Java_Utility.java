package Generic_Utility;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid duplicates
	 * @return
	 * @author Shobha
	 */
	public int getRandomNum()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(2000);
		return ranNum;
	}
}
