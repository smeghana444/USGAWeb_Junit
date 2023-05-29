package util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader 
{
private static String configpath=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
private Properties prop;
public Properties init_prop()
{
	prop=new Properties();
	try {
	InputStream instm = new FileInputStream(configpath);
	prop.load(instm);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return prop;
}
}
