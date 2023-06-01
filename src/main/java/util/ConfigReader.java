package util;


import java.io.InputStream;
import java.util.Properties;
public class ConfigReader 
{

private Properties prop;
public Properties init_prop()
{
	prop=new Properties();
	try {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
	
		InputStream resourceStream = loader.getResourceAsStream("config.properties"); 
		
	//InputStream instm = new FileInputStream(configpath);
	prop.load(resourceStream);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return prop;
}
}
