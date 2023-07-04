package com.csvconverter.csvconverter;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-converter")
public class CsvConverterController {

    private final JobLauncher jobLauncher;
    private final Job job;

    public CsvConverterController(JobLauncher jobLauncher, Job job) {
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

    @GetMapping("/convert")
    public String convertCsv() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        JobExecution jobExecution = jobLauncher.run(job, jobParameters);

        BatchStatus status = jobExecution.getStatus();
        if (status == BatchStatus.COMPLETED) {
            return "CSV conversion completed successfully";
        } else {
            return "CSV conversion failed with status: " + status;
        }
    }
}
