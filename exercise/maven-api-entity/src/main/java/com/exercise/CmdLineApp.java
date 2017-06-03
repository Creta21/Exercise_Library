// auto den ftiaxnetai me kapoio tropo. tin pairnoume apo edw copy-paste kai th 
// xrhsimopoioume
package com.exercise;

import com.exercise.repository.BookRepository;
import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan("com.exercise.repository")
@Component
public class CmdLineApp implements CommandLineRunner{
    
    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test");
        LogManager.getLogger(CmdLineApp.class).info("This is the log message");
        
        System.out.println("---------------------BOOKS--------------------");
        System.out.println(bookRepo.findAll());
    }
}