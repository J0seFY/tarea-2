public class test {

    public static void main(String[] args) {

        KdTree kd = new KdTree();
        kd.insert(6,4,10);
        kd.insert(3,4,7);
        kd.insert(7,2,9);
        kd.insert(8,5,13);
        kd.insert(2,6,8);
        kd.insert(4,2,6);
        kd.insert(2,3,5);
        System.out.println(kd.factor(2,3));
        System.out.println(kd.factor(6,4));
        System.out.println(kd.factor(2,6));
        System.out.println(kd.factor(10,2));
    }
}
