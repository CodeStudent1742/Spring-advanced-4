package com.proxy;

import com.proxy.db.DbDataRetriever;
import com.proxy.db.LazyDataRetrieverProxy;
import com.proxy.db.PostgresDataRetriever;

import java.util.Random;

public class ProxyApp {

    public static void main(String[] args) throws InterruptedException {
        long begin = System.currentTimeMillis();
        for (int n = 0; n < 5; n++) {
            DbDataRetriever dbDataRetriever = new LazyDataRetrieverProxy();
            int number = new Random().nextInt(100);
            if (number < 10)
                System.out.println(dbDataRetriever.getFirstValue());
            else if (number < 20)
                System.out.println(dbDataRetriever.getSecondValue());
            else if (number < 30)
                System.out.println(dbDataRetriever.getThirdValue());

            System.out.println("Execution #" + n + " just finished");
        }

        long end = System.currentTimeMillis();
        System.out.println("The execution took: " + (end - begin) + " [ms]");
    }

}
