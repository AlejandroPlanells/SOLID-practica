package com.kreitek.files;

import java.util.List;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);

    String getFullPath();
    int getSize();




}
