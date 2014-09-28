package viewpagerdemo.android.baidao.com.androidwizard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bruce on 9/28/14.
 */
public class PageNode {
    protected List<PageNode> nodes = new ArrayList<PageNode>();
    protected Page page;

    public PageNode setPage(Page page) {
        this.page = page;
        return this;
    }

    public PageNode addChild(PageNode pageNode) {
        nodes.add(pageNode);
        return this;
    }

    public int height() {
        if (nodes.size() == 0) {
            return 1;
        }

        return nodes.get(0).height() + 1;
    }

    public Page find(int id) {
        if (page.id == id) {
            return page;
        }
        if (nodes.size() == 0) {
            return null;
        }

        return nodes.get(0).find(id);
    }
}
