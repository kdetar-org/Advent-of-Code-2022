package year_2022.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElfNode implements Comparable<ElfNode>{
    List<String> children;
    int size;
    String path;
    Map<String,ElfNode> directoryMap;

    public ElfNode(int size, String path) {
        this.size = size;
        this.path = path;
        children = new ArrayList<String>();
    }

    public ElfNode(int size, String path, List<String> commands, Map<String,ElfNode> directoryMap){
        this.size = size;
        this.path = path;
        this.directoryMap = directoryMap;
        children = new ArrayList<String>();

        //First command for this directory
        String command = commands.remove(0);
        
        //The order of calls in a directory is CD dir (done) LS and CD..
        if(command.equals("$ ls")){
            command = commands.remove(0);
            while(commands.size() >= 0 && command.charAt(0) != '$'){
                String[] file = command.split(" ");

                //if this is a directory
                int memSize = file[0].equals("dir") ? 0 : Integer.parseInt(file[0]);
                String str = file[0].equals("dir") ? path + file[1]+"/" : path + file[1];
                ElfNode child = new ElfNode(memSize, str); 
                children.add(child.path);
                directoryMap.put(child.path, child);
                command = commands.isEmpty() ? "$" : commands.remove(0);
            }
        }


        // for cd.. we just fall off the end of the method
        while(command != null && !commands.isEmpty()){
            if(command.equals("$ cd ..")){
                return;
            }
            else if(command.startsWith("$ cd")){      
                String[] cmdSplit = command.split(" ");
                directoryMap.put(path+cmdSplit[2]+"/", new ElfNode(0, path+cmdSplit[2]+"/", commands, directoryMap));
                command = commands.isEmpty() ? null : commands.remove(0);
            }
        }
    }

    public int getSize() {
        if (size == 0) {
            for (String str : children) {
                size += directoryMap.get(str).getSize();
            }
        }
        return size;
    }

    @Override
    public int compareTo(ElfNode o) {
        return size - o.size;
    }

}
