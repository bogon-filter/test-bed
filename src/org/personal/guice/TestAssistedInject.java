package org.personal.guice;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.assistedinject.AssistedInject;

public class TestAssistedInject {


    private final TestObject1 object1;
    private final int version;



    @AssistedInject
    public TestAssistedInject(TestObject1 object1, @Assisted int version) {
        this.object1 = object1;
        this.version = version;
    }

    public static void main(String[] args) {
        System.out.println("test assisted inject");

    }

    public static class DefaultConfig implements Module {

        @Override
        public void configure(Binder binder) {

        }

    }


}
