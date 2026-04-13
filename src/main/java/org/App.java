package org;

import org.domain.system.SystemController;
import org.domain.wiseSaying.WiseSaying;
import org.domain.wiseSaying.WiseSayingController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner = new Scanner(System.in);
    private final int lastId = 0;
    private final List<WiseSaying> wiseSayingList = new ArrayList<>();
    WiseSayingController wiseSayingController = new WiseSayingController(scanner);

    void run () {
        SystemController systemController = new SystemController();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "종료" -> {
                    systemController.actionExit();
                    return;
                }
                case "등록" -> wiseSayingController.actionWrite();
                case "목록" -> wiseSayingController.actionList();
                case "삭제" -> wiseSayingController.actionDelete(rq);
                case "수정" -> wiseSayingController.actionModify(rq);
            }
        }
    }
}
