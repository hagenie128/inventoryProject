package controller;

import service.InventoryService;
import vo.ProductVO;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllController implements Controller {
    @Override
    public void execute(Scanner sc) {
            System.out.println("-- 전체 물품 조회 --");
        ArrayList<ProductVO> list = InventoryService.getInstance().getList();

        for (ProductVO vo : list) {
            System.out.println(vo);
        }
    }
}
