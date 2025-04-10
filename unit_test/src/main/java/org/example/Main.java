package org.example;

import org.apache.commons.text.AlphabetConverter;
import java.io.UnsupportedEncodingException;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {

        Character[] originalChars = {'a', 'b', 'c', 'd'};
        Character[] encodingChars = {'0', '1', 'd'};
        Character[] doNotEncodeChars = {'d'}; // 不编码的字符

        AlphabetConverter converter = AlphabetConverter.createConverterFromChars(
                originalChars,
                encodingChars,
                doNotEncodeChars
        );

        String input = "abcd";
        try {
            String encoded = converter.encode(input);
            System.out.println("编码结果: " + encoded); // 输出: 00010dd
        } catch (UnsupportedEncodingException e) {
            System.err.println("编码失败: " + e.getMessage());
        }

        String encodedStr = "00010dd";
        try {
            String decoded = converter.decode(encodedStr);
            System.out.println("解码结果: " + decoded);
        } catch (UnsupportedEncodingException e) {
            System.err.println("解码失败: " + e.getMessage());
        }

        System.out.println("\n编码映射表:");
        System.out.println(converter.toString());
    }
}