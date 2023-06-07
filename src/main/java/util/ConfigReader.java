package util;


import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
public class ConfigReader 
{

private Properties prop;
ScreenRecorder screenRecorder;
String filename="./test-recordings/";

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

public void startRecord() throws Exception {
	 GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().
			    getDefaultScreenDevice()
			    .getDefaultConfiguration();
 File file = new File(filename);
 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 int width = screenSize.width;
 int height = screenSize.height;

 Rectangle captureSize = new Rectangle(0, 0, width, height);

 
 screenRecorder = new ScreenRecorder(gc, captureSize,
   new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
   new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
     CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, 24, FrameRateKey,
    new Rational(15,1)),
   new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, new Rational(30,1)),
   null, file);
 screenRecorder.start();
 System.out.println("screen recording strated");
}

public void stopRecord() throws Exception {
 screenRecorder.stop();
 System.out.println("screen recording stopped");
}
}
