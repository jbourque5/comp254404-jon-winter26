import java.io.File;

public class Exercise3 {
    public static void find(String path, String filename) {
        File root = new File(path);

        if (!root.exists()) {
            System.out.println("These aren't the paths your looking for.");
            return;
        }

        File[] files = root.listFiles();
        if (files == null) return;

        for (File f : files) {
            if (f.getName().equals(filename)) {
                System.out.println("Found: " + f.getAbsolutePath());
            }
            if (f.isDirectory()) {
                find(f.getAbsolutePath(), filename);
            }
        }
    } public static void main(String[] args) {
        find("C:\\Users\\jonat\\Documents\\Lab3", "Lab3.txt");
    }
}
