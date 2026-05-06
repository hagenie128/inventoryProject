package controller;

import java.util.ArrayList;
import java.util.Scanner;

public class CategoryStatsController implements Controller {
    @Override
    public void execute(Scanner sc) {
        System.out.println("-- 카테고리별 통계 조회 --");
        ArrayList<String> stats = service.InventoryService.getInstance().getCategoryStats();
        for (String stat : stats) {
            System.out.println(stat);
        }
    }
}
