package lld.filesystem;

public class File extends FileEntity{

    private String name ;
    private String content;

    public File(String name) {
        super(name);
    }

    public String read(){
        return this.content;
    }

    public void write(String content){
        this.content = content;
        setModifiedAt();
    }

    public int getSize(){
        return content.length();
    }
}
