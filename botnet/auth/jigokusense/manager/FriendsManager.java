/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 */
package botnet.auth.jigokusense.manager;

import com.google.gson.JsonArray;
import java.util.HashSet;
import java.util.Set;

public class FriendsManager {
    public static final Set<String> FRIENDS = new HashSet<String>();

    private FriendsManager() {
    }

    public static boolean isFriend(String name) {
        return FRIENDS.stream().anyMatch(f -> f.equalsIgnoreCase(name));
    }

    public static boolean addFriend(String name) {
        if (FRIENDS.contains(name)) {
            return false;
        }
        return FRIENDS.add(name);
    }

    public static boolean removeFriend(String name) {
        if (!FRIENDS.contains(name)) {
            return false;
        }
        return FRIENDS.remove(name);
    }

    public static void removeAllFriends() {
        FRIENDS.clear();
    }

    public static JsonArray serialize() {
        JsonArray result = new JsonArray();
        FRIENDS.forEach(arg_0 -> ((JsonArray)result).add(arg_0));
        return result;
    }

    public static void deserialize(JsonArray array) {
        array.forEach(f -> FRIENDS.add(f.getAsString()));
    }

    static {
        FRIENDS.add("rianix");
        FRIENDS.add("ItzBlxze");
        FRIENDS.add("bergher");
        FRIENDS.add("Sudmarinz");
        FRIENDS.add("NotSex");
        FRIENDS.add("BlackBro4");
    }
}

