package controller;

import exception.InventoryException;
import service.InventoryService;
import vo.ProductVO;

import java.util.Scanner;

public class InsertController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("물품 정보를 추가합니다.....");
        System.out.print("등록할 물품번호 : ");
        String productId = sc.nextLine();

        try{
            //중복체크
            InventoryService.getInstance().checkDuplicate(productId);
                System.out.print("등록할 물품명 : ");
                String name = sc.nextLine();
                System.out.print("등록할 물품 가격 : ");
                int price = sc.nextInt(); sc.nextLine();
                System.out.print("등록할 물품 재고 : ");
                int stock = sc.nextInt(); sc.nextLine();
                System.out.print("등록할 물품 최소 재고 : ");
                int minStock = sc.nextInt(); sc.nextLine();
                System.out.print("등록할 물품 카테고리 : ");
                String category = sc.nextLine();

                boolean flag = InventoryService.getInstance().insertProduct
                        (new ProductVO(productId, name, price, stock, minStock, category));
            System.out.println(flag ? "물품이 등록되었습니다." : "물품 등록에 실패하였습니다.");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        }

    }
}
