package queue;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

import static junit.framework.TestCase.assertEquals;

public class QueueTest {
  public static final String SomethingString = "Something";
  public static final String FirstAddedObject = "First";
  public static final String SecondAddedObject = "Second";
  public static final int QueueSize1 = 1;
  public static final int QueueSize2 = 2;
  //public static final String ExpectedErrorNotThrown = "Expected Error was not thrown.";
  public static final String EmptyQueueError = "Queue is empty";
  private void assertThrowsLike(Executable executable, String expectedMessage) {
    assertEquals(expectedMessage, assertThrows(Error.class, executable).getMessage());
  }

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
    assertThrowsLike(() -> queue.take(), EmptyQueueError);
  }

  @Test public void test11CanNotTakeWhenThereAreNoObjectsInTheQueueAndTheQueueHadObjects() {
    Queue queue = newQueue();
    queue.add( SomethingString );
    queue.take();
    assertThrowsLike(() -> queue.take(), EmptyQueueError);
  }

  @Test public void test12CanNotHeadWhenThereAreNoObjectsInTheQueue() {
    Queue queue = newQueue();
    assertThrowsLike(() -> queue.head(), EmptyQueueError);
  }
}