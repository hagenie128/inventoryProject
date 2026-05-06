package service;

import vo.ProductVO;

import java.io.*;
import java.util.ArrayList;

public class InventoryService {
    private static InventoryService instance = new InventoryService();
    private ArrayList<ProductVO> list ;

    private InventoryService() {
        list = new ArrayList<>();
        loadToCSV();
    }
    public void loadToCSV() {
        try (FileReader fr = new FileReader("products.csv");
             BufferedReader br = new BufferedReader(fr)) {
            br.readLine();
            while (true){
                String str = br.readLine();
                if (str == null) break;
                String[] arr = str.split(",");
                list.add(new ProductVO(arr[0], arr[1], Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), arr[5]));
            }
            System.out.println("제품 목록 로드 완료");
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void exportToCSV() {
        try (FileWriter fw = new FileWriter("products.csv");
            PrintWriter pw = new PrintWriter(fw)){
            pw.println("productId,name,price,stock,minStock,category");
            list.forEach(item -> pw.println(item));
            System.out.println("제품 목록 저장 완료");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public ArrayList<ProductVO> getList() {
        return list;
    }
    public static InventoryService getInstance() {
        if (instance == null)
            instance = new InventoryService();
        return instance;
    }
}