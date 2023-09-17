package queue;

import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

import static junit.framework.TestCase.assertEquals;

public class QueueTest {
    public static final String somethingString = "Something";
    public static final String firstAddedObject = "First";
    public static final String secondAddedObject = "Second";
    public static final int queueSize1 = 1;
    public static final int queueSize2 = 2;
    public static final String emptyQueueError = "Queue is empty";

    private void assertThrowsLike(Executable executable, String expectedMessage) {
        assertEquals(expectedMessage, assertThrows(Error.class, executable).getMessage());
    }

    private static Queue newQueue() {
        return new Queue();
    }

    private static Queue queueWithSomething() {
        return new Queue().add(somethingString);
    }

    private static Queue queueWithFirstAndSecondObjects() {
        Queue queue = newQueue();
        queue.add(firstAddedObject);
        queue.add(secondAddedObject);
        return queue;
    }

    @Test
    public void test01QueueShouldBeEmptyWhenCreated() {
        assertTrue(newQueue().isEmpty());
    }

    @Test
    public void test02AddElementsToTheQueue() {
        assertFalse(queueWithSomething().isEmpty());
    }

    @Test
    public void test03AddedElementsIsAtHead() {
        assertEquals(somethingString, queueWithSomething().head());
    }

    @Test
    public void test04TakeRemovesElementsFromTheQueue() {
        Queue queue = queueWithSomething();
        queue.take();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void test05TakeReturnsLastAddedObject() {
        Queue queue = newQueue();
        queue.add(somethingString);

        assertEquals(somethingString, queue.take());
    }


    @Test
    public void test06QueueBehavesFIFO() {
        Queue queue = queueWithFirstAndSecondObjects();

        assertEquals(queue.take(), firstAddedObject);
        assertEquals(queue.take(), secondAddedObject);
        assertTrue(queue.isEmpty());
    }


    @Test
    public void test07HeadReturnsFirstAddedObject() {
        Queue queue = queueWithFirstAndSecondObjects();

        assertEquals(queue.head(), firstAddedObject);
    }

    @Test
    public void test08HeadDoesNotRemoveObjectFromQueue() {
        Queue queue = newQueue();
        queue.add(somethingString);

        assertEquals(queueSize1, queue.size());

        queue.head();

        assertEquals(queueSize1, queue.size());
    }

    @Test
    public void test09SizeRepresentsObjectInTheQueue() {
        assertEquals(queueSize2, new Queue().
                add(firstAddedObject).
                add(secondAddedObject).
                size());
    }

    @Test
    public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
        Queue queue = newQueue();
        assertThrowsLike(queue::take, emptyQueueError);
    }

    @Test
    public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
        Queue queue = newQueue();
        queue.add(somethingString);
        queue.take();
        assertThrowsLike(queue::take, emptyQueueError);
    }

    @Test
    public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
        Queue queue = newQueue();
        assertThrowsLike(queue::head, emptyQueueError);
    }
}