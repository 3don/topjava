package ru.javawebinar.topjava.service;

import org.junit.rules.ExternalResource;
import org.junit.rules.Stopwatch;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

import static org.slf4j.LoggerFactory.getLogger;

public class TimeWatcher extends TestWatcher {

    private static final Logger log = getLogger("result");

    private static final StringBuilder results = new StringBuilder();

    public static final Stopwatch STOPWATCH = new Stopwatch() {
        @Override
        protected void finished(long nanos, Description description) {
            String result = String.format("%-95s %7d", description.getDisplayName(), TimeUnit.NANOSECONDS.toMillis(nanos));
            results.append(result).append('\n');
            log.info("\n" + result + " ms\n");
        }
    };

    public static final ExternalResource SUMMARY = new ExternalResource() {

        //обнуляем перед запуском тестов класса
        @Override
        protected void before() throws Throwable {
            results.setLength(0);
        }

        //выводим отформатированный результат
        @Override
        protected void after() {
            log.info("\n---------------------------------" +
                    "\nTest                 Duration, ms" +
                    "\n---------------------------------" +
                    "\n" +
                    results +
                    "\n---------------------------------");
        }
    };
}
