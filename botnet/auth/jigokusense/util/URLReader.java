/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class URLReader {
    public static List<String> readURL() {
        ArrayList<String> s = new ArrayList<String>();
        try {
            String hwid;
            URL url = new URL("https://pastebin.com/raw/RJf8EZ7y");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((hwid = bufferedReader.readLine()) != null) {
                s.add(hwid);
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return s;
    }
}

