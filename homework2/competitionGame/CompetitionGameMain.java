package homework2.competitionGame;

import homework2.competitionGame.adapters.MountainObstacleAdapter;
import homework2.competitionGame.adapters.RoadObstacleAdapter;
import homework2.competitionGame.adapters.SwimPoolObstacleAdapter;
import homework2.competitionGame.adapters.WallObstacleAdapter;
import homework2.competitionGame.interfaces.Obstacle;
import homework2.competitionGame.interfaces.Participant;
import homework2.competitionGame.obstacles.Mountain;
import homework2.competitionGame.obstacles.Road;
import homework2.competitionGame.obstacles.SwimmingPool;
import homework2.competitionGame.obstacles.Wall;
import homework2.competitionGame.particiant.Cat;
import homework2.competitionGame.particiant.Cheater;
import homework2.competitionGame.particiant.StandartParticipant;

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

        // Homework!!!
        // 0. Ознакомиться с кодом урока 2, подготовить вопросы к 
        // следующему уроку!
        // 1. Дописать адаптеры для бассейна
        // 2. *Придумать собственный тип препятствий и прикрутить 
        // его в проект по аналогии/

        Obstacle[] obstacles = createObstacles();
        Participant[] participants = createParticipants();
        for (Participant participant: participants) {
            for (Obstacle obstacle : obstacles) {
                boolean result = obstacle.pass(participant);
                if (result) {
                    System.out.println("Участник #" + participant.getName() + " преодолел препятствие");
                } else {
                    System.out.println("Участник #" + participant.getName() + " НЕ преодолел препятствие");
                }
            }
        }
        
    }
    private static Obstacle[] createObstacles() {
        return new Obstacle[] {
            new RoadObstacleAdapter(new Road(100)),
            new RoadObstacleAdapter(new Road(45)),
            new SwimPoolObstacleAdapter(new SwimmingPool(20)),
            new WallObstacleAdapter(new Wall(40)),
            new MountainObstacleAdapter(new Mountain(1000)),
        };
    }

    private static Participant[] createParticipants() {
        return new Participant[] {
            new StandartParticipant("Igor", 50, 30, 20, 1000),
            new Cat("Murzik", 60, 25, 500),
            new Cheater("Cheater")
        };
    }
}