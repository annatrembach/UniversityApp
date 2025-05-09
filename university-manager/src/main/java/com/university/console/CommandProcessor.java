package com.university.console;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandProcessor {

    public List<Command> commands;

    public CommandProcessor(List<Command> commands) {
        this.commands = commands;
    }

    public void processCommand(String input) {
        for (Command command : commands) {
            if (command.execute(input)) { return; }
        }
        System.out.println("Unknown command.");
    }

}
