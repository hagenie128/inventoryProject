package main;

import controller.Controller;
import controller.HandlerMapping;
import service.InventoryService;

import java.util.Scanner;

public class WarehouseApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("-- 스마트 창고 관리 프로그램 --");
                System.out.println("1. 물품 등록");
                System.out.println("2. 물품 삭제");
                System.out.println("3. 물품 수정");
                System.out.println("4. 전체 물품 조회");
                System.out.println("5. 물품 입고");
                System.out.println("6. 물품 출고");
                System.out.println("7. 재고 부족 물품 조회");
                System.out.println("8. 창고 총 자산 가치 계산");
                System.out.println("9. 카테고리별 물품 개수 조회");
                System.out.println("10. 물품명 검색");
                System.out.println("11. 카테코리별 검색");
                System.out.println("12. 재고 적은 순 정렬");
                System.out.println("13. 가격 높은 순 정렬");
                System.out.println("0. 프로그램 종료");
                System.out.println("원하시는 메뉴번호를 입력하세요 :");
                int no = sc.nextInt();
                sc.nextLine();

                Controller controller = HandlerMapping.getInstance().createController(no);
                if (controller != null) controller.execute(sc);

                if (no == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }
            }
        } finally {
            InventoryService.getInstance().exportToCSV();
            sc.close();
        }
    }
}
