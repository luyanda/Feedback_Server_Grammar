//package ava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class luyanda {

    public static ArrayList<String> method1(ArrayList<String> arrayList, ArrayList<String> list){
        //ArrayList<String> list = new ArrayList();
        if(list.isEmpty()){
            list.add(arrayList.get(0));
            arrayList.remove(0);
            System.out.println(list.size()+" & "+arrayList.size());
        }
        if(arrayList.size()>0){
            String[] finder = list.get(list.size()-1).split("\n");
            //System.out.println(finder[0]);
            for (String str : arrayList){
                String[] word = str.split("\n");
                if(word[0].endsWith(finder[0])){
                    arrayList.remove(str);
                    return method1(arrayList,list);
                }
                else{
                    list.add(arrayList.get(0));
                    return method1(arrayList,list);
                }
            }
        }
        else
            return list;

        return list;
    }

    public static void main(String args[]) {
        ArrayList<String> list = new ArrayList();
        ArrayList<String> newlist = new ArrayList();
        String sisa = "my favorite girl is always looking at me like feally!\n but i switch her like nop";list.add(sisa);
        String soso = "my favorite girl is always looking at me like Notreally!\n but i switch her like nop";list.add(soso);
        String simo = "my favorite girl is always looking at me like seally!\n but i switch her like nop";list.add(simo);
        String lolo = "my favorite girl is always looking at me like zeally!\n but i switch her like nop";list.add(lolo);
        String koko = "my favorite girl is always looking at me like zeally!\n but i switch her like nop";list.add(koko);
        String nono = "my favorite girl is always looking at me like ceally!\n but i switch her like nop";list.add(nono);
        String m = "my favorite girl is always looking at me like ceally!}\n but i switch her like nop";list.add(m);
        String mo = "my favorite girl is always looking at me like ceally!\n but i switch her like nop";list.add(mo);
        String mom = "my favorite girl is always looking at me like ceally!\n but i switch her like nop";list.add(mom);
        String o = "my favorite girl is always looking at me like ceally!\n but i switch her like nop";list.add(o);
        String om = "my favorite girl is always looking at me like ceally!\n but i switch her like nop";list.add(om);
        String omo = "my favorite girl is always looking at me like ceally\n but i switch her like nop";list.add(omo);
        String lo = "my favorite girl is always looking at me like ceally1\n but i switch her like nop";list.add(lo);
        String lol = "my favorite girl is always looking at me like ceally1\n but i switch her like nop";list.add(lol);

        Collections.sort(list);

        System.out.println(list.size());
        newlist = method1(list, newlist);
        for (String st: newlist) {
            System.out.println(st);
        }

    }
}
