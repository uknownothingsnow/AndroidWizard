package viewpagerdemo.android.baidao.com.androidwizard;

import android.support.v4.app.Fragment;

/**
 * Created by bruce on 9/28/14.
 */
public class Page {
    protected int id;
    protected String title;
    protected Fragment fragment;
    protected boolean completed;

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

    public Fragment getFragment() {
        return fragment;
    }

    public Page setFragment(Fragment fragment) {
        this.fragment = fragment;
        return this;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
