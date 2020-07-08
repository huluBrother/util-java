package org.zhx.poi;

import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        String fileNmae = "lzCard.xlsx";
        List<String[]> rows =  POIUtil.readExcel(fileNmae);
        for(String[] row : rows){
            System.out.println(row.length + ":");
//            for(String col : row){
//                System.out.print(col+" ");
//            }
//            System.out.println();
        }
        System.out.println((1 << 4));
    }
}
