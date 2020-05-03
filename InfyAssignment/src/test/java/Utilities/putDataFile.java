package Utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class putDataFile {
	public static String getName()
	{
		return (RandomStringUtils.randomAlphabetic(7));
	}
	
	public static String getSalary()
	{
		return (RandomStringUtils.randomNumeric(6));
	}
	
	public static String getAge()
	{
		return (RandomStringUtils.randomNumeric(2));
	}

}
