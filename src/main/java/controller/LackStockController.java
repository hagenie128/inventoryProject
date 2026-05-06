package controller;

import service.InventoryService;
import vo.ProductVO;

import java.util.ArrayList;
import java.util.Scanner;

public class LackStockController implements Controller {
    @Override
    public void execute(Scanner sc) {
            System.out.println("-- 재고 부족 물품 조회 --");
        ArrayList<ProductVO> list = InventoryService.getInstance().getLackStockList();

        for (ProductVO vo : list) {
            System.out.println(vo);
        }
    }
}
