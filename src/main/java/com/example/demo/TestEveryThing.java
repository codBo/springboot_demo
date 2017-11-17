package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brian on 2017/9/20.
 */

public class TestEveryThing {

    private static String ab = "4";

    public static void main(String[] args) {

        T t = new T(); t.test();
//        testAnsj();
//        System.out.println("------------------------------------------");
//        testJieBaFenCi();

    }
    public static void testAb() {

    }
//    private static void testJieBaFenCi() {
//
//        JiebaSegmenter segmenter = new JiebaSegmenter();
//        String[] sentences =
//                new String[] {"这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。", "我不喜欢日本和服。", "雷猴回归人间。",
//                        "工信处女干事每月经过下属科室都要亲口交代24口交换机等技术性器件的安装工作", "结果婚的和尚未结过婚的"};
////        new String[] {"2017款丰田霸道2700 TX ，七座，17寸铝合金轮毂，底挂备胎，2气囊，天窗，冰箱，黑色脚踏、黑色门把手，胎压检测，卤素大灯，字母彩条，拖钩。白色，38.3"};
//        for (String sentence : sentences) {
//            System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX).toString());
//        }
//    }
//    private static void testAnsj() {
//
////        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
//        String str = "2017款丰田霸道2700 TX ，七座，17寸铝合金轮毂，底挂备胎，2气囊，天窗，冰箱，黑色脚踏、黑色门把手，胎压检测，卤素大灯，字母彩条，拖钩。白色，38.3" ;
//        System.out.println(ToAnalysis.parse(str));
//    }

}
class T {

    private static String f = "123";
    private final List<String> list = new ArrayList<>();
    public String getF() {
        return f;
    }
    public List<String> getList() {
        return list;
    }
    public void test() {

        System.out.println(f);
        T t = new T();
        String ff = t.getF();
        ff = "1122";
        System.out.println(f);

        list.add("123sdf");
        System.out.println(list);
//        List<String> list1 = t.getList();
//        list1.add("123123");
        t.getList().add("213");
        System.out.println(list);
    }
}
