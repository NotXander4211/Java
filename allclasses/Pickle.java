package allclasses;
import java.util.HashMap;

//
//-NO idea how to do this but i can do if theres no whitespace and i get both types
//and theres a split function-- ok so theres split
//
//
public class Pickle {
    String FPATH;
    public FileManagement fm;
    public HashMap<String, String> hm = new HashMap<>();
    public String fdata;


    public Pickle(String _filepath){
        this.FPATH = _filepath;
        this.fm = new FileManagement(_filepath);
    }

    public void rToHashmap(){
        fdata = this.fm.readData();
        try{
            final String[] kvpairs = fdata.split(",");
            for (String key : kvpairs){
                //System.out.println(key);
                String[] kv = key.split(":");
                //System.out.println(kv[0] + " - " + kv[1]);
                hm.put(kv[0],kv[1]);
            }
        }catch(Exception e){
            fm.logger.warning("man idk");
        }
    }

    public void wFromHashmap(){
        String toWrite = "";
        int i = 0;
        for (String kay: hm.keySet()){
            i++;
            toWrite += kay + ":" + hm.get(kay);
            if (i < hm.size()){
                toWrite += ",";
            }
            
        }
        fm.writeData(toWrite, false);
    }

    public void wFromHashmap(HashMap<String, String> hMap){
        String toWrite = "";
        int i = 0;
        for (String kay: hMap.keySet()){
            i++;
            toWrite += kay + ":" + hMap.get(kay);
            if (i < hMap.size()){
                toWrite += ",";
            }
            
        }
        fm.writeData(toWrite, false);
    }

    public HashMap<String, String> getHashmap(){
        return hm;
    }

    public void showHashmap(){
        for (String i: hm.keySet()){
            System.out.println(i + "-" + hm.get(i));
        }
    }

    public void showHashmap(HashMap<String,String> _hm){
        for (String i: _hm.keySet()){
            System.out.println(i + "-" + _hm.get(i));
        }
    }

    public static void main(String[] args) {
        Pickle pm = new Pickle("./temp/pickletest.txt");
        pm.rToHashmap();
        pm.wFromHashmap();
        HashMap<String, String> rmap = new HashMap<>();
        rmap.put("key","value");
        pm.wFromHashmap(rmap);
        pm.rToHashmap();
        pm.showHashmap();
    }
}
