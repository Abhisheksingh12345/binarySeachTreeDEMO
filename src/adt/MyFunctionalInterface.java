package adt;

@FunctionalInterface // condition--> contain only one abstract mehtod.
public interface MyFunctionalInterface {
    public abstract int giveMeARandomNumber();

    default void print() {
        System.out.println("Hello");
    }
    static void traverse() {
        System.out.println("OK");
    }

//    public abstract void m();
}

class Main implements MyFunctionalInterface {

    public static void main(String[] args) {
        MyFunctionalInterface ref = () -> (int) (Math.random() * 100);
        System.out.println(ref.giveMeARandomNumber());
    }
    public int randomNo(){
        return (int) Math.random()*100;
    }


    @Override
    public int giveMeARandomNumber() {
        return randomNo();
    }

    @Override
    public void print() {

    }
}