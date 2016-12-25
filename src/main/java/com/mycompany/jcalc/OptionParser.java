package com.mycompany.jcalc;
import org.apache.commons.lang.StringEscapeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by okhoruzhenko on 12/16/16.
 */
public class OptionParser {
    public static String[] parse (String options) {
        String[] expression;
        String regexp = StringEscapeUtils.escapeJava(Arrays.toString(Operation.values()));
        expression = options.split(regexp);
        return expression;
    }
}
