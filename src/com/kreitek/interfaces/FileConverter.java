package com.kreitek.interfaces;

import com.kreitek.files.File;

public interface FileConverter {
    FileSystemFile convertMp3ToWav(File file);
    FileSystemFile convertWavToMp3(File file);
}
