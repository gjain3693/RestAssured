package apiutility;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfig {

    public Map<String,String> defaultHeaders() {

        Map<String,String> defaultHead = new HashMap<String,String>();
        defaultHead.put("Content-Type","application/json");

        return defaultHead;
    }
}
