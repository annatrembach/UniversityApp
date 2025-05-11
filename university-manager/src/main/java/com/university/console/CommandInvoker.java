package com.university.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandInvoker {

    @Autowired
    public List<Command> commands;

    public void executeCommand(String input) {
        for (Command command : commands) {
            if (command.execute(input)) { return; }
        }
        System.out.println("Unknown command.");
    }
}
