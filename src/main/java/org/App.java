package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int lastId = 0;
    List<WiseSaying> wiseSayingList = new ArrayList<>();

    void run() {

        System.out.println("==명언 앱==");
        while (true) {
            System.out.print("명령)");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                exit();
                break;
            } else if (cmd.equals(("등록"))) {
                actionWrite();
            } else if (cmd.equals("목록")) {
                actionList();
            }
        }
    }
    void exit() {
        System.out.println("프로그램 종료");
    }
    void actionWrite() {
        System.out.print("명언: ");
        String wiseSayingContent = scanner.nextLine().trim();

        System.out.print("작가: ");
        String wiseSayingAuthor = scanner.nextLine().trim();

        System.out.printf("%d번 명언이 등록되었습니다.\n", lastId + 1);

        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = lastId;
        wiseSaying.content = wiseSayingContent;
        wiseSaying.author = wiseSayingAuthor;

        wiseSayingList.add(wiseSaying);

        lastId++;
    }
    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n".formatted(wiseSaying.id+1, wiseSaying.content, wiseSaying.author));
        }
    }
}
