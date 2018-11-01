package com.mycompany.app;

import com.mycompany.app.App;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;



public class QuartzTest {

    public static void main(String[] args) {

        try {
            // Grab the Scheduler instance from the Factory
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // and start it off
            scheduler.start();

            // define the job and tie it to our HelloJob class
            JobDetail job = newJob(App.class)
                .withIdentity("job1", "group1")
                .build();

            // Trigger the job to run now, and then repeat every 40 seconds
            Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                      .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())            
                .build();

            // Tell quartz to schedule the job using our trigger
            scheduler.scheduleJob(job, trigger);

            try{
              Thread.sleep(60000);
            } catch (InterruptedException e){
              e.printStackTrace();
              scheduler.shutdown();
            }
            scheduler.shutdown();
            System.out.println("Shutting Down");

        } catch (SchedulerException se) {
            System.out.println("Exceptions");
            se.printStackTrace();
        }
    }
}