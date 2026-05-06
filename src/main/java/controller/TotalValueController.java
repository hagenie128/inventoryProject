package controller;

import java.util.Scanner;

public class TotalValueController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("-- 전체 재고 금액 조회 --");
        int totalValue = service.InventoryService.getInstance().getTotalValue();
        System.out.println("전체 재고 금액 : " + totalValue+ "원");
    }
}
