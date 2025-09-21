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
        this.idForEpic = newIdForEpic;
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
