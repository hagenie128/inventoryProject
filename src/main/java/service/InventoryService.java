package service;

import exception.InventoryException;
import vo.ProductVO;

import java.io.*;
import java.util.ArrayList;

public class InventoryService {
    private static InventoryService instance = new InventoryService();
    private final ArrayList<ProductVO> list ;

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

    public void checkDuplicate(String productId) throws InventoryException {
        int idx = list.indexOf(new ProductVO(productId, null, 0, 0, 0, null));
        if (idx != -1){
            throw new InventoryException("이미 존재하는 제품입니다.");
        }
    }
    public boolean insertProduct(ProductVO productVO) {
        return list.add(productVO);
    }

    public void deleteProduct(String productId) throws InventoryException {
        if (!list.remove(new ProductVO(productId, null, 0, 0, 0, null))) {
            throw new InventoryException("존재하지 않는 제품입니다.");
        }
    }
}