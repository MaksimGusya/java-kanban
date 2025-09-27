package ru.yandex.practicum.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.constructor.*;
import ru.yandex.practicum.manager.Managers;
import ru.yandex.practicum.interfaces.TaskManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestManager{

    private TaskManager manager;

    @BeforeEach
    void setUp() {
        manager = Managers.getDefault();
    }

    @Test
    void testTaskEqualityById() {
        Task task1 = new Task("1", "task1");
        Task task2 = new Task("2", "task2");

        task1.setId(1);
        task2.setId(1);

        assertEquals(task1, task2, "Task не равны");
    }

    @Test
    void testEpicSubtaskEqualityById() {
        Epic epic1 = new Epic("1", "epic1");
        Epic epic2 = new Epic("2", "epic2");

        epic1.setId(5);
        epic2.setId(5);

        assertEquals(epic1, epic2, "Epic не равны");

        Subtask subtask1 = new Subtask("1", "subtask1", 1);
        Subtask subtask2 = new Subtask("2", "subtask2", 2);

        subtask1.setId(10);
        subtask2.setId(10);

        assertEquals(subtask1, subtask2, "Subtask не равны");
    }

    @Test
    void testEpicCannotContainItselfAsSubtask() {
        Epic epic = new Epic("Epic", "Description");
        epic.setId(1);

        Subtask subtask = new Subtask("Epic", "Description", 1);
        subtask.setId(1);

        epic.addSubtaskForEpic(subtask);

        boolean containsSelf = epic.getListSubtask()
                .stream()
                .anyMatch(s -> s.getId() == epic.getId());

        assertFalse(containsSelf, "Epic не должен содержать сам себя как подзадачу");
    }

    @Test
    void testSubtaskCannotBeSubtask() {
        Subtask subtask = new Subtask("1", "Sub", 1);
        subtask.setId(1);

        assertNotEquals(subtask.getIdForEpic(), subtask.getId(),
                "Некорректный Id!");
    }

    @Test
    void testManagersReturnsInitializedManagers() {
        assertNotNull(Managers.getDefault(), "Managers.getDefault не соответствует TaskManager");
        assertNotNull(Managers.getDefaultHistory(), "Managers.getDefaultHistory "
                + "не соответствует HistoryManager");
    }

    @Test
    void testAddForTaskEpicSubtask() {
        Task task = new Task("1", "task");
        manager.addTask(task);

        Epic epic = new Epic("1", "epic");
        manager.addEpic(epic);

        Subtask subtask = new Subtask("1", "subtask", epic.getId());
        manager.addSubtask(subtask);

        assertNotNull(manager.getTaskById(task.getId()), "Task не найден по id");
        assertNotNull(manager.getEpicById(epic.getId()), "Epic не найден по id");
        assertNotNull(manager.getSubtaskById(subtask.getId()), "Subtask не найден по id");
    }

    @Test
    void testTasksWithValidIdAndGeneratedIdDoNotConflict() {
        Task task1 = new Task("1", "task1");
        task1.setId(100);

        manager.addTask(task1);

        Task task2 = new Task("2", "task2");
        manager.addTask(task2);

        assertNotEquals(task1.getId(), task2.getId(), "Заданный и сгенерированный Id не проходят проверку");
    }

    @Test
    void testTaskImmutabilityAfterAdd() {
        Task task = new Task("Original", "Desc");
        manager.addTask(task);

        Task testTask = manager.getTaskById(task.getId());

        assertEquals(task.getTitle(), testTask.getTitle(), "Title не раны");
        assertEquals(task.getDescription(), testTask.getDescription(), "Description не равны");
    }

    @Test
    void testHistoryManagerKeepsTasks() {
        Task task = new Task("1", "task");
        manager.addTask(task);
        manager.getTaskById(task.getId());

        Epic epic = new Epic("1", "epic");
        manager.addEpic(epic);
        manager.getEpicById(epic.getId());

        Subtask subtask = new Subtask("1", "subtask", epic.getId());
        manager.addSubtask(subtask);
        manager.getSubtaskById(subtask.getId());

        ArrayList<Task> history = manager.getHistory();

        assertEquals(3, history.size(), "Не все задачи сохранены в history");
        assertTrue(history.contains(task), "task отсутствует");
        assertTrue(history.contains(epic), "epic отсутствует");
        assertTrue(history.contains(subtask), "subtask отсутствует");
    }
}