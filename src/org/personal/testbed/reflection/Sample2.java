package org.personal.testbed.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sample2 {

    int count =0;
    String name = "Hulk";

    /**
     * @param args
     * @throws NoSuchFieldException
     * @throws SecurityException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static void main(String[] args) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

        testDoubleMath();


        Class c = Sample2.class;
        Field[] fields = c.getDeclaredFields();
        Field f = fields[0];
        f.getType();
        f.getGenericType(); // captures generic type info which is erased in getType()

        //set value of a field
        Sample2 mainClass = new Sample2();
        System.out.println("value of count before " + mainClass.count);
        f = c.getDeclaredField("count");
        f.setInt(mainClass, 45);
        System.out.println("value of count after " + mainClass.count);

        //while setting value during reflection, boxing and unboxing may not be possible


    }

    private static void testDoubleMath() {

        Double totalAmount = 79.0;
        String unitPrice = "40.0";
        long Quantity = computeQuantity(totalAmount, unitPrice);
        System.out.println(Quantity);

        //npe
        Integer a = null;
        //System.out.println(a.intValue());
        //npe
        //a = -a;
        //System.out.println(a);

        if (null instanceof Double ) {
            System.out.println("null instance of object");
        }

        System.exit(1);

    }
    private static long computeQuantity(Double totalAmount, String unitPrice) {
        BigDecimal dbValue = BigDecimal.valueOf(totalAmount)
                .divide(new BigDecimal(unitPrice), 1, RoundingMode.HALF_UP);
        System.out.println(dbValue);
        return dbValue.longValue();
    }

}
