package entity;

/**
 *
 * @author THAYCACAC
 */
public class History implements Comparable<History> {

    private Worker worker;
    private String status;
    private String date;

    public History() {
    }

    public History(Worker worker, String status, String date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return worker.getId();
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(History t) {
        return this.worker.getId().compareTo(t.getWorker().getId());
    }

    public void display() {
        System.out.println(worker.getId()
                + "\t" + worker.getName()
                + "\t" + worker.getAge()
                + "\t" + worker.getSalary()
                + "\t" + status + "\t" + date);
    }
}
