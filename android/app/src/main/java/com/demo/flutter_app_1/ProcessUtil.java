package com.demo.flutter_app_1;
import android.os.Process;
import java.io.File;
import java.util.Map;

public class ProcessUtil {
    public static int getFdCount() {
        File fdFile = new File("/proc/" + Process.myPid() + "/fd");
        if (fdFile == null) {
            return 0;
        }
        File[] files = fdFile.listFiles();
        if (files != null) {
            return files.length;
        }
        return 0;
    }

    public static int getActiveThreadCount() {
        Map<Thread, StackTraceElement[]> stacks = Thread.getAllStackTraces();
        return stacks.size();
    }
}
