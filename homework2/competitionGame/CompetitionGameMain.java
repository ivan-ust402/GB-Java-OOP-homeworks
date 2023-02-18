package homework2.competitionGame;

import homework2.competitionGame.adapters.RoadObstacleAdapter;
import homework2.competitionGame.adapters.WallObstacleAdapter;
import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.obstacles.Road;
import homework2.competitionGame.obstacles.SwimmingPool;
import homework2.competitionGame.obstacles.Wall;

public class CompetitionGameMain {
    public static void main(String[] args) {
    // Реализуем соревнования
        // Должны быть участники и препятствия
        // У участника есть параметры: возможности бега (длина), 
        // прыжка (высота), плавание (длина)
        // 3 типа препятствия: беговая дорожка и стена и бассейн
        // 3 типа участников: обычный, кот и читер
        // Обычный участник умеет все в зависимости от параметров
        // Кот не умеет плавать
        // Читер всегда преодолевает препятствия, какими бы они не были

        // есть игра CompetitionGameMain, она оперирует понятиями 
        // Participant, Obstacle. Мы ее написали и у нас возникает 
        // следующее препятствие
        // Wall, который зависит от Participant
        // Road -> Participant
        // SwimmingPool -> Participant
        // Прошло время и мы хотим в нашем же проекте написать другую 
        // подсистему AnotherSubSystem, но в этой системе нет Participant
        // получается мы не можем переиспользовать класс Wall, потому что
        // он зависит от интерфейса, которого у нас нет в 
        // AnotherSubSystem 
        // Чтобы эту связь разорвать вводится адаптер и отвязывается 
        // зависимость Wall от Participant
        // Wall зависит при использовании адаптера только от интерфейса 
        // CanJump

        
    }
    private static Obstacle[] createObstacles() {
        return new Obstacle[] {
            new RoadObstacleAdapter(new Road(100)),
            new RoadObstacleAdapter(new Road(45)),
            new SwimmingPool(20),
            new WallObstacleAdapter(new Wall(40)),
        };
    }
}