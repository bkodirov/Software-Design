package factory_method.task;

import java.io.*;

/**
 * Created by Beka on 10.04.17.
 */
public class FileTrace implements Trace {
    private static final String LOG_FILE_NAME = "trace.log";
    private static final String ERR_LOG_FILE_NAME = "err_trace.log";
    private volatile boolean isDebuggable;


    @Override
    public void setDebug(boolean debug) {
        this.isDebuggable = debug;
    }

    @Override
    public void debug(String message) {
        writeToFile(ERR_LOG_FILE_NAME, message);
    }

    private void writeToFile(String fileName, String message) {
        try (FileOutputStream fos = new FileOutputStream(fileName, true)){
            Writer writer = new PrintWriter(fos);
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void error(String message) {
        writeToFile(ERR_LOG_FILE_NAME, message);
    }
}
