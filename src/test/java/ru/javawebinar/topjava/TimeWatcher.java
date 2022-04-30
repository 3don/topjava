package ru.javawebinar.topjava;

import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class TimeWatcher{

    private static final Logger log = LoggerFactory.getLogger(TestWatcher.class);

    private static final StringBuilder results = new StringBuilder();

    public static final Stopwatch STOPWATCH = new Stopwatch() {
        @Override
        protected void finished(long nanos, Description description) {
            String result = String.format("%-95s %7d", description.getDisplayName(), TimeUnit.NANOSECONDS.toMillis(nanos));
            results.append(result).append('\n');
            log.info("\n" + result + " ms\n");
        }
    };

    private static final String DELIM = "----------------------------------------------------------------";

    //форматируем красивый вывод в консоль
    public static final ExternalResource SUMMARY = new ExternalResource() {

        //обнуляем перед запуском тестов класса
        @Override
        protected void before() throws Throwable {
            results.setLength(0);
        }

        //выводим отформатированный результат
        @Override
        protected void after() {
            log.info("\n" + DELIM +
                    "\nTest                                                                                       Duration, ms" +
                    "\n" + DELIM + "\n" + results + DELIM + "\n");
        }
    };
}
