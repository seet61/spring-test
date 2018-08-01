package ru.seet61.spring.logger;

import org.apache.commons.io.FileUtils;
import ru.seet61.spring.event.Event;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.canWrite()) {
            throw new IOException("write access error!");
        }
    }

    public void logEvent(String str) throws IOException {
        FileUtils.writeStringToFile(this.file, str, "utf-8");
    }

    public void logEvent(Event event )throws IOException {
        FileUtils.writeStringToFile(this.file, event.toString(), "utf-8");
    }
}
