package ru.yandex.practicum.manager;

import ru.yandex.practicum.constructor.*;
import ru.yandex.practicum.interfaces.*;

import java.util.HashMap;
import java.util.ArrayList;

public class InMemoryTaskManager implements TaskManager {
    HashMap<Integer, Task> storeTask = new HashMap<>();
    HashMap<Integer, Epic> storeEpic = new HashMap<>();
    HashMap<Integer, Subtask> storeSubtask = new HashMap<>();
    private final HistoryManager historyManager = Managers.getDefaultHistory();
    private int id = 1;

    @Override
    public int createId() {
        return id++;
    }

    @Override
    public ArrayList<Task> printAllTasks() {
        ArrayList<Task> allTask = new ArrayList<>();

        if (storeTask.isEmpty()) {
            System.out.println("Task пустой!");
            return null;
        }

        for (Task task : storeTask.values()) {
            allTask.add(task);
        }
        return allTask;
    }

    @Override
    public ArrayList<Epic> printAllEpic() {
        ArrayList<Epic> allEpic = new ArrayList<>();

        if (storeEpic.isEmpty()) {
            System.out.println("Epic пустой!");
            return null;
        }

        for (Epic epic : storeEpic.values()) {
            allEpic.add(epic);
        }
        return allEpic;
    }

    @Override
    public ArrayList<Subtask> printAllSubtasks() {
        ArrayList<Subtask> allSubtask = new ArrayList<>();

        if (storeSubtask.isEmpty()) {
            System.out.println("Subtask пустой!");
            return null;
        }

        for (Subtask subtask : storeSubtask.values()) {
            allSubtask.add(subtask);
        }
        return allSubtask;
    }

    @Override
    public boolean removeAllTasks() {
        storeTask.clear();
        System.out.println("Task очищен!");
        return true;
    }

    @Override
    public boolean removeAllEpicAndSubtasks() {
        storeEpic.clear();
        storeSubtask.clear();
        System.out.println("Epic и Subtask очищены!");
        return true;
    }

    @Override
    public boolean removeAllSubtasks() {
        storeSubtask.clear();
        System.out.println("Subtask был очищен!");
        return true;
    }

    @Override
    public Task getTaskById(int idTask) {
        if (storeTask.isEmpty()) {
            System.out.println("Task пустой!");
            return null;
        } else if (storeTask.get(idTask) == null) {
            System.out.println("В ячейке - " + idTask + " отсуствует информация!");
            return null;
        } else {
            Task task = storeTask.get(idTask);
            historyManager.add(task);
            return task;
        }
    }

    @Override
    public Epic getEpicById(int idEpic) {
        if (storeEpic.isEmpty()) {
            System.out.println("Epic пустой!");
            return null;
        } else if (storeEpic.get(idEpic) == null) {
            System.out.println("В ячейке - " + idEpic + " отсуствует информация!");
            return null;
        } else {
            Epic epic = storeEpic.get(idEpic);
            historyManager.add(epic);
            return epic;
        }
    }

    @Override
    public Subtask getSubtaskById(int idSubtask) {
        if (storeSubtask.isEmpty()) {
            System.out.println("Subtask пустой!");
            return null;
        } else if (storeSubtask.get(idSubtask) == null) {
            System.out.println("В ячейке - " + idSubtask + " отсуствует информация!");
            return null;
        } else {
            Subtask subtask = storeSubtask.get(idSubtask);
            historyManager.add(subtask);
            return subtask;
        }
    }

    @Override
    public Task addTask(Task task) {
        task.setId(createId());
        int keyForTask = task.getId();

        storeTask.put(keyForTask, task);
        System.out.println("В Task добавлена задача -  " + task.getTitle() + '!');
        return task;

    }

    @Override
    public Epic addEpic(Epic epic) {
        epic.setId(createId());
        int keyForEpic = epic.getId();

        storeEpic.put(keyForEpic, epic);
        System.out.println("В Epic добавлена задача - " + epic.getTitle() + '!');
        return epic;
    }

