package com.simple.bus.test.jdbc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.simple.bus.jdbc.BusJdbcRepository;
import com.simple.entity.vehicle.Bus;

public class BusJdbcRepositoryTest {

private static final int THREAD_COUNT = 150;
    
    @Autowired
    private BusJdbcRepository busRepo;

    @Test
    public void testBusCorrectId() throws InterruptedException, ExecutionException {
        Callable<Long> task = new Callable<Long>() {
            @Override
            public Long call() {
                Bus bus = new Bus();
                return busRepo.createBus(bus, false);
            }
        };
        List<Callable<Long>> tasks = Collections.nCopies(THREAD_COUNT, task);
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<Long>> futures = executorService.invokeAll(tasks);
        List<Long> resultList = new ArrayList<Long>(futures.size());
        // Check for exceptions
        for (Future<Long> future : futures) {
            // Throws an exception if an exception was thrown by the task.
            resultList.add(future.get());
        }
        // Validate the IDs
        Assert.assertEquals(THREAD_COUNT, futures.size());
        List<Long> expectedList = new ArrayList<Long>(THREAD_COUNT);
        for (long i = 1; i <= THREAD_COUNT; i++) {
            expectedList.add(i);
        }
        Collections.sort(resultList);
        Assert.assertEquals(expectedList, resultList);
    }
}
