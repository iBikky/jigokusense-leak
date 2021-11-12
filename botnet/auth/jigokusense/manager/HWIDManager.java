/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.manager;

import botnet.auth.jigokusense.util.DisplayUtil;
import botnet.auth.jigokusense.util.NoStackTraceThrowable;
import botnet.auth.jigokusense.util.SystemUtil;
import botnet.auth.jigokusense.util.URLReader;
import java.util.ArrayList;
import java.util.List;

public class HWIDManager {
    public static final String pastebinURL = "https://pastebin.com/raw/RJf8EZ7y";
    public static List<String> hwids = new ArrayList<String>();

    public static void hwidCheck() {
        hwids = URLReader.readURL();
        boolean isHwidPresent = hwids.contains(SystemUtil.getSystemInfo());
        if (!isHwidPresent) {
            DisplayUtil.Display();
            throw new NoStackTraceThrowable("");
        }
    }
}

