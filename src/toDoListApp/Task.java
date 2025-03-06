package toDoListApp;

public class Task {
    private String title;
    private boolean status;

    public Task(String title) {
        this.title = title;
        this.status = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void markComplete() {
        status = true;
    }

    @Override
    public String toString() {
        return (status? "[✔]. ":"[ ]. ")+title;
    }
}
