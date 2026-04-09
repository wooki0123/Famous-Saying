package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    int id = 0;
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
            } else if (cmd.startsWith("삭제")) {
                actionDelete(cmd);
            } else if (cmd.startsWith("수정")) {
                actionEdit(cmd);
            }
        }
        scanner.close();
    }

    void exit() {
        System.out.println("프로그램 종료");
    }

    void actionWrite() {
        System.out.print("명언: ");
        String content = scanner.nextLine().trim();

        System.out.print("작가: ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying = write(content, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }


    WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(++id, content, author);
        wiseSayingList.add(wiseSaying);

        return wiseSaying;
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for (int i = wiseSayingList.size() - 1; i >= 0; i--) {
            WiseSaying wiseSaying = wiseSayingList.get(i);
            System.out.printf("%d / %s / %s\n".formatted(wiseSaying.getId(), wiseSaying.getContent(), wiseSaying.getAuthor()));
        }
    }

    void actionDelete(String cmd) {
        int id = cmdSplit(cmd);

        WiseSaying wiseSaying = findById(id);

        delete(wiseSaying);

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    void delete(WiseSaying wiseSaying) {
        wiseSayingList.remove(wiseSaying);
    }

    void actionEdit(String cmd) {
        int id = cmdSplit(cmd);

        WiseSaying wiseSaying = findById(id);

        modify(wiseSaying);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
    }

    void modify(WiseSaying wiseSaying) {
        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();

        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    WiseSaying findById(int id) {
        WiseSaying wiseSaying = null;
        for (int i = 0; i < wiseSayingList.size(); i++) {
            if (wiseSayingList.get(i).getId() == id) {
                wiseSaying = wiseSayingList.get(i);
            }
        }

        if (wiseSaying == null) {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return null;
        }
        return wiseSaying;
    }

    int cmdSplit(String cmd) {
        String[] cmdBits = cmd.split("=");
        if (cmdBits.length < 2 || cmdBits[1].isEmpty()) {
            System.out.println("ID 값 확인");
            return -1;
        }
        return Integer.parseInt((cmdBits[1]));
    }

}
