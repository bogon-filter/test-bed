package org.personal.testbed;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Lists;

public class Sort1 {

    //private static final Logger log = LoggerFactory.getLogger(PersistTask.class);
    /**
     * @param args
     */
    public static void main(String[] args) {
        //testDoubles();
        //doOperation();
        //testLogMessages();
    }

    private static void testDoubles() {

        Double d = 210000088888888888888880.032432432432;
        System.out.println(String.format("%.3f", d));

        Status status = Status.valueOf("UP");
        System.out.println(status.name());
        System.out.println(status);

        try {
        testExceptionMessage();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(e.toString());
        }
    }

    private static void testExceptionMessage() {

        throw new IllegalArgumentException("Invalid test");

    }

    private static void doOperation() {
        List<FileInfo> fileList = getFileInfo();
        print(fileList);
        Collections.sort(fileList);
        print(fileList);
    }

    private static void print(List<FileInfo> fileList) {
        for(FileInfo f: fileList) {
            System.out.println(f);
        }
    }

    private static List<FileInfo> getFileInfo() {

        List<FileInfo> results = Lists.newArrayList();
        results.add(new FileInfo("F1", 42l));
        results.add(new FileInfo("F2", 12l));
        results.add(new FileInfo("F3", 332l));
        results.add(new FileInfo("F4", 41l));
        return results;
    }


    public static enum Status {
        UP, DOWN
    }

}
