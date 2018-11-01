package com.mycompany.app;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
/**
 * Hello world!
 *
 */
public class App implements Job{
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println( "Hello World!" );
    }
}
