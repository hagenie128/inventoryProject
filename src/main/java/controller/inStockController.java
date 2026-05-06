package controller;

import exception.InventoryException;
import vo.ProductVO;

import java.util.Scanner;

public class inStockController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("물품 입고를 진행합니다.....");
        System.out.print("입고할 물품번호 : ");
        String productId = sc.nextLine();
        try {
            ProductVO vo = service.InventoryService.getInstance().searchProductId(productId);
            int oldStock = vo.getStock();
            System.out.print("입고할 수량 : ");
            int amount = sc.nextInt(); sc.nextLine();
            vo.setStock(oldStock + amount);
            System.out.println(vo.getName() + "의 재고가 "
                    + amount + "개 입고되었습니다. 현재 재고 : " + vo.getStock() + "개");
            System.out.println("물품 입고가 완료되었습니다.");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            System.out.println("물품 입고에 실패하였습니다.");
        }
    }
}
