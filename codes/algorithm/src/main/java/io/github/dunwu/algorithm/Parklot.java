package io.github.dunwu.algorithm;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author <a href="mailto:forbreak@163.com">Zhang Peng</a>
 * @since 2020-05-13
 */
public class Parklot {

    private volatile AtomicInteger space;
    private volatile AtomicLong sum;
    private volatile int MAX = 1000;

    public boolean enter(Car car) {
        if (space.get() >= MAX) {
            // reject
            return false;
        }

        // TODO 判断车类型

        car.enter();
        space.getAndIncrement();
        return true;
    }

    public long exit(Car car) {
        if (space.get() >= MAX) {
            // reject
            return 0L;
        }

        // TODO 判断车类型
        car.exit();
        long money = car.money();
        // 扣费
        space.getAndDecrement();
        sum.getAndAdd(money);
        return money;
    }

    public void getSum() {

    }

    public interface Parking {

        enum Type {
            car,
            truck
        }

        int getPrice();

        int getMax();

        void enter();

        void exit();

        LocalDateTime getBeginTime();

        LocalDateTime getEndTime();

        default long money() {
            if (getEndTime() == null) {
                return 0;
            }
            long l2 = getEndTime().toEpochSecond(ZoneOffset.UTC);
            long l1 = getBeginTime().toEpochSecond(ZoneOffset.UTC);
            long time = l2 - l1;
            long hours = TimeUnit.NANOSECONDS.toHours(time);
            long total = getPrice() * hours;
            return Math.min(total, getMax());
        }

    }

    public abstract class Car implements Parking {

        private static final int price = 5;
        private static final int max = 60;
        private LocalDateTime beginTime;
        private LocalDateTime endTime;

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int getMax() {
            return max;
        }

        @Override
        public void enter() {
            beginTime = LocalDateTime.now();
        }

        @Override
        public void exit() {
            endTime = LocalDateTime.now();
        }

        @Override
        public LocalDateTime getBeginTime() {
            return beginTime;
        }

        @Override
        public LocalDateTime getEndTime() {
            return endTime;
        }

    }

    public class LittleCar extends Car {

        private static final int price = 5;
        private static final int max = 60;

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int getMax() {
            return max;
        }

    }

    public class Truck extends Car implements Parking {

        private static final int price = 10;
        private static final int max = 120;

        @Override
        public int getPrice() {
            return price;
        }

        @Override
        public int getMax() {
            return max;
        }

    }

}
