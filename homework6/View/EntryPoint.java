package homework6.View;

import java.util.Scanner;
import homework6.Model.RobotMap;
import homework6.Presenter.CommandManager;


// HW:
// 1. В проекте RobotMap сделать интерфейс для робота. Везде наружу (в метод #main) отдавать интерфейс. Создание объекта конкретного класса должно быть ровно в одном месте внутри класса RobotMap.
// 2. * При желании, сделать рефакторинг проекта RobotMap, описать проделанную работу и объяснить, какую пользу несут изменения.

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
}