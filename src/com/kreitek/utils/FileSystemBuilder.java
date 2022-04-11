package com.kreitek.utils;

import com.kreitek.files.Directory;
import com.kreitek.files.File;
import com.kreitek.files.FileSystemItem;

public class FileSystemBuilder {

    private final FileSystemItem root;
    private FileSystemItem currentDirectory;

    public static FileSystemBuilder getBuilder() {
        return new FileSystemBuilder();
    }

    public FileSystemBuilder() {
        root = new Directory(null, "");
        currentDirectory = root;
    }

    public FileSystemBuilder addFile(String name, int size) {
        FileSystemItem file = new File(currentDirectory, name);
        ((File) file).open();
        ((File) file).write(new byte[size]);
        ((File) file).close();
        ((Directory)currentDirectory).addFile(file);
        return this;
    }

    public FileSystemBuilder addDirectory(String name) {
        FileSystemItem directory = new Directory(currentDirectory, name);
        ((Directory)currentDirectory).addFile(directory);
        currentDirectory = directory;
        return this;
    }

    public FileSystemBuilder upOneDirectory() {
        if (currentDirectory.getParent() != null) {
            currentDirectory = currentDirectory.getParent();
        }
        return this;
    }

    public FileSystemItem build() {
        return root;
    }
}
