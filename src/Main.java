import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String[] pathNames = new String[]{
                "D:\\Games\\src",
                "D:\\Games\\src\\main",
                "D:\\Games\\src\\test",
                "D:\\Games\\res",
                "D:\\Games\\res\\drawables",
                "D:\\Games\\res\\vectors",
                "D:\\Games\\res\\icons",
                "D:\\Games\\savegames",
                "D:\\Games\\temp",
        };

        String[] fileNames = new String[]{
                "D:\\Games\\src\\main\\Main.java",
                "D:\\Games\\src\\main\\Utils.java",
                "D:\\Games\\temp\\temp.txt"
        };

        StringBuilder logBuilder = new StringBuilder();

        // Create folders and sub folders
        for (String pathName : pathNames) {
            File path = new File(pathName);
            try {
                if (path.mkdir()) {
                    logBuilder.append("Directory ").append(path).append(" created \n");
                } else {
                    logBuilder.append("Directory ").append(path).append(" is not created \n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Create files
        for (String fileName : fileNames) {
            File file = new File(fileName);
            try {
                if (file.createNewFile()) {
                    logBuilder.append("File ").append(file).append(" created \n");
                } else {
                    logBuilder.append("File ").append(file).append(" is not created \n");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        File logFile = new File(fileNames[fileNames.length - 1]);

        // Write log file
        String logString = logBuilder.toString();
        try (FileOutputStream fileOutputStream = new FileOutputStream(logFile)) {
            byte[] bytes = logString.getBytes();
            fileOutputStream.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
