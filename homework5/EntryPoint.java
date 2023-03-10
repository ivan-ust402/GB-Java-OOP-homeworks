package homework5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;

import homework5.RobotMap.Robot;


// Реализовать MVP паттерн
// Меню пользователя:
// Список доступных действий:
//                 1. Для создания робота введите create x, y, где x, y - 
//                 координаты местоположения нового робота.
//                 2. Для вывода списка всех созданных роботов, введите list 
//                 3. Для перемещения робота введите move id x, y, где id -
//                 идентификатор робота
//                 4. hw: для изменения направления введите changedir id 
//                 DIRECTION, где id - идентификатор робота, DIRECTION -
//                 одно из значений (TOP, RIGHT, BOTTOM, LEFT) 
//                 5. Для удаления робота введите delete id, где id - 
//                 идентификатор робота 
//                 6. Для выхода напишите exit
//                 ...список будет пополняться
public class EntryPoint {
    public static void main(String[] args) {
        // VIEW
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.println("Приветствуем в игре RobotGame!");
        System.out.println("Введите размеры карты: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Читаем строку до конца
        sc.nextLine();
        RobotMap map = new RobotMap(n, m);
        System.out.println("Карта успешно создана!");
        final CommandManager manager = new CommandManager(map);

        while (true) {
            System.out.println("""
                Список доступных действий:
                    1. Для создания робота введите create x, y, где x, y - 
                    координаты местоположения нового робота.
                    2. Для вывода списка всех созданных роботов, введите list 
                    3. Для перемещения робота введите move id x, y, где id -
                    идентификатор робота
                    4. Для изменения направления введите changedir id 
                    DIRECTION, где id - идентификатор робота, DIRECTION -
                    одно из значений (TOP, RIGHT, BOTTOM, LEFT) 
                    5. Для удаления робота введите delete id, где id - 
                    идентификатор робота 
                    6. Для выхода напишите exit
                    ...список будет пополняться
                    """); 
            String command = sc.nextLine();
            // Инкапсулируем обработку команд
            manager.acceptCommand(command);
        }       
    }
    // CONTROLLER
    private static class CommandManager {
        RobotMap map;
        private final List<CommandHandler> handlers;

        CommandManager(RobotMap map) {
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
                RobotMap.Robot robot = map.createRobot(new Point(x,y));
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
                Optional<RobotMap.Robot> robot = map.getByID(robotId);
                robot.ifPresentOrElse(RobotMap.Robot::move, () -> {
                    System.out.println("Робот с идентификатором " + robotId + " не найден!");
                });
            }));
        }

        private void initChangeDirCommandHandler() {
            handlers.add(createHandler("changedir", args -> {
                Long robotId = Long.parseLong(args[0]);
                String dirInput = args[1];
                Optional<Direction> dirOptional = Direction.ofString(dirInput);
                Optional<RobotMap.Robot> robot = map.getByID(robotId);
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
                Optional<RobotMap.Robot> robot = map.getByID(robotId);
                robot.ifPresentOrElse(new Consumer<RobotMap.Robot>() {

                    @Override
                    public void accept(Robot robot) {
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
}