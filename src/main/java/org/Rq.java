package org;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionName;
    private Map<String, String> paramsMap;

    Rq(String cmd) {
        paramsMap = new HashMap<>();

        String[] cmdBits = cmd.split("\\?");
        actionName = cmdBits[0];

        String queryString = cmdBits.length > 1 ? cmdBits[1].trim() : "";
        String[] qsBits = queryString.split("&");
        for(String queryParam : qsBits) {
            String[] qpBits = queryParam.split("=");
            String key = qpBits[0];
            String value = qpBits.length > 1 ? qpBits[1].trim() : "";

            if (value.isEmpty()) {
                continue;
            }
            paramsMap.put(key,value);
        }

    }

    public String  getActionName() {
        return actionName;
    }
    public String getParam(String paramName, String defaultValue) {
        if (paramsMap.containsKey(paramName)) {
            return paramsMap.get(paramName);
        } else {
            return defaultValue;
        }
    }

    public int getParamAsInt(String paramName , int defalutValue) {
        String value = getParam(paramName, "");

        if (value.isEmpty()) {
            return defalutValue;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defalutValue;
        }
    }


}
