package ru.yandex.practicum.constructor;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtaskForEpic;

    public Epic(String title, String description) {
        super(title, description);
        this.subtaskForEpic = new ArrayList<>();
    }

    public void addSubtaskForEpic(Subtask subtask) {
        for (Subtask sub : subtaskForEpic) {
            if (sub.getTitle().equals(subtask.getTitle())) {
                System.out.println("Такой Subtask уже существует!");
                return;
            }
        }
        subtaskForEpic.add(subtask);
    }

    public ArrayList<Subtask> getListSubtask() {
        return subtaskForEpic;
    }

    public void checkStatusEpic() {
        if (subtaskForEpic.isEmpty()) {
            System.out.println("Subtask отсутствует!");
            return;
        }

        boolean hasNew = false;
        boolean hasDone = false;

        for (Subtask subtask : subtaskForEpic) {
            switch (subtask.getStatus()) {
                case Status.NEW:
                    hasNew = true;
                    break;
                case Status.DONE:
                    hasDone = true;
                    break;
                case Status.IN_PROGRESS:
                    this.status = Status.IN_PROGRESS;
                    System.out.println("Epic status - " + this.status + '!');
                    return;
                }
            }

        if (hasNew && !hasDone) {
            this.status = Status.NEW;
            System.out.println("Epic status - " + this.status + '!');
        } else if (!hasNew && hasDone) {
            this.status = Status.DONE;
        } else {
            this.status = Status.IN_PROGRESS;
            System.out.println("Epic status - " + this.status + '!');
        }
    }

    @Override
    public String toString() {
        return "Epic{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
