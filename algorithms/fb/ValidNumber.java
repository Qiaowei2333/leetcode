// lc 65
public class ValidNumber {
    public boolean isNumber(String s) {
        return s.toLowerCase().matches("[+-]?(\\d+(\\.\\d*)?|\\.\\d+)(e[+-]?\\d+)?");
    }

    public void main(String[] args) {
        ValidNumber sol = new ValidNumber();
        boolean res = sol.isNumber("");
        System.out.println(res);
    }
}
