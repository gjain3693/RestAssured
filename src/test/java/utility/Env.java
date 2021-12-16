package utility;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Env {

    public static Map<String,String> env = new HashMap<String,String>();
    public static Properties prop = new Properties();


    public static Map<String,String> envFile() {

        //Env name we will pass from vmArgument
        String enviorement = System.getProperty("env");

        try {
            if(enviorement.equalsIgnoreCase("fte")) {
                FileInputStream fte = new FileInputStream(System.getProperty("user.dir")+"/input/fte.properties");
                prop.load(fte);
                env.put("baseUrl", prop.getProperty("baseUrl"));
            } else if(enviorement.equalsIgnoreCase("sit")) {
                FileInputStream sit = new FileInputStream(System.getProperty("user.dir")+"/input/sit.properties");
                prop.load(sit);
                env.put("baseUrl", prop.getProperty("baseUrl"));
            } else if(enviorement.equalsIgnoreCase("ppe")) {
                FileInputStream ppe = new FileInputStream(System.getProperty("user.dir")+"/input/ppe.properties");
                prop.load(ppe);
                env.put("baseUrl", prop.getProperty("baseUrl"));
            }
        } catch(Exception ex) {

        }
        return env;
    }

    public static Map<String,String> getConfigReader() {
        if(env == null) {
            env = envFile();
        }
        return env;
    }
}
