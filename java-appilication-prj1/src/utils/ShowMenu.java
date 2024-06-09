package utils;

import constant.Constant;
import enums.OrderEnum;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class ShowMenu {
    public static String getOptions(List<String> options){
        int maxLength = options.stream().mapToInt(String::length).max().orElse(Constant.INT_ZERO);
        String message =  options.stream()
                .map(op -> MessageFormat.format("{0}. {1}", (options.indexOf(op) + Constant.INT_ONE), op))
                .collect(Collectors.joining("\n"));
        return addHyphens(OrderEnum.BEFORE.getValue(), maxLength) + message + addHyphens(OrderEnum.AFTER.getValue(), maxLength);
    }

    public static String addHyphens(String order, int maxLength){
        String hyphens = Constant.HYPHEN.repeat(maxLength + Constant.INT_TEN);
        if(OrderEnum.BEFORE.getValue().equals(order)){
            hyphens= hyphens + "\n";
        }else {
            hyphens = "\n" + hyphens;
        }
        return hyphens;
    }
}
