package com.core;

import com.domain.Staff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class GsonExample1 {

    public static void main(String[] args) {

        // pretty print
        List<Staff> staffList = new ArrayList<>();
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Gson gson = new GsonBuilder()
                .setExclusionStrategies(new CustomExclusionStrategy(List.class)) // exclude all List fields.
                .create();

       /* Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .excludeFieldsWithoutExposeAnnotation()
                .create();*/

        Staff staff1 = createStaffObject1();
        Staff staff2 = createStaffObject2();
        staffList.add(staff1);
        staffList.add(staff2);

        String json = gson.toJson(staffList);
        try (FileWriter writer = new FileWriter("student.json")) {
            gson.toJson(staffList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*for (Staff staff : staffList) {
            // Java objects to String
            String json = gson.toJson(staff);
            try (FileWriter writer = new FileWriter("student.json", true)) {
                gson.toJson(staff, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/



    }

    private static Staff createStaffObject1() {

        Staff staff = new Staff();

        staff.setName("oleg");
        staff.setAge(35);
        staff.setPosition(new String[]{"Founder", "SEO", "coder"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2010", new BigDecimal(10000));
            put("2012", new BigDecimal(12000));
            put("2018", new BigDecimal(14000));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("java", "python", "node", "kotlin"));

        return staff;

    }

    private static Staff createStaffObject2() {

        Staff staff = new Staff();

        staff.setName("Jorik");
        staff.setAge(20);
        staff.setPosition(new String[]{"Mover", "Developer"});
        Map<String, BigDecimal> salary = new HashMap() {{
            put("2020", new BigDecimal(1000));
            put("2022", new BigDecimal(500));
        }};
        staff.setSalary(salary);
        staff.setSkills(Arrays.asList("moving", "kotlin"));

        return staff;

    }

}