import allclasses.Pickle;
import java.util.HashMap;

public class cmds {
    public static Pickle pm = new Pickle("./temp/cmds.txt");
    public static HashMap<String, String> hm = new HashMap<>();
    public static HashMap<String, String> no = new HashMap<>();

    public static void main(String[] args) {
        // hm.put("data","no");
        // hm.put("test","yes");
        // pm.wFromHashmap(hm);
        // pm.rToHashmap();
        // no = pm.getHashmap();
        // pm.showHashmap(no);
        pm.fm.delFile();
    }
}
