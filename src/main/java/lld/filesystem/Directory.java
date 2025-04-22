package lld.filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory extends  FileEntity{


    private Map<String, FileEntity> children;

    public Directory(String name) {
        super(name);
        this.children = new HashMap<>();
    }

    //add remove list

    public void add(FileEntity entity){
        entity.setParent(this);
        children.put(entity.getName(), entity);
        setModifiedAt();
    }

    public void remove(String name){
        children.remove(name);
    }

    public List<FileEntity> getList(){
        return new ArrayList<>(children.values());
    }

    public FileEntity getChild(String name ){
        return children.get(name);
    }
}
