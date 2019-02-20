package sel;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Firstlog {
	static Logger log = Logger.getLogger(Firstlog.class);
	public static void main(String[] args) {
		//PropertiesConfigurator is used to configure logger from properties file
		

				PropertyConfigurator.configure("C:\\Users\\schevvakula\\eclipse-workspace\\sel\\src\\sel\\log4j.properties");
				Amazon a = new Amazon();
				
				a.invBrowser();
				//log the message to file
				
				log.trace("This is a debug message");
				log.info("This is an info message");
	}

}
