/*
 * Decompiled with CFR 0.151.
 */
package botnet.auth.jigokusense.util;

public class NoStackTraceThrowable
extends RuntimeException {
    public NoStackTraceThrowable(String msg) {
        super(msg);
        this.setStackTrace(new StackTraceElement[0]);
    }

    @Override
    public String toString() {
        return "1.0.0";
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}

