package viewpagerdemo.android.baidao.com.androidwizard;

/**
 * Created by bruce on 9/28/14.
 */
public class PageContainer {
    PageNode pageNode = new PageNode();

    public PageContainer() {
        init();
    }

    public void init() {
        pageNode = new PageNode()
            .setPage(
                new Page(Pages.FIRST.ordinal(), FIRST_TITLE)
                .setFragment(SingleChoiceFragment.newInstance(Pages.FIRST.ordinal(), FIRST_TITLE))
            )
            .addChild(
                new PageNode()
                    .setPage(
                        new Page(Pages.SECOND.ordinal(), SECOND_TITLE)
                        .setFragment(TextFragment.newInstance(Pages.SECOND.ordinal(), SECOND_TITLE))
                    )
                    .addChild(
                        new PageNode()
                            .setPage(
                                new Page(Pages.THIRD.ordinal(), THIRD_TITLE)
                                .setFragment(TextFragment.newInstance(Pages.THIRD.ordinal(), THIRD_TITLE))
                            )
                            .addChild(
                                new PageNode()
                                    .setPage(
                                        new Page(Pages.FOURTH.ordinal(), FOURTH_TITLE)
                                        .setFragment(TextFragment.newInstance(Pages.FOURTH.ordinal(), FOURTH_TITLE))
                                    )
                            )
                    )
            );
    }

    public int size() {
        return pageNode.height();
    }

    public Page getPage(int id) {
        return pageNode.find(id);
    }

    public static enum Pages {
        FIRST, SECOND, THIRD, FOURTH, FIFTH
    }

    public static final String FIRST_TITLE = "First";
    public static final String SECOND_TITLE = "Second";
    public static final String THIRD_TITLE = "Third";
    public static final String FOURTH_TITLE = "Fourth";
    public static final String FIFTH_TITLE = "Fifth";
}
