/**
 * 多线程批量插入大量数据类
 * @author 韦延伦
 * @version 1.0
 */
public class TestInserBigData {
    public static void main(String[] args) {

        InsertData t1 = new InsertData();
        InsertData t2 = new InsertData();
        InsertData t3 = new InsertData();
        InsertData t4 = new InsertData();
        InsertData t5 = new InsertData();
        InsertData t6 = new InsertData();
        InsertData t7 = new InsertData();
        InsertData t8 = new InsertData();
        InsertData t9 = new InsertData();
        InsertData t10 = new InsertData();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
    }
}
