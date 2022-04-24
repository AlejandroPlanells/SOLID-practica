package com.kreitek.interfaces;

import com.kreitek.files.Directory;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    Directory getParent();
    void setParent(Directory directory);

    String getFullPath();
    int getSize();




}
