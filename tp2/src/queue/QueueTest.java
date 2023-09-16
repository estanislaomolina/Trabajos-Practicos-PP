package queue;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class QueueTest {
  public static final String SomethingString = "Something";
  public static final String FirstAddedObject = "First";
  public static final String SecondAddedObject = "Second";
  public static final int QueueSize1 = 1;
  public static final int QueueSize2 = 2;
  public static final String ExpectedErrorNotThrown = "Expected Error was not thrown.";
  public static final String EmptyQueueError = "Queue is empty";

  private static Queue newQueue() {
      return new Queue();
  }
  private static Queue QueueWithSomething() {
    return new Queue().add(SomethingString);
  }
  private static Queue QueueWithFirstAndSecondObjects() {
    Queue queue = newQueue();
    queue.add(FirstAddedObject);
    queue.add(SecondAddedObject);
    return queue;
  }

  @Test public void test01QueueShouldBeEmptyWhenCreated() {
    assertTrue( new Queue().isEmpty() );
  }

  @Test public void test02AddElementsToTheQueue() {
    assertFalse( QueueWithSomething().isEmpty() );
  }

  @Test public void test03AddedElementsIsAtHead() {
    assertEquals(SomethingString, QueueWithSomething().head() );
  }

  @Test public void test04TakeRemovesElementsFromTheQueue() {
    Queue queue = QueueWithSomething();
    queue.take();
    
    assertTrue( queue.isEmpty() );
  }

  @Test public void test05TakeReturnsLastAddedObject() {
    Queue queue = newQueue();
    String addedObject = SomethingString;
    queue.add( addedObject );
    
    assertEquals( addedObject, queue.take() );
  }


  @Test public void test06QueueBehavesFIFO() {
    Queue queue = QueueWithFirstAndSecondObjects();

    assertEquals( queue.take(), FirstAddedObject);
    assertEquals( queue.take(), SecondAddedObject);
    assertTrue( queue.isEmpty() );
  }


  @Test public void test07HeadReturnsFirstAddedObject() {
    Queue queue = QueueWithFirstAndSecondObjects();

    assertEquals( queue.head(), FirstAddedObject );
  }

  @Test public void test08HeadDoesNotRemoveObjectFromQueue() {
    Queue queue = newQueue();
    queue.add( SomethingString );

    assertEquals(QueueSize1, queue.size() );

    queue.head();

    assertEquals(QueueSize1, queue.size() );
  }

  @Test public void test09SizeRepresentsObjectInTheQueue() {
    assertEquals(QueueSize2, new Queue().add( FirstAddedObject ).add( SecondAddedObject ).size() );
  }

  @Test public void test10CanNotTakeWhenThereAreNoObjectsInTheQueue() {
    Queue queue = newQueue();
    try {
      queue.take();
      fail(ExpectedErrorNotThrown);
    } catch (Error e) {
      assertTrue( e.getMessage().equals(EmptyQueueError) );
    }
  }

  @Test public void test09CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = newQueue();
    queue.add( SomethingString );
    queue.take();
    try {
      queue.take();
      fail(ExpectedErrorNotThrown);
    } catch (Error e) {
      assertTrue( e.getMessage().equals(EmptyQueueError) );
    }
  }

  @Test public void test10CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = newQueue();
    try {
      queue.head();
      fail(ExpectedErrorNotThrown);
    } catch (Error e) {
      assertTrue( e.getMessage().equals(EmptyQueueError) );
    }
  }
}