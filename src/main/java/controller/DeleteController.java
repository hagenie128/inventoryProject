package controller;

import exception.InventoryException;
import service.InventoryService;

import java.util.Scanner;

public class DeleteController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("물품 정보를 삭제합니다.....");
        System.out.print("삭제할 물품번호 : ");
        String productId = sc.nextLine();

        try{
            InventoryService.getInstance().deleteProduct(productId);
            System.out.println("물품이 삭제되었습니다.");
        } catch (InventoryException e) {
            System.out.println(e.getMessage());
        }

    }
}
