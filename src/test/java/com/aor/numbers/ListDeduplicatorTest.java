package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {

    @Test
    public void deduplicate() {
        /*
        class StubSorter implements GenericListSorter {
            @Override
            public List<Integer> sort(List<Integer> list){return Arrays.asList(1,2,2,4,5);}
        }*/

        List<Integer> list = helper();
        List<Integer> expected = Arrays.asList(1,2,4,5);

        GenericListSorter listSorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4, 5));

        ListDeduplicator deduplicator = new ListDeduplicator(listSorter);

        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);

    }

    @Test
    public void bug_deduplicate() {

        List<Integer> list = Arrays.asList(1,2,4,2);
        List<Integer> expected = Arrays.asList(1,2,4);


        GenericListSorter listSorter = Mockito.mock(GenericListSorter.class);
        Mockito.when(listSorter.sort(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 2, 4));

        ListDeduplicator deduplicator = new ListDeduplicator(listSorter);
        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }
    private List<Integer> helper(){
        return Arrays.asList(1,2,4,2,5);
    }
}
