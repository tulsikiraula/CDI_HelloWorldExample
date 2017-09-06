package loadPropertiesFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;

public class PropertiesHandler extends Properties {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private static PropertiesHandler propertiesHandler = new PropertiesHandler();
	
   
	
	private static void managePropertyFile() throws IOException {
		
    String classpath = PropertiesHandler.class.getClassLoader().getResource("").getPath();	
    File file =new File(classpath + "props/cdi.properties");
    if(!file.exists()) {
    	System.out.println("Property file :props/cdi.properties does not exists!");
    	FileUtils.touch(new File(classpath + "props/cdi.properties"));
    	System.out.println("props/cdi.properties is created");
    	manageDefaultProperties();
    }
	}
	
	private static void manageDefaultProperties() throws IOException {
		Map<String,String> defaultProps = new LinkedHashMap<>();
		defaultProps.put("com.kiraula.tulsi.project", "cdi");
		defaultProps.put("com.kiraula.tulsi.package", "loadPropertiesFile");
		defaultProps.put("com.kiraula.tulsi.compiler", "1.8");
		
		saveProperty(defaultProps,"props/cdi.properties");
	}

	private static void saveProperty(Map<String, String> defaultProps, String path) throws IOException {
		propertiesHandler.clear();
		propertiesHandler.load(PropertiesHandler.class.getClassLoader().getResourceAsStream(path));
		final Set<Map.Entry<String, String>> entries = defaultProps.entrySet();
	    entries.stream().forEach(entry -> propertiesHandler.setProperty(entry.getKey(), entry.getValue()));
	    propertiesHandler.store(new OutputStreamWriter(new FileOutputStream(PropertiesHandler.class.getClassLoader().getResource(path).getPath()), "UTF-8"), "");

	}

	public static String getPropertyValue(final String key, final String filePath) throws IOException {
		// propertiesHandler.clear();
		propertiesHandler.load(PropertiesHandler.class.getClassLoader().getResourceAsStream(filePath));
		return propertiesHandler.getProperty(key);
	}


	public static void main(String[] args) throws IOException {
		managePropertyFile();
		System.out.println(getPropertyValue("com.kiraula.tulsi.compiler","props/cdi.properties"));
	}

}