    @Override
    public Subtask addSubtask(Subtask subtask) {
        Epic epic = storeEpic.get(subtask.getIdForEpic());

        if (epic == null) {
            System.out.println("Такого Epic ну существует!");
            return null;
        }

        for (Subtask subtaskForEpic : epic.getListSubtask()) {
            if (subtaskForEpic.getTitle().equals(subtask.getTitle())) {
                System.out.println("Subtask - " + subtaskForEpic.getTitle() + " уже существует!");
                return null;
            }
        }

        subtask.setId(createId());
        int keyForSubtask = subtask.getId();

        storeSubtask.put(keyForSubtask, subtask);
        epic.addSubtaskForEpic(subtask);
        System.out.println("Для Epic - " + epic.getTitle() + ", добавлен Subtask - "
                + subtask.getTitle() + '!');
        return subtask;
    }


    @Override
    public Task updateTask(int idTask, String newTitle, String newDescription, String newStatus) {
        Task task = storeTask.get(idTask);

        if (storeTask.isEmpty()) {
            System.out.println("Task пустой!");
            return null;
        } else if (task == null) {
            System.out.println("В Task нет такой задачи!");
            return null;
        } else {
            task.setTitle(newTitle);
            task.setDescription(newDescription);
        }

        for (Status status : Status.values()) {
            if (status.name().equals(newStatus)) {
                task.setStatus(status);
                System.out.println("Обновлены поля title - " + task.getTitle()
                        + ", description - " + task.getDescription()
                        + ", status - " + task.getStatus() + '!');
                return task;
            }
        }
        System.out.println("Статус - " + newStatus + " отсутствует в списке, поле status не обновлено!");
        return null;
    }

    @Override
    public Epic updateEpic(int idEpic, String newTitle, String newDescription) {
        Epic epic = storeEpic.get(idEpic);

        if (storeEpic.isEmpty()) {
            System.out.println("Epic пустой!");
            return null;
        } else if (epic == null) {
            System.out.println("В Epic нет такой задачи!");
            return null;
        } else {
            epic.setTitle(newTitle);
            epic.setDescription(newDescription);
            System.out.println("Обновлены поля title - " + epic.getTitle() + ", description - "
                    + epic.getDescription() + '!');
            return epic;
        }
    }

    @Override
    public Subtask updateSubtask(int idSubtask, String newTitle, String newDescription) {
        Subtask subtask = storeSubtask.get(idSubtask);

        if (storeSubtask.isEmpty()) {
            System.out.println("Subtask пустой!");
            return null;
        } else if (subtask == null) {
            System.out.println("В Subtask нет такой задачи!");
            return null;
        } else {
            subtask.setTitle(newTitle);
            subtask.setDescription(newDescription);
            System.out.println("Обновлены поля title - " + subtask.getTitle() + ", description - "
                    + subtask.getDescription() + '!');
            return subtask;
        }
    }

    @Override
    public boolean removeTaskById(int idTask) {
        if (storeTask.isEmpty()) {
            System.out.println("Task пуст!");
            return false;
        } else if (storeTask.get(idTask) == null) {
            System.out.println("В ячейке - " + idTask + " отсуствует информация!");
            return false;
        } else {
            storeTask.remove(idTask);
            System.out.println("Task удален!");
            return true;
        }
    }

