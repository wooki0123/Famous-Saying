package org;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner scanner = new Scanner(System.in);
    List<WiseSaying> wiseSayings = new ArrayList<>();
    int lastId = 0;
    WiseSaying wiseSaying = null;

    void run() {
        System.out.println("==명언 앱==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                actionWrite(lastId);
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

    void actionWrite(int lastId) {
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();

        WiseSaying wiseSaying = write(content, author);

        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSaying.getId()));
    }

    WiseSaying write (String content, String author) {
        WiseSaying wise = new WiseSaying(++lastId, content, author);

        wiseSayings.add(wise);

        return wise;
    }

    void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-----------------------");
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying w = wiseSayings.get(i);
            if (w != null){
                System.out.println("%d %s %s".formatted(w.getId(), w.getAuthor(), w.getContent()));
            }
        }
    }

    void actionDelete(String cmd) {
        int id = cmdBits(cmd);

        delete(id);

        System.out.println("%d번 명언이 삭제되었습니다.".formatted(id));
    }

    void delete(int id) {
        for (int i=0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                wiseSaying = wiseSayings.get(i);
            }
        }
        if (wiseSaying == null) {
            System.out.println("해당 ID는 존재하지 않습니다.");
            return;
        }

        wiseSayings.remove(wiseSaying);
    }

    void actionEdit (String cmd) {
        int id = cmdBits(cmd);

        edit(id);

        System.out.println("%d번 명언이 수정되었습니다.".formatted(id));
    }

    WiseSaying edit (int id) {
        for (int i=0; i < wiseSayings.size(); i++) {
            if (wiseSayings.get(i).getId() == id) {
                wiseSaying = wiseSayings.get(i);
            }
        }
        System.out.printf("명언(기존) : %s \n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = scanner.nextLine().trim();
        wiseSaying.setContent(content);

        System.out.printf("작가(기존) : %s \n", wiseSaying.getAuthor());
        System.out.print("작가 : ");
        String author = scanner.nextLine().trim();
        wiseSaying.setAuthor(author);

        return wiseSaying;
    }

    int cmdBits(String cmd) {
        String[] cmdBits = cmd.split("=");

        if (cmdBits.length < 2 || cmdBits[1].isEmpty()) {
            System.out.println("ID 값을 입력하세요.");
            return -1;
        }

        return Integer.parseInt(cmdBits[1]);
    }
}
