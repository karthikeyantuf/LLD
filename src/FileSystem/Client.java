package FileSystem;

public class Client {
    public static void main(String args[])
    {
        Folder f1 = new Folder("Folder 1:");
        Folder f2 = new Folder("Folder 2:");
        Folder f3 = new Folder("Folder 3:");

        File file1 = new File("File 1" ,"Data of file 1");
        File file2 = new File("File 2" ,"Data of file 2");
        File file3 = new File("File 3" ,"Data of file 3");
        File file4 = new File("File 4" ,"Data of file 4");
        File file5 = new File("File 5" ,"Data of file 5");

        f1.addToContents(file1);
        f1.addToContents(file2);
        f1.addToContents(f2);
        f2.addToContents(file3);
        f2.addToContents(f3);
        f3.addToContents(file4);
        f3.addToContents(file5);

        f1.display(" ");
    }
}
