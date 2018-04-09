package br.com.handle;

import br.com.command.Command;
import br.com.command.CommandResult;

public interface Handler<T extends Command> {

    CommandResult handle(T command);
}
