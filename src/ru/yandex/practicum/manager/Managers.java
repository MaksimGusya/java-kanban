package ru.yandex.practicum.manager;

import ru.yandex.practicum.manager.*;
import ru.yandex.practicum.interfaces.*;

public class Managers {

    private Managers() {
    }

    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }
}

