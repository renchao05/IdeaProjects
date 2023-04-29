package com.chaoren.time;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class TestLocalDateTime {

    /**
     * 时区 ID
     */
    @Test
    public void testZoned() {
        Set<String> set = ZoneId.getAvailableZoneIds();
        set.forEach(System.out::println);
        ZoneId Shanghai = ZoneId.of("Asia/Shanghai");

        System.out.println("=============");
        System.out.println(Shanghai);
    }

    /**
     * 本地时间和时区时间
     */
    @Test
    public void test06() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(now);

        System.out.println(LocalDateTime.now());

        ZonedDateTime time = ZonedDateTime.now(ZoneId.of("US/Pacific"));
        System.out.println(time);
    }

    /**
     * 日期时间格式化
     */
    @Test
    public void test05() {
        //DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss E");
        LocalDateTime now = LocalDateTime.now();
        String strDate = now.format(dtf);
        System.out.println(strDate);

        LocalDateTime ldt = LocalDateTime.parse(strDate, dtf);
        System.out.println(ldt);
    }


    @Test
    public void test04() {
        LocalDateTime ldt1 = LocalDateTime.now();
        // 本月的10日
        System.out.println(ldt1.withDayOfMonth(10));

        //下一个周五是几月几号
        LocalDateTime ldt2 = ldt1.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt2);

        //自定义：下一个工作日
        LocalDateTime ldt4 = ldt1.with(l -> {
            LocalDateTime ldt3 = (LocalDateTime) l;
            DayOfWeek week = ldt3.getDayOfWeek();
            if (week.equals(DayOfWeek.FRIDAY))
                return ldt3.plusDays(3);
            else if (week.equals(DayOfWeek.SATURDAY))
                return ldt3.plusDays(2);
            return ldt3.plusDays(1);
        });
        System.out.println(ldt4);
    }

    /**
     * 时间间隔
     * @throws InterruptedException
     */
    @Test
    public void test03() throws InterruptedException {
        Instant ins1 = Instant.now();
        System.out.println("=====睡眠=====");
        Thread.sleep(1000);
        Instant ins2 = Instant.now();
        System.out.println("睡眠时间为：" + Duration.between(ins1,ins2));

        System.out.println("=======================");
        LocalDateTime ldt1 = LocalDateTime.now();
        LocalDateTime ldt2 = LocalDateTime.of(2020, 2, 25, 13, 32, 59);
        System.out.println("时间间隔：" + Duration.between(ldt2,ldt1));
        Duration between = Duration.between(ldt2, ldt1);
        System.out.println(between.getSeconds());

        System.out.println("========================");
        LocalDate ld1 = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2020, 2, 25);
        Period pe = Period.between(ld2, ld1);
        System.out.println(pe);
        System.out.println(pe.getYears());
        System.out.println(pe.getMonths());
        System.out.println(pe.getDays());
    }

    @Test
    public void test02() {
        Instant now = Instant.now(); //默认使用 UTC 时区
        System.out.println(now);

        OffsetDateTime odt = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(now.getNano());

        Instant second = Instant.ofEpochSecond(5);//1970-01-01T00：00：00加上这个时间以后的时间
        System.out.println(second);
    }

    @Test
    public void test01() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt.withMonth(10));  // 设置月份

        System.out.println("=========1=========");
        LocalDateTime ldt2 = LocalDateTime.of(2022, 2, 25, 13, 32, 59);
        System.out.println(ldt2);
        System.out.println(ldt2.getDayOfWeek());    // 星期几
        System.out.println(ldt2.getDayOfYear());    // 一年中的某一天

        System.out.println("=========2=========");
        LocalDateTime ldt3 = ldt2.plusYears(3); // 加上3年
        System.out.println(ldt3);

        System.out.println("=========3=========");
        LocalDateTime ldt4 = ldt2.minusMonths(14);  // 减去14个月
        System.out.println(ldt4);

        System.out.println("=========4=========");
        System.out.println(ldt.getYear());  // 年
        System.out.println(ldt.getMonthValue());    // 月
        System.out.println(ldt.getDayOfMonth());    // 日
        System.out.println(ldt.getHour());  // 时
        System.out.println(ldt.getMinute());    // 分
        System.out.println(ldt.getSecond());    // 秒
    }

    @Test
    public void test07() {
        LocalDate now = LocalDate.now();
        System.out.println("当前时间：" + now);
        System.out.println("当前时间往后推3天：" + now.plusDays(3));

        System.out.println("最小时间：" + LocalTime.MIN);
        System.out.println("最大时间：" + LocalTime.MAX);

        System.out.println("今天的最早时间：" + LocalDateTime.of(now,LocalTime.MIN));
        System.out.println("今天的最晚时间：" + LocalDateTime.of(now,LocalTime.MAX));

        System.out.println("格式化后==========");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(LocalDateTime.of(now, LocalTime.MIN).format(pattern));
        System.out.println(LocalDateTime.of(now, LocalTime.MAX).format(pattern));

    }

    @Test
    public void test11() {
        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        LocalDateTime plus3Days = now.plusDays(10);
//        now.get

    }
}
