package lld.filesystem;

public class Main {

    public static void main(String[] args) {

        FileSystem fs = new FileSystem();
        Directory images = fs.getRoot();
        File pic = new File("ab123.jpg");
        images.add(pic);
        pic.write("this is image content ");

        System.out.println(pic.getPath());
        System.out.println("File path: " + pic.getPath());
        System.out.println("File content: " + pic.read());
        System.out.println("File size: " + pic.getSize() + " characters");
        System.out.println("Created at: " + pic.getCreatedAt());
        System.out.println("Modified at: " + pic.getModifiedAt());
        System.out.println("Modified at: " + images.getList());
        System.out.println("Modified at: " + images.getChild("ab123.jpg"));
    }
}
