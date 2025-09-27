package ru.yandex.practicum;

import ru.yandex.practicum.interfaces.TaskManager;
import ru.yandex.practicum.manager.*;
import ru.yandex.practicum.constructor.*;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = Managers.getDefault();



//        Код написанный ниже использовался для проверки.

//        System.out.println(taskManager.printAllTasks());
//
//        Task task1 = new Task("Отдохнуть", "Поиграть в игры");
//        taskManager.addTask(task1);
//        System.out.println(taskManager.printAllTasks());
//
//        taskManager.updateTask(1, "Начать работать",
//                "Включить компьютер", "DONE");
//        System.out.println(taskManager.printAllTasks());
//
//        taskManager.updateStatusTask(1, "IN_PROGRESS");
//        System.out.println(taskManager.printAllTasks());
//
//        taskManager.removeTaskById(1);
//        System.out.println(taskManager.printAllTasks());
//
//        Task task2 = new Task("Учеба", "Закончить спринт 4");
//        taskManager.addTask(task2);
//        System.out.println(taskManager.printAllTasks());
//
//        Epic epic1 = new Epic("Тусовка", "Собрать друзей");
//
//        taskManager.addEpic(epic1);
//        int epicId = epic1.getId();
//
//        Subtask subtask1 = new Subtask("Выбрать еду", "заказать еду", epicId);
//        Subtask subtask2 = new Subtask("Посчитать стулья", "Купить стулья", epicId);
//
//        taskManager.addSubtask(subtask1);
//        taskManager.addSubtask(subtask2);
//
//        System.out.println(taskManager.printAllEpic());
//        System.out.println(taskManager.printAllSubtasks());
//        taskManager.getAllSubtaskForEpic(epicId);
//
//        taskManager.updateEpic(1, "Собрать друзей", "Организовать мероприятие");
//        System.out.println(taskManager.printAllEpic());
//
//        taskManager.updateSubtask(2, "Написать друзьям", "Создать беседу");
//        System.out.println(taskManager.printAllSubtasks());
//
//        taskManager.updateStatusSubtask(2,"DONE");
//        System.out.println(taskManager.printAllSubtasks());
//        System.out.println(taskManager.printAllEpic());
//        System.out.println(taskManager.printAllSubtasks());
//
//        taskManager.removeSubtaskById(2);
//        System.out.println(taskManager.printAllSubtasks());
//
//        taskManager.getAllSubtaskForEpic(epicId);
//
//        Epic epic2 = new Epic("Уборка", "Выбрать бригаду");
//        taskManager.addEpic(epic2);
//        int epicId2 = epic2.getId();
//
//        Subtask subtask3 = new Subtask("Назначить исполнителей", "Распределить работу", epicId2);
//        taskManager.addSubtask(subtask3);
//
//        System.out.println(taskManager.printAllEpic());
//        System.out.println(taskManager.printAllSubtasks());
//        taskManager.getAllSubtaskForEpic(epicId2);
//
//        Task task1 = new Task("Проверка", "0");
//        Task task2 = new Task("1", "1");
//        Task task3 = new Task("2", "2");
//        Task task4 = new Task("3", "3");
//        Task task5 = new Task("4", "4");
//        Epic epic1 = new Epic("5", "5");
//        Epic epic2 = new Epic("6", "6");
//        Epic epic3 = new Epic("7", "7");
//        Epic epic4 = new Epic("8", "8");
//        Epic epic5 = new Epic("9", "9");
//        Epic epic6 = new Epic("10", "10");
//        Subtask subtask1 = new Subtask("11", "11", 6);
//        Subtask subtask2 = new Subtask("12", "12", 7);
//        Subtask subtask3 = new Subtask("13", "13", 8);
//
//
//        taskManager.addTask(task1);
//        taskManager.addTask(task2);
//        taskManager.addTask(task3);
//        taskManager.addTask(task4);
//        taskManager.addTask(task5);
//        taskManager.addEpic(epic1);
//        taskManager.addEpic(epic2);
//        taskManager.addEpic(epic3);
//        taskManager.addEpic(epic4);
//        taskManager.addEpic(epic5);
//        taskManager.addEpic(epic6);
//        taskManager.addSubtask(subtask1);
//        taskManager.addSubtask(subtask2);
//        taskManager.addSubtask(subtask3);
//
//        System.out.println(taskManager.printAllTasks());
//        System.out.println(taskManager.printAllEpic());
//        System.out.println(taskManager.printAllSubtasks());
//
//
//        for (int i = 0; i < 15; i++) {
//            taskManager.getTaskById(i + 1);
//        }
//
//        for (int i = 0; i < 15; i++) {
//            taskManager.getEpicById(i + 1);
//        }
//
//        for (int i = 0; i < 15; i++) {
//            taskManager.getSubtaskById(i + 1);
//        }
//
//        System.out.println(taskManager.getHistory());
    }


}
