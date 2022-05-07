package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonExample2 {

    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("student.json")) {

            // Convert JSON File to Java Object
            //??

            Type type = new TypeToken< List<Staff>>(){}.getType();
            List<Staff> staffList = gson.fromJson(reader, type);
            //List<Staff> staffList = gson.fromJson(reader, Staff.class);

            // print staff
            for (Staff staff : staffList) {
                System.out.println(staff);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}