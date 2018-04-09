package br.com.command;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GenericCommandResult implements CommandResult {

    private boolean success;
    private String message;

}
