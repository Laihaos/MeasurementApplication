package com.example.measurementapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.nlf.calendar.Lunar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Natal_chart extends AppCompatActivity {

    public static Lunar date;
    public TextView textyan;
    public TextView textmou;
    public TextView textchen;
    public TextView textji;
    public TextView textwu;
    public TextView textwei;
    public TextView textshen;
    public TextView textxi;
    public TextView textxu;
    public TextView texthai;
    public TextView textzi;
    public TextView textchou;

    public TextView textzhong;


    public static int Month = 0;
    public static String Sex;
    public static String Name;


    public static String tian;
    public static String birthday;

    public static String minggong;

    static String[] HeavenlyStems = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
    static String[] EarthlyBranches = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
    static String[] ming = {"命宫", "父母", "福德", "田宅", "官禄", "交友", "迁移", "疾厄", "财帛", "子女", "夫妻", "兄弟"};

    static String[] ziweiBranches = {"寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑"};

    static String[] birthdayBranches = {"寅", "丑", "子", "亥", "戌", "酉", "申", "未", "午", "巳", "辰", "卯"};

    static String[] zuofu = {"辰", "巳", "午", "未", "申", "酉", "戌", "亥", "子", "丑", "寅", "卯"};

    static String[] youbi = {"亥", "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌"};


    static String wuxing = "";
    static String yinyang = "";
    static String[] shuwuxing = {"水二局", "木三局", "金四局", "土五局", "火六局"};
    static int wuXingJu = 0;
    static int birthDay = 0;

    static String ziwei;
    static ArrayList<String> HeavenlyStemslist = new ArrayList<>();
    static ArrayList<String> EarthlyBrancheslist = new ArrayList<>();
    static ArrayList<String> ziweiBrancheslist = new ArrayList<>(Arrays.asList(ziweiBranches));
    static ArrayList<String> minglist = new ArrayList<>(Arrays.asList(ming));

    static ArrayList<String> XingyaoBrancheslist = new ArrayList<>();
    static Map<String, String> sihuamap = new HashMap<>();

    static ArrayList<TextView> TextViewlist = new ArrayList<>();

    public static void Heavenlys(int a, String[] HeavenlyStem, List<String> array) {
        for (int i = a; i < HeavenlyStem.length; i++) {
            array.add(String.valueOf(HeavenlyStem[i]));
        }

    }

    public static void Stems(int a, String[] Stems, List<String> array) {
        for (int i = 0; i < a; i++) {
            array.add(String.valueOf(Stems[i]));
        }

    }

    public static int ZiWeiStarPosition(int birthDay, int wuXingJu) {
        int x = 0;
        while ((birthDay + x) % wuXingJu != 0) {
            x++;
        }

        int quotient = (birthDay + x) / wuXingJu;
        int position;
        if (x % 2 == 0) {
            position = quotient + x;
        } else {
            position = quotient - x;
            if (position <= 0) {
                position += 12;
            }
        }

        return position;
    }

    public static void Xingyao(int ziWeiStarPosition, List<String> ziweiBrancheslist, List<String> XingyaoBrancheslist, String ziwei, List<TextView> Textlist, String xingyao) {


        for (int i = 0; i < ziweiBrancheslist.size(); i++) {

            if (ziwei.equals(ziweiBrancheslist.get(i))) {

                if (((i - ziWeiStarPosition) % 12) >= 0) {

                    XingyaoBrancheslist.add(ziweiBrancheslist.get((i - ziWeiStarPosition) % 12));
                    SpannableString newSpannableString = new SpannableString(xingyao + "\n" + Textlist.get((i - ziWeiStarPosition) % 12).getText());
                    newSpannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, newSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Textlist.get((i - ziWeiStarPosition) % 12).setText(newSpannableString);

                } else {
                    XingyaoBrancheslist.add(ziweiBrancheslist.get(((i - ziWeiStarPosition) % 12) + 12));
                    SpannableString newSpannableString = new SpannableString(xingyao + "\n" + Textlist.get(((i - ziWeiStarPosition) % 12) + 12).getText());
                    newSpannableString.setSpan(new ForegroundColorSpan(Color.RED), 0, newSpannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    Textlist.get(((i - ziWeiStarPosition) % 12) + 12).setText(newSpannableString);

                }

            }

        }

    }


    public static void actionActivity(Context context, Lunar Date, int month, int day, String name, String sex) {
        Intent intent = new Intent(context, Natal_chart.class);
        date = Date;
        Month = month;
        birthDay = day;
        Name = name;
        Sex = sex;
        context.startActivity(intent);
    }

    public void dateActivity() {


        for (int i = 0; i < TextViewlist.size(); i++) {
            TextView a = TextViewlist.get(i);
            a.setText("");
        }

        tian = date.getYearInGanZhi().substring(0, 1);


        if (tian.equals("甲") || tian.equals("丙") || tian.equals("戊") || tian.equals("庚") || tian.equals("壬")) {
            yinyang = "阳";
        } else {
            yinyang = "阴";
        }
        String gongli = date.getSolar().toFullString();

        textzhong.setText("\n    公历：" + gongli.substring(0, 22) + "\n    农历：" + date.getYear() + "-" + ((date.getMonth() < 10) ? String.valueOf(0) + date.getMonth() : date.getMonth()) + "-" + ((date.getDay() < 10) ? String.valueOf(0) + date.getDay() : date.getDay()) + " " + date.getHour() + ":" + ((date.getMinute() < 10) ? String.valueOf(0) + date.getMinute() : date.getMinute()) + ":" + date.getSecond() + date.getSecond() + " " + date.getYearInGanZhi() + "年" + " " + date.getTimeZhi() + "时" + "\n    姓名：" + Name + "     " + yinyang + Sex + "\n\n   " + date.getPengZuGan().substring(1, 8) + "," + date.getPengZuZhi().substring(1, 8));


//       甲己之年丙作首，乙庚之年戊为头。丙辛岁首庚寅起，丁壬壬寅顺行流。唯有戊癸从何起，正月便从甲寅行
        if (tian.equals("甲") || tian.equals("己")) {
            Heavenlys(2, HeavenlyStems, HeavenlyStemslist);
            Stems(4, HeavenlyStems, HeavenlyStemslist);
        } else if (tian.equals("乙") || tian.equals("庚")) {
            Heavenlys(4, HeavenlyStems, HeavenlyStemslist);
            Stems(6, HeavenlyStems, HeavenlyStemslist);
        } else if (tian.equals("丙") || tian.equals("辛")) {
            Heavenlys(6, HeavenlyStems, HeavenlyStemslist);
            Stems(8, HeavenlyStems, HeavenlyStemslist);
        } else if (tian.equals("丁") || tian.equals("壬")) {
            Heavenlys(8, HeavenlyStems, HeavenlyStemslist);
            Stems(10, HeavenlyStems, HeavenlyStemslist);
        } else {
            Heavenlys(0, HeavenlyStems, HeavenlyStemslist);
            Stems(2, HeavenlyStems, HeavenlyStemslist);
        }
//        、天干
        System.out.println(HeavenlyStemslist);

        birthday = date.getTimeZhi();

        List<String> birthdaylist = Arrays.asList(birthdayBranches);

        for (int i = 0; i < birthdayBranches.length; i++) {
            EarthlyBrancheslist.clear();

            Heavenlys(i, EarthlyBranches, EarthlyBrancheslist);
            Stems(i, EarthlyBranches, EarthlyBrancheslist);

            if (i == birthdaylist.indexOf(birthday)) {

                break;
            }

        }

        for (int i = 0; i < EarthlyBrancheslist.size(); i++) {

            if (i == Month - 1) {

                minggong = EarthlyBrancheslist.get(i);

                for (int j = 0; j < EarthlyBranches.length; j++) {

                    if (EarthlyBrancheslist.get(i).equals("子") || EarthlyBrancheslist.get(i).equals("丑")) {

                        if (tian.equals("甲") || tian.equals("己")) {
                            wuxing = "水二局";
                        } else if (tian.equals("乙") || tian.equals("庚")) {
                            wuxing = "火六局";

                        } else if (tian.equals("丙") || tian.equals("辛")) {
                            wuxing = "土五局";

                        } else if (tian.equals("丁") || tian.equals("壬")) {
                            wuxing = "木三局";

                        } else if (tian.equals("戊") || tian.equals("癸")) {
                            wuxing = "金四局";

                        }

                    }
                    if (EarthlyBrancheslist.get(i).equals("寅") || EarthlyBrancheslist.get(i).equals("卯")) {

                        if (tian.equals("甲") || tian.equals("己")) {
                            wuxing = "火六局";
                        } else if (tian.equals("乙") || tian.equals("庚")) {
                            wuxing = "土五局";

                        } else if (tian.equals("丙") || tian.equals("辛")) {
                            wuxing = "木三局";

                        } else if (tian.equals("丁") || tian.equals("壬")) {
                            wuxing = "金四局";

                        } else if (tian.equals("戊") || tian.equals("癸")) {
                            wuxing = "水二局";
                        }

                    }
                    if (EarthlyBrancheslist.get(i).equals("辰") || EarthlyBrancheslist.get(i).equals("巳")) {

                        if (tian.equals("甲") || tian.equals("己")) {
                            wuxing = "木三局";
                        } else if (tian.equals("乙") || tian.equals("庚")) {
                            wuxing = "金四局";

                        } else if (tian.equals("丙") || tian.equals("辛")) {
                            wuxing = "水二局";

                        } else if (tian.equals("丁") || tian.equals("壬")) {
                            wuxing = "火六局";

                        } else if (tian.equals("戊") || tian.equals("癸")) {
                            wuxing = "土五局";
                        }

                    }
                    if (EarthlyBrancheslist.get(i).equals("午") || EarthlyBrancheslist.get(i).equals("未")) {

                        if (tian.equals("甲") || tian.equals("己")) {
                            wuxing = "土五局";
                        } else if (tian.equals("乙") || tian.equals("庚")) {
                            wuxing = "木三局";

                        } else if (tian.equals("丙") || tian.equals("辛")) {
                            wuxing = "金四局";

                        } else if (tian.equals("丁") || tian.equals("壬")) {
                            wuxing = "水二局";

                        } else if (tian.equals("戊") || tian.equals("癸")) {
                            wuxing = "火六局";
                        }

                    }
                    if (EarthlyBrancheslist.get(i).equals("申") || EarthlyBrancheslist.get(i).equals("酉")) {

                        if (tian.equals("甲") || tian.equals("己")) {
                            wuxing = "金四局";
                        } else if (tian.equals("乙") || tian.equals("庚")) {
                            wuxing = "水二局";

                        } else if (tian.equals("丙") || tian.equals("辛")) {
                            wuxing = "火六局";

                        } else if (tian.equals("丁") || tian.equals("壬")) {
                            wuxing = "土五局";

                        } else if (tian.equals("戊") || tian.equals("癸")) {
                            wuxing = "木三局";
                        }

                    }
                    if (EarthlyBrancheslist.get(i).equals("戌") || EarthlyBrancheslist.get(i).equals("亥")) {

                        if (tian.equals("甲") || tian.equals("己")) {
                            wuxing = "火六局";
                        } else if (tian.equals("乙") || tian.equals("庚")) {
                            wuxing = "土五局";

                        } else if (tian.equals("丙") || tian.equals("辛")) {
                            wuxing = "木三局";

                        } else if (tian.equals("丁") || tian.equals("壬")) {
                            wuxing = "金四局";

                        } else if (tian.equals("戊") || tian.equals("癸")) {
                            wuxing = "水二局";
                        }

                    }

                }

            }

        }

        for (int i = 0; i < shuwuxing.length; i++) {

            if (wuxing.equals(shuwuxing[i])) {
                wuXingJu = i + 2;
            }

        }


        int ziWeiStarPosition = ZiWeiStarPosition(birthDay, wuXingJu);

        for (int i = 0; i < ziweiBrancheslist.size(); i++) {

            if (i == (ziWeiStarPosition - 1)) {

                ziwei = ziweiBrancheslist.get(i);

            }

        }
//        紫微逆行安天机，隔一太阳武曲移，天同隔二廉贞位，空三又见紫微星；
//        安天府星：申寅两宫紫府同坐，其他的都是紫微天府斜对
        Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "紫薇");

        Xingyao(1, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天机");

        Xingyao(3, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "太阳");

        Xingyao(4, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "武曲");

        Xingyao(5, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天同");

        Xingyao(8, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "廉贞");

        switch (ziweiBrancheslist.indexOf(ziwei)) {

            case 0:
                Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");
                break;
            case 6:
                Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");
                break;
            case 1:
                Xingyao(2, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 2:
                Xingyao(4, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 3:
                Xingyao(6, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 4:
                Xingyao(8, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 5:
                Xingyao(10, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 7:
                Xingyao(2, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 8:
                Xingyao(4, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 9:
                Xingyao(6, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 10:
                Xingyao(8, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;
            case 11:
                Xingyao(10, ziweiBrancheslist, XingyaoBrancheslist, ziwei, TextViewlist, "天府");

                break;

        }
        Xingyao(-1, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "太阴");
        Xingyao(-2, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "贪狼");
        Xingyao(-3, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "巨门");
        Xingyao(-4, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "天相");
        Xingyao(-5, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "天梁");
        Xingyao(-6, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "七杀");
        Xingyao(-10, ziweiBrancheslist, XingyaoBrancheslist, XingyaoBrancheslist.get(6), TextViewlist, "破军");

        List<String> list = Arrays.asList(youbi);
        List<StringBuilder> stringBuilderList =
                list.stream()
                        .map(StringBuilder::new)
                        .collect(Collectors.toList());
        Collections.reverse(stringBuilderList);
        List<String> reversedList = stringBuilderList.stream()
                .map(StringBuilder::toString)
                .collect(Collectors.toList());

        for (int i = 0; i < zuofu.length; i++) {
            if (i + 1 == Month) {
                Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, zuofu[i], TextViewlist, "左辅");
            }
            if (i + 1 == Month) {
                Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, reversedList.get(i), TextViewlist, "右弼");
            }
        }


        for (int i = 0; i < EarthlyBranches.length; i++) {
            if (birthday.equals(EarthlyBranches[i])) {

                Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, reversedList.get(i), TextViewlist, "文昌");
            }
            if (birthday.equals(EarthlyBranches[i])) {

                Xingyao(0, ziweiBrancheslist, XingyaoBrancheslist, zuofu[i], TextViewlist, "文曲");
            }

        }


        sihuamap.put("甲", "廉贞破军武曲太阳");
        sihuamap.put("乙", "天机天梁紫薇太阴");
        sihuamap.put("丙", "天同天机文昌廉贞");
        sihuamap.put("丁", "太阴天同天机巨门");
        sihuamap.put("戊", "贪狼太阴右弼天机");
        sihuamap.put("己", "武曲贪狼天梁文曲");
        sihuamap.put("庚", "太阳武曲太阴天同");
        sihuamap.put("辛", "巨门太阳文曲文昌");
        sihuamap.put("壬", "天梁紫薇左辅武曲");
        sihuamap.put("癸", "破军巨门太阴贪狼");

        String si;

        int flg = 0;

        for (int i = 0; i < 4; i++) {
            si = sihuamap.get(tian).substring(i * 2, i * 2 + 2);

            for (int j = 0; j < TextViewlist.size(); j++) {
                TextView a = TextViewlist.get(j);
                String hua = a.getText().toString().replaceAll("(?m)^\\s*\n", "");

                if (hua.contains(si) && i == 0) {
                    a.append("       禄");
                } else if (hua.contains(si) && i == 1) {
                    a.append("       权");
                } else if (hua.contains(si) && i == 2) {
                    a.append("       科");
                } else if (hua.contains(si) && i == 3) {
                    a.append("       忌");

                }

            }

        }
        String[] sortedArray = new String[12];
        for (int i = 0; i < EarthlyBranches.length; i++) {

            if (minggong.equals(ziweiBranches[i])) {

                int k = 0;
                for (int j = i; j < EarthlyBranches.length; j++) {
                    sortedArray[j] = ming[k];
                    k++;
                    flg = i;
                }

            }

        }
        int k = 0;
        for (int i = 12 - flg; i < TextViewlist.size(); i++) {
            sortedArray[k] = ming[i];
            k++;
        }

        for (int i = 0; i < TextViewlist.size(); i++) {
            TextView a = TextViewlist.get(i);

            if (a.getText().toString().length() == 0) {
                a.append("\n\n\n\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "     " + sortedArray[i]);

            } else if (a.getText().toString().length() == 3) {

                a.append("\n\n\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "     " + sortedArray[i]);

            } else if (a.getText().toString().length() == 6) {

                a.append("\n\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "     " + sortedArray[i]);

            } else if (a.getText().toString().length() == 9) {

                a.append("\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "      " + sortedArray[i]);

            } else if (a.getText().toString().length() == 11) {

                a.append("\n\n\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "     " + sortedArray[i]);

            } else if (a.getText().toString().length() == 14) {

                a.append("\n\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "      " + sortedArray[i]);

            } else if (a.getText().toString().length() == 17) {

                a.append("\n\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "      " + sortedArray[i]);

            } else if (a.getText().toString().length() == 20) {

                a.append("\n" + HeavenlyStemslist.get(i) + "\n" + ziweiBranches[i] + "      " + sortedArray[i]);

            }

        }


    }


    @Override
    protected void onRestart() {

        super.onRestart();
        dateActivity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acyivity_natal_chart);

        textyan = findViewById(R.id.yan);
        textmou = findViewById(R.id.mou);
        textchen = findViewById(R.id.chen);
        textji = findViewById(R.id.ji);
        textwu = findViewById(R.id.wu);
        textwei = findViewById(R.id.wei);
        textshen = findViewById(R.id.shen);
        textxi = findViewById(R.id.xi);
        textxu = findViewById(R.id.xu);
        texthai = findViewById(R.id.hai);
        textzi = findViewById(R.id.zi);
        textchou = findViewById(R.id.chou);
        textzhong = findViewById(R.id.zhong);

        TextViewlist.add(textyan);
        TextViewlist.add(textmou);
        TextViewlist.add(textchen);
        TextViewlist.add(textji);
        TextViewlist.add(textwu);
        TextViewlist.add(textwei);
        TextViewlist.add(textshen);
        TextViewlist.add(textxi);
        TextViewlist.add(textxu);
        TextViewlist.add(texthai);
        TextViewlist.add(textzi);
        TextViewlist.add(textchou);
        dateActivity();

    }


}
