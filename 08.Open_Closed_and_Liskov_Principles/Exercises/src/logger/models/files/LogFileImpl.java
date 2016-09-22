package logger.models.files;

import logger.interfaces.LogFile;

public class LogFileImpl implements LogFile {

    private StringBuilder sb;
    private int size;

    public LogFileImpl() {
        this.sb = new StringBuilder();
        this.size = 0;
    }

    @Override
    public void write(String message) {
        sb.append(message);
        caclculateMessageSize(message);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    private void caclculateMessageSize(String message) {
        int currentMessageSize = 0;
        for (int i = 0; i < message.length(); i++) {
            if ((message.charAt(i) >= 65 && message.charAt(i) <= 90) ||
                    (message.charAt(i) >= 97 && message.charAt(i) <= 122)){
                currentMessageSize += message.charAt(i);
            }
        }

        this.size += currentMessageSize;
    }
}
