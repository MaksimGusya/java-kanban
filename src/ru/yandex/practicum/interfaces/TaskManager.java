package ru.yandex.practicum.interfaces;

import ru.yandex.practicum.constructor.*;
import java.util.ArrayList;

public interface TaskManager {
    int createId();

    ArrayList<Task> printAllTasks();

    ArrayList<Epic> printAllEpic();

    ArrayList<Subtask> printAllSubtasks();

    boolean removeAllTasks();

    boolean removeAllEpicAndSubtasks();

    boolean removeAllSubtasks();

    Task getTaskById(int idTask);

    Epic getEpicById(int idEpic);

    Subtask getSubtaskById(int idSubtask);

    Task addTask(Task task);

    Epic addEpic(Epic epic);

    Subtask addSubtask(Subtask subtask);

    Task updateTask(int idTask, String newTitle, String newDescription, String newStatus);

    Epic updateEpic(int idEpic, String newTitle, String newDescription);

    Subtask updateSubtask(int idSubtask, String newTitle, String newDescription);

    boolean removeTaskById(int idTask);

    boolean removeEpicById(int idEpic);

    boolean removeSubtaskById(int idSubtask);

    ArrayList<Subtask> getAllSubtaskForEpic(int idEpic);

    Task updateStatusTask(int idTask, String newStatus);

    Subtask updateStatusSubtask(int idSubtask, String newStatus);

    ArrayList<Task> getHistory();
}
