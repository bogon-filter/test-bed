package org.personal.testbed;



public class TestGenerics1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DummyClass dummy = new DummyClass();
        try {
        dummy.throwsException();
        }catch (Throwable t) {
            System.out.println(t.getMessage());
            throw new RuntimeException(t.getMessage(), t);
        }

    }

}
