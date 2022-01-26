import java.io.*;
import java.util.ArrayList;

public class Storage {

    private String filePath;

    public Storage(String filePath) throws IOException {
        this.filePath = filePath;
    }

    public ArrayList<Task> read() throws Exception {
        File file = new File(filePath);
        ArrayList<Task> list = new ArrayList<>();

        if (file.exists()) {
            BufferedReader r = new BufferedReader(new FileReader(file));
            String t = r.readLine();
            while (!(t == null)) {
                char i = t.charAt(0);
                if (i == 'T') {
                    String[] in = t.split(":");
                    list.add(new Todo(in[2]));
                } else if (i == 'D') {
                    String[] in = t.split(":");
                    list.add(new Deadline(in[2], in[3]));
                } else if (i == 'E') {
                    String[] in = t.split(":");
                    list.add(new Event(in[2], in[3]));
                } else {
                    // do nothing
                }
                t = r.readLine();
            }
        }
        return list;
    }

    public void write(ArrayList<Task> list) throws Exception {
        int n = 0;
        FileWriter fw = new FileWriter(filePath);
        while (n < list.size()) {
            fw.write(list.get(n).toSave() + "\n");
            n+=1;
        }
        System.out.println("Updated");
        fw.close();
    }
}
