package HashMapandDesign;

import java.util.HashMap;

public class _359_LoggerRateLimiter {
    HashMap<String, Integer> map;

    public _359_LoggerRateLimiter() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timeStamp, String log) {
        if (!map.containsKey(log) || timeStamp - map.get(log) >= 10) {
            map.put(log, timeStamp);
            return true;
        } else {
            return false;
        }
        
    }

    public static void main(String[] args) {
        _359_LoggerRateLimiter logger = new _359_LoggerRateLimiter();
        System.out.println(logger.shouldPrintMessage(1, "foo"));
        System.out.println(logger.shouldPrintMessage(2, "bar"));
        System.out.println(logger.shouldPrintMessage(3, "foo"));
        System.out.println(logger.shouldPrintMessage(8, "bar"));
        System.out.println(logger.shouldPrintMessage(10, "foo"));
        System.out.println(logger.shouldPrintMessage(11, "foo"));

    }
}
