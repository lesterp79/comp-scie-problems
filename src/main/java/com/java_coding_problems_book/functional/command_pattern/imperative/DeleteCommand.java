package com.java_coding_problems_book.functional.command_pattern.imperative;


public class DeleteCommand implements Command {

    private final IODevice action;

    public DeleteCommand(IODevice action) {
        this.action = action;
    }

    @Override
    public void execute() {
        action.delete();
    }
}