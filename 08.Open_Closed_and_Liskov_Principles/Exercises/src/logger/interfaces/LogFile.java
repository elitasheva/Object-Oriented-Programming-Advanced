package logger.interfaces;

public interface LogFile {
    void write(String message);
    int getSize();
}
