package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListFiltererTest {
    @Test
    public void positiveFilter(){
        List<Integer> list = Arrays.asList(-1,2,4,-2,5);
        List<Integer> expected = Arrays.asList(2,4,5);

        GenericListFilter filter = new PositiveFilter();
        ListFilterer x = new ListFilterer(filter);
        List<Integer> filtered = x.filter(list);

        Assertions.assertEquals(expected, filtered);
    }

    @Test
    public void divisibleFilter(){
        List<Integer> list = Arrays.asList(8,-9,2,4,-1,5);
        List<Integer> expected = Arrays.asList(8,2,4);

        GenericListFilter filter = new DivisibleByFilter(2);
        ListFilterer x = new ListFilterer(filter);
        List<Integer> filtered = x.filter(list);

        Assertions.assertEquals(expected, filtered);
    }
}
