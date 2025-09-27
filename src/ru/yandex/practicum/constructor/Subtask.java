package ru.yandex.practicum.constructor;

public class Subtask extends Task {
    private int idForEpic;

    public Subtask(String title, String description, int idForEpic) {
        super(title, description);
        this.idForEpic = idForEpic;
    }

    public int getIdForEpic() {
        return idForEpic;
    }

    public void setIdForEpic(int newIdForEpic) {
        if (newIdForEpic == this.id) {
            System.out.println("Некорректный Id!");
            return;
        }
        this.idForEpic = newIdForEpic;
    }

    @Override
    public void setId(int newId) {
        if (newId == this.idForEpic) {
            System.out.println("Некорректный Id!");
            return;
        }
        super.setId(newId);
    }


    @Override
    public String toString() {
        return "Subtask{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