    @Override
    public boolean removeEpicById(int idEpic) {
        Epic epic = storeEpic.get(idEpic);

        if (storeEpic.isEmpty()) {
            System.out.println("Epic пуст!");
            return false;
        } else if (storeEpic.get(idEpic) == null) {
            System.out.println("В ячейке - " + idEpic + " отсуствует информация!");
            return false;
        } else {
            ArrayList<Integer> idSubtaskForRemove = new ArrayList<>();

            for (Subtask subtask : storeSubtask.values()) {
                if (subtask.getIdForEpic() == idEpic) {
                    idSubtaskForRemove.add(subtask.getId());
                } else {
                    System.out.println("Этот Subtask не принадлежит данному Epic!");
                }
            }

            for (Integer idSubtask : idSubtaskForRemove) {
                storeSubtask.remove(idSubtask);
            }

            storeEpic.remove(idEpic);
            System.out.println("Epic и связанные Subtask удалены!");
            return true;
        }
    }

    @Override
    public boolean removeSubtaskById(int idSubtask) {
        if (storeSubtask.isEmpty()) {
            System.out.println("Subtask пуст!");
            return false;
        }

        Subtask subtask = storeSubtask.get(idSubtask);
        if (subtask == null) {
            System.out.println("В ячейке - " + idSubtask + " отсутствует информация!");
            return false;
        }

        Epic epic = storeEpic.get(subtask.getIdForEpic());
        if (epic != null) {
            ArrayList<Subtask> subtasks = epic.getListSubtask();

            for (Subtask subInArray : subtasks) {
                if (subInArray.getId() == idSubtask) {
                    subtasks.remove(subInArray);
                    break;
                }
            }

            epic.checkStatusEpic();
            System.out.println("У Epic статус - " + epic.getStatus() + '!');
        }

        storeSubtask.remove(idSubtask);

        System.out.println("Subtask удален!");
        return true;
    }

    @Override
    public ArrayList<Subtask> getAllSubtaskForEpic(int idEpic) {
        Epic epic = storeEpic.get(idEpic);

        if (storeEpic.isEmpty()) {
            System.out.println("Epic пустой!");
            return null;
        } else if (epic == null) {
            System.out.println("В Epic нет такой задачи!");
            return null;
        }

        ArrayList<Subtask> subtasks = epic.getListSubtask();

        System.out.println("У Epic - " + epic.getTitle() + ", Subtask:");
        if (subtasks.isEmpty()) {
            System.out.println("Subtask отсутствуют!");
        } else {
            for (Subtask sub : subtasks) {
                System.out.println(sub);
            }
        }
        return subtasks;
    }

    //Выше у меня реализовано изменение статуса Task при обновлении задачи, как по ТЗ.
    //Но мне кажется, что необходимо иметь возможность менять только статус у Task.
    @Override
    public Task updateStatusTask(int idTask, String newStatus) {
        Task task = storeTask.get(idTask);

        if (task == null) {
            System.out.println("Task отсутствует!");
            return null;
        }

        for (Status status : Status.values()) {
            if (status.name().equals(newStatus)) {
                task.setStatus(status);
                System.out.println("У Task - " + task.getTitle()
                        + ", обновился status - " + task.getStatus() + '!');
                return task;
            }
        }

        System.out.println("Статус - " + newStatus + " отсутствует в списке, поле status не обновлено!");
        return null;
    }

    @Override
    public Subtask updateStatusSubtask(int idSubtask, String newStatus) {
        Subtask subtask = storeSubtask.get(idSubtask);

        if (subtask == null) {
            System.out.println("Subtask отсутствует!");
            return null;
        }

        for (Status status : Status.values()) {
            if (status.name().equals(newStatus)) {
                subtask.setStatus(status);
                System.out.println("У Subtask - " + subtask.getTitle()
                        + ", обновился status - " + subtask.getStatus() + '!');

                Epic epic = storeEpic.get(subtask.getIdForEpic());
                if (epic != null) {
                    epic.checkStatusEpic();
                    System.out.println("У Epic - " + epic.getTitle() + ", status - " + epic.getStatus() + '!');
                }
                return subtask;
            }
        }

        System.out.println("Статус - " + newStatus + " отсутствует в списке!");
        return null;
    }

    @Override
    public ArrayList<Task> getHistory() {
        return historyManager.getHistory();
    }
}
