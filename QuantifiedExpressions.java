public class QuantifiedExpressions {

    public static void main(String[] args) {
        int[] ns = {1,2,3,4,5,6,7,8,9};
        Quantifier2 p = new ProductQuantifier2(ns);
        Quantifier2 s = new SumQuantifier2(ns);

        System.out.print(p);
        System.out.print(" - ");
        System.out.print(s);
        System.out.print(" = ");
        System.out.println(p.calculate() - s.calculate());
    }
    
}
