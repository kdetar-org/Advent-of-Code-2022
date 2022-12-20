package utilities;

import java.util.List;

public class NodeWithList <value>{
    public value val;
    public List<NodeWithList<value>> list;
    
    public NodeWithList(value val, List<NodeWithList<value>> list){
        this.val = val;
        this.list = list;
    }
}
