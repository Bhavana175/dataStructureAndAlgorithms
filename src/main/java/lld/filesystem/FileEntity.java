package lld.filesystem;

import java.time.LocalDate;

public class FileEntity {

    private String name;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private Directory parent;

    public FileEntity(String name) {
        this.name = name;
        this.createdAt = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getPath() {
        return (parent == null ? "/" : parent.getPath()) + "/" + name;
    }

    public LocalDate getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt( ) {
        this.modifiedAt = LocalDate.now();
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", parent=" + parent +
                '}';
    }
}
