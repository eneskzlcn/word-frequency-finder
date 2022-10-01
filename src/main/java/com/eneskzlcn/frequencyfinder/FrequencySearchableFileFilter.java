package com.eneskzlcn.frequencyfinder;

import java.io.File;
import java.io.FileFilter;

public class FrequencySearchableFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isFile() && pathname.canRead() && (pathname.getFreeSpace() != pathname.getTotalSpace())) {
            return true;
        }
        return false;
    }
}
