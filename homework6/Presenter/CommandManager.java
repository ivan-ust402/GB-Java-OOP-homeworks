package homework6.Presenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import homework6.Model.Direction;
import homework6.Model.Point;
import homework6.Model.RobotInterface;
import homework6.Model.RobotMap;

public class CommandManager {
    RobotMap map;
    private final List<CommandHandler> handlers;

    public CommandManager(RobotMap map) {
        this.map = map;
        handlers = new ArrayList<>();
        initHandlers();
    }

    private interface CommandHandler{
        String name();
        void runCommand(String[] args);
    }

    private void initHandlers() {
        initCreateCommandHandler();
        initListCommandHandler();
        initMoveCommandHandler();
        initChangeDirCommandHandler();
        initDeleteCommandHandler();
        initExitCommandHandler();
    }

    private void initCreateCommandHandler() {
        handlers.add(createHandler("create", args -> {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            RobotInterface robot = map.createRobot(new Point(x,y));
            System.out.println("Робот " + robot + " успешно создан!");
        }));
    }

    private void initListCommandHandler() {
        handlers.add(createHandler("list", args -> {
            map.acceptRobots(System.out::println);
        }));
    }

    private void initMoveCommandHandler() {
        handlers.add(createHandler("move", args -> {
            Long robotId = Long.parseLong(args[0]);
            Optional<RobotInterface> robot = map.getByID(robotId);
            robot.ifPresentOrElse(RobotInterface::move, () -> {
                System.out.println("Робот с идентификатором " + robotId + " не найден!");
            });
        }));
    }

    private void initChangeDirCommandHandler() {
        handlers.add(createHandler("changedir", args -> {
            Long robotId = Long.parseLong(args[0]);
            String dirInput = args[1];
            Optional<Direction> dirOptional = Direction.ofString(dirInput);
            Optional<RobotInterface> robot = map.getByID(robotId);
            if(dirOptional.isEmpty()) {
                System.out.println("Направления движения " + dirInput + " не существует!");
            }
            if(robot.isEmpty()) {
                System.out.println("Робот с идентификатором " + robotId + " не найден!");
            } 
            if(dirOptional.isPresent() && robot.isPresent()) {
                robot.get().changeDirection(dirOptional.get());
            }            
        }));
    }

    private void initDeleteCommandHandler() {
        handlers.add(createHandler("delete", args -> {
            Long robotId = Long.parseLong(args[0]);
            Optional<RobotInterface> robot = map.getByID(robotId);
            robot.ifPresentOrElse(new Consumer<RobotInterface>() {

                @Override
                public void accept(RobotInterface robot) {
                    map.deleteRobot(robot);
                    System.out.println();
                }

                }, () -> {
                    System.out.println("Робот с идентификатором " + robotId + " не найден!");
                }
            );
        }));
    }

    private void initExitCommandHandler() {
        handlers.add(createHandler("exit", args -> {
            System.exit(0);
        }));
    }

    private CommandHandler createHandler(String name, Consumer<String[]> delegate) {
        return new CommandHandler() {

            @Override
            public String name() {
                return name;
            }

            @Override
            public void runCommand(String[] args) {
                delegate.accept(args);
            }
            
        };
        
    }



    public void acceptCommand(String command) {
        String[] split = command.split(" ");
        String commandName = split[0];
        String[] commandArgs = Arrays.copyOfRange(split, 1, split.length);
        boolean found = false;

        for (CommandHandler handler : handlers) {
            if(commandName.equals(handler.name())) {
                found = true;

                try {
                    handler.runCommand(commandArgs);
                } catch (Exception e) {
                    System.err.println("Во время обработки команды \"" + commandName + "\" произошла ошибка: " + e.getMessage());
                }
                
            }
        }

        if(!found) {
            System.out.println("Команда не найдена!");
        }
    }
}
