package ru.mycompany.phrase.job;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mycompany.phrase.dao.CommonDao;

@Slf4j
@Component
@RequiredArgsConstructor
public class Job {

    private final CommonDao commonDao;

    private static int c = 0;

    @Scheduled(cron = "*/3 * * * * *")
    @SchedulerLock(name = "job")
    public void job() throws InterruptedException {

        log.info("first_instance: {}", ++c);
        commonDao.testSchedulerLock("first_instance " + c);
        Thread.sleep(500);

    }
}