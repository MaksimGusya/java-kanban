package ru.yandex.practicum.interfaces;

import ru.yandex.practicum.constructor.Task;
import java.util.ArrayList;

public interface HistoryManager {

    void add(Task task);
    ArrayList<Task> getHistory();
}
