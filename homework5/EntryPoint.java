package homework5;

import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;

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
                    4*. hw: Для изменения направления введите changedir id 
                    DIRECTION, где id - идентификатор робота, DIRECTION -
                    одно из значений (TOP, RIGHT, BOTTOM, LEFT) 
                    5*. hw: Для удаления робота введите delete id, где id - 
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

        CommandManager(RobotMap map) {
            this.map = map;
        }

        public void acceptCommand(String command) {

        }


    }
}