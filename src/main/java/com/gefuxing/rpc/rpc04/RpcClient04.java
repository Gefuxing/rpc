package com.gefuxing.rpc.rpc04;

import com.gefuxing.rpc.model.School;
import com.gefuxing.rpc.service.SchoolService;


import java.io.IOException;
import java.util.Scanner;

public class RpcClient04 {
    public static void main(String[] args) throws IOException {
        while (true) {
            SchoolService schoolService = (SchoolService) Stud04.getStud(SchoolService.class);
            Scanner input = new Scanner(System.in);
            int id = input.nextInt();
            School bySchool = schoolService.findBySchool(id);

            System.out.println("rpc04:" + bySchool);

        }
    }
}