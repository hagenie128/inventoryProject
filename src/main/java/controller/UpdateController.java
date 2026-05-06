package controller;

import exception.InventoryException;
import service.InventoryService;
import vo.ProductVO;

import java.util.Scanner;

public class UpdateController implements Controller {
    @Override
    public void execute(Scanner sc) {
            System.out.println("물품 정보를 수정합니다.....");
            System.out.print("수정할 물품번호 : ");
            String productId = sc.nextLine();
        try {
            ProductVO vo = InventoryService.getInstance().searchProductId(productId);
            System.out.print("수정할 물품명 : ");
            vo.setName(sc.nextLine());
            System.out.print("수정할 물품 가격 : ");
            vo.setPrice(sc.nextInt()); sc.nextLine();
            System.out.print("수정할 물품 재고 : ");
            vo.setStock(sc.nextInt()); sc.nextLine();
            System.out.print("수정할 물품 최소 재고 : ");
            vo.setMinStock(sc.nextInt()); sc.nextLine();
            System.out.print("수정할 물품 카테고리 : ");
            vo.setCategory(sc.nextLine());
            System.out.print("물품 정보가 수정되었습니다.");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
            System.out.println("물품 정보 수정에 실패하였습니다.");
        }


    }
}
