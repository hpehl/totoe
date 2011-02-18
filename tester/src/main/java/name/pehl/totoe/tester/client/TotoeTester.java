package name.pehl.totoe.tester.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.TabLayoutPanel;

/**
 * @author $Author: harald.pehl $
 * @version $Date: 2010-10-27 00:56:25 +0200 (Mi, 27. Okt 2010) $ $Revision: 629
 *          $
 */
public class TotoeTester implements EntryPoint
{
    // @formatter:off
    interface Binder extends UiBinder<TabLayoutPanel, TotoeTester> {}
    private static final Binder binder = GWT.create(Binder.class);
    // @formatter:on

    @Override
    public void onModuleLoad()
    {
        Resources.INSTANCE.style().ensureInjected();
        Resources.INSTANCE.widgets().ensureInjected();
        RootLayoutPanel.get().add(binder.createAndBindUi(this));
    }
}
