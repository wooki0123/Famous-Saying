package org;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("==명언 앱==");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("명령)");
            String cmd = scanner.nextLine().trim();
            
            if(cmd.equals("종료")) {
                System.out.println("프로그램 종료");
                break;
            } else if (cmd.equals(("등록"))) {
                System.out.println("명언: ");
                String wiseSayingContent = scanner.nextLine().trim();

                System.out.println("작가: ");
                String wiseSayingAuthor = scanner.nextLine().trim();

                System.out.println("번 명언이 등록되었습니다.");
            }
        }
    }
}
