package com.uber.cadence.samples.hello;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestMe {
    public static void main(String[] args)throws Exception {
        System.out.println("************************  THIS IS TEST");
        List<String> list=new ArrayList<>();
        list.add("public class test1{");
        list.add(" public static void main(String[] args)throws Exception {");
        list.add(" System.out.println(\"************************  THIS IS  FILE TEST\");}}");
        Files.write(Paths.get("test1.txt"), list);

    }
}
