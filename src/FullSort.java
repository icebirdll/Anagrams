import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FullSort {
    /**
     * <p>
     * Title:全排列算法
     * </p>
     *
     * <p>
     * Copyright: http://blog.csdn.net/sunyujia/
     * </p>
     *
     * @author 孙钰佳
     * @main sunyujia@yahoo.cn
     * @date 2009-04-25 23:57:23 PM
     */
     //将NUM设置为待排列数组的长度即实现全排列
//     private static int NUM = 5;

     /**
      * 递归算法：将数据分为两部分，递归将数据从左侧移右侧实现全排列
      *
      * @param datas
      * @param target
      * @param num: string length
      */
     private static void sort(List<String> datas, List<String> target, int num) {
        if (target.size() == num) {
            System.out.println("datas: " + datas);
            System.out.println("target: " + target);
            System.out.println("num: " + num);
            for (Object obj : target)
                System.out.print(obj);
            System.out.println();
            return;
        }
      for (int i = 0; i < datas.size(); i++) {
       List<String> newDatas = new ArrayList<String>(datas);
       List<String> newTarget = new ArrayList<String>(target);
       newTarget.add(newDatas.get(i));
       newDatas.remove(i);
       sort(newDatas, newTarget, num);
      }
     }

     public static void main(String[] args) {
      String[] datas = new String[] { "a", "b", "1", "2", "3"};
      sort(Arrays.asList(datas), new ArrayList<String>(), datas.length);
     }
}
