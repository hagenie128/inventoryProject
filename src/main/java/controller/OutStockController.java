package controller;

import exception.InventoryException;
import vo.ProductVO;

import java.util.Scanner;

public class OutStockController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("물품 출고를 진행합니다.....");
        System.out.print("출고할 물품번호 : ");
        String productId = sc.nextLine();
        try {
            ProductVO vo = service.InventoryService.getInstance().searchProductId(productId);
            int oldStock = vo.getStock();
            System.out.print("출고할 수량 : ");
            int amount = sc.nextInt(); sc.nextLine();

            if(oldStock < amount ) {
                System.out.println("출고 수량이 재고보다 많습니다.");
                System.out.println("출고할 수량을 다시 입력해주세요.");
                System.out.println("현재 재고 : " + vo.getStock() + "개");
                return;
            }
            vo.setStock(oldStock - amount);
            System.out.println(vo.getName() + "의 재고가 "
                    + amount + "개 출고되었습니다. 현재 재고 : " + vo.getStock() + "개");
            System.out.println("물품 출고가 완료되었습니다.");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            System.out.println("물품 출고에 실패하였습니다.");
        }
    }
}
