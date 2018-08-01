package ru.seet61.spring.logger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger{
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void init() throws IOException {
        this.file = new File(fileName);
        if (!file.exists()) {
            this.file.createNewFile();
        }
        if (!file.canWrite()) {
            throw new IOException("write access error!");
        }
    }

    public void logEvent(String str) throws IOException {
        FileUtils.writeStringToFile(new File(fileName), str, "utf-8");
    }
}
