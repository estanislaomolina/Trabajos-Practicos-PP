package linea;

import java.util.ArrayList;
import java.util.Arrays;

public class Commands {
        private Character name;
        GameMode command;

        public Commands(Character name, GameMode command) {
            this.name = name;
            this.command = command;
        }
        public static ArrayList<Commands> commands = new ArrayList<Commands>
                (Arrays.asList(
                        new Commands('A', new ModeA())

                ));

        public static Commands getCommand(Character commandName) {
            return commands.stream()
                    .filter(command -> command.commandEquals(String.valueOf(commandName)))
                    .findFirst()
                    .get();
        }

        public void runCommands(Linea mode) {
            command.isGameOver(mode);
        }
        public boolean commandEquals(String command){
            return this.name.equals(command);
        }
    }

