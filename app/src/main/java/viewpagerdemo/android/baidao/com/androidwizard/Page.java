package viewpagerdemo.android.baidao.com.androidwizard;

/**
 * Created by bruce on 9/28/14.
 */
public class Page {
    protected int id;
    protected String title;

    public Page(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
