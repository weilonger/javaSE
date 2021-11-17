package main.java.InterviewPrepare.juc.helper;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum CountryEnum {
    HAN(1, "韩国", "-230"), ZHAO(2, "赵国", "-228"), WEI(3, "魏国", "-225"),
    CHU(4, "楚国", "-223"), YAN(5, "燕国", "-222"), QI(6, "齐国", "-221");

    private int count;
    private String name;
    private String deadYear;

    CountryEnum(int count, String name, String deadYear) {
        this.count = count;
        this.name = name;
        this.deadYear = deadYear;
    }

    /**
     * 静态方法遍历获取全部枚举数据.
     * @param index key键
     * @return 枚举数据
     */
    public static CountryEnum forEachCountryEnum(int index) {
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum ce : myArray) {
            if (Objects.equals(index, ce.getCount())) {
                return ce;
            }
        }
        return null;
    }
}
