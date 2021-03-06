package com.news.dev.config.batch.contents;

import com.news.dev.jpa.entity.ContentsEntity;
import com.news.dev.jpa.repository.ContentsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.time.LocalDate;
import java.util.Collection;

@Slf4j
public class ContentsJobListener implements JobExecutionListener {

    private final ContentsRepository contentsRepository;

    public ContentsJobListener(ContentsRepository contentsRepository) {
        this.contentsRepository = contentsRepository;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {

    }

    @Override
    public void afterJob(JobExecution jobExecution) {
//        Collection<ContentsEntity> contents = contentsRepository.findAllByUpdDtm(LocalDate.now());

        // Job 수행시간
        long time = jobExecution.getEndTime().getTime() - jobExecution.getStartTime().getTime();

        log.info("New 컨텐츠 업데이트 배치 프로그램");
        log.info("--------------------------------");
        log.info("처리 시간 {}millis", time);

    }
}
