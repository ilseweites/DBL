abstract public class Quantifier2 {
    private int[] ns;
    private Integer value;

    public Quantifier2(int[] ns) {
        this.ns = ns;
        this.value = null;
    }

    abstract protected int base();
    abstract protected int step(int n, int value);

    public int calculate() {
        if (this.value == null) {
            this.value = base();
            for (int n: ns) {
                this.value = step(n, this.value);
            }
          }
  
          return this.value;
    };

    abstract protected String symbol();

    public String toString() {
        return String.format("(%si: 0 ≤ i < %d: nsᵢ)", this.symbol(), this.ns.length);
    }
    
}
