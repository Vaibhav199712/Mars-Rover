import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private List<Command> commands = new ArrayList<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void executeCommands(Rover rover) {
        for (Command command : commands) {
            command.execute(rover);
        }
        commands.clear();
    }
}