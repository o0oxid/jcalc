package com.mycompany.jcalc;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by okhoruzhenko on 12/16/16.
 */
public class OptionParser {
    public static String[] parse (String options) {
        String[] expression;
        StringBuilder strBuilder = new StringBuilder();
        for (Operation o: Operation.values()) {strBuilder.append("\\" + o.getSign());}
        String operations = "[" + strBuilder.toString() + "]";
        
        // non-capturing special constructions. Please don't ask to explain me how it really works.
        // http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
        // http://stackoverflow.com/questions/19951850/split-string-with-regex-but-keep-delimeters-in-match-array
        //String regexp = "(?=[-\\+/\\*\\(\\)])|(?<=[-\\+/\\*\\(\\)])";
        String regexp = "(?=" + operations + ")|(?<=" + operations +")";
        expression = options.split(regexp);
        return expression;
    }
}
